package sorting;

public class sorting {
	public static void main(String[]args)
	{
		final long startTime = System.currentTimeMillis(); // this will get the current time when the program starts
		int [] unsortedArray = {35,76,3,8,13};
		int [] sortedArray = insertionSort(unsortedArray); // this will go to the insertionSort method
		System.out.println(sortedArray);
		final long endTime = System.currentTimeMillis();
		long duration = startTime - endTime;
		System.out.println("The time in ms it took to do this prgram was: "+ duration);

	}

	public static int[] insertionSort(int[]list)
	{
		for (int i = 1; i <list.length; i ++) // iterates through the indexes
		{
			int temp = list[i];
			int j = i;
			while (j>0 && list[j-1]>temp)// while the index is greater than 0 and previous index is greater than our holding temp value
			{
				list[j] = list[j-1]; // 
				j -- ;

			}
			list[j]=temp;

		}
		return list;



	}

}
