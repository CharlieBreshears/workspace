
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class is the main class for Assignment 2 which extends J Frame
 * @author Charles Breshears
 *
 */

public class Assignment2 extends JFrame{
	/**
	 * 
	 * @param args this is the start of the program, 
	 * GUI is made here
	 */

	public static void main(String[]args){
		
		// This is the Frame and sets the name and size of it
		JFrame myFrame = new JFrame("Convert Binary to Decimal");
		myFrame.setSize(600, 200);
		
		//Sets the panel
		JPanel myPanel = new JPanel(new GridLayout(3,2));
		
		// Sets the labels, text fields and buttons
		JLabel binaryLabel = new JLabel("Binary String");
		JLabel decimalLabel = new JLabel("Decimal String");
		
		JTextField inputField = new JTextField(30);
		JTextField outputField = new JTextField(30);
		
		JButton myButton = new JButton("Convert to Decimal");
		
		//adds the elements to the frame and panel
		myFrame.add(myPanel);
		myPanel.add(binaryLabel);
		myPanel.add(inputField);
		myPanel.add(decimalLabel);
		myPanel.add(outputField);
		myPanel.add(myButton, BorderLayout.SOUTH);
		myFrame.setVisible(true);
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits programs when x or red is pressed
		
		myButton.addActionListener(new ActionListener(){ // when button is pressed do this
			public void actionPerformed(ActionEvent e){
				String textFieldBinary = inputField.getText();
				String text= parseBinary(textFieldBinary);
				outputField.setText(text);
				
				
			}
		});

	}
	/**
	 * This method takes in the binary string and converts it to a decimal string and sends it back to the gui
	 * @param binaryString is what we took in from the user
	 * @return converted decimal string
	 */
	public static String parseBinary (String binaryString){ // here is where the conversion takes place at
		try{
		int i =Integer.parseInt(binaryString,2);
		String strI = Integer.toString(i);
		return strI;
		}
		catch (NumberFormatException nfe){
			String errorMessage= ("NumberFormatException: "+ nfe.getMessage());
			return errorMessage; // returns the error message
			
		}



	}// parseBinary
} // end main
