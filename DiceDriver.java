// --------------------------------------------------------------------------------------------------------------------
// DiceDriver.java					3/18/2017
// Author: Alissa Symes
// 
// GUI Driver for my D&D Dice Program
// --------------------------------------------------------------------------------------------------------------------

import javax.swing.JFrame ;

public class DiceDriver
{
	public static void main (String [] arguments)
	{
		JFrame frame = new JFrame("D&D Dice!") ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		
		DicePanel panel = new DicePanel() ;
		frame.getContentPane().add(panel) ;
		
		frame.pack() ;
		frame.setVisible(true) ;
	}
}