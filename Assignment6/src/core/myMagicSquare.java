package core;
import java.util.*;


public class myMagicSquare{
	public static String main(String magicSquareNum){
		MagicSquare class1 = new MagicSquare();
		//String magicSquareNum = "";
		String myOutput= class1.myMagicSquare(magicSquareNum);
		return myOutput;
	}
	
}
class MagicSquare { 
	// here is where we make the magic square and test if it is indeed a magic square
	// some of the original code has been comment out


	public String myMagicSquare (String magicSquareNum) {
		//Scanner input = new Scanner (System.in);
		
		// will make the number a string to get the length of it
		
		// this x will be used to hold n (length of number)
		
		double xlength,y;
		//System.out.println("Please enter the magic square in one line: ");
		//String magicSquareNum = input.nextLine();
		
		xlength = magicSquareNum.length();
		
		y = Math.sqrt(xlength);
		ArrayList <Character> list = new ArrayList<Character>();
		

		if (y%1 != 0){
			return("false");
			
		}
		
		else{
			//The following makes the input into an arraylist 
			for (int i = 0; i < xlength; i ++){
				list.add(magicSquareNum.charAt(i));	
				}
			//System.out.println(list);
			
			int d = 0; // this will say if there are duplicates or not 
			
			// process for finding duplicates
			for (int j = 0; j<xlength; j++){
				for (int k = j+1; k <xlength; k++){
					if (k!=j && list.get(k) == list.get(j)){
						d = 1;
					}
				}
			}
			if (d == 1){
				return("false");
			}
			else{
				List<Integer> intList = new ArrayList <Integer>(list.size());
				for (Character myInt : list){
					intList.add(Integer.valueOf(myInt-48));
				}
				//System.out.println(intList);
				if (intList.get(0)+intList.get(1) + intList.get(2) == intList.get(0)+ intList.get(3)+ intList.get(6)){
					return("true");
				}
				else{
					return("false");
				}
				
			}
			
			
		}// end else
		
	}
	//end main

}//end class


