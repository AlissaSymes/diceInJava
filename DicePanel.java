// --------------------------------------------------------------------------------------------------------------------
// DicePanel.java					3/18/2017
// Author: Alissa Symes
// 
// Program to roll dice in D&D
// --------------------------------------------------------------------------------------------------------------------

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import java.util.Random ;

public class DicePanel extends JPanel
{
	// ----------------------------------------------------------------------------------------------------------------
	// GUI elements and variables
	// ----------------------------------------------------------------------------------------------------------------
	
	private JLabel diceResultSpot ;
	private JRadioButton four, six, eight, ten, twelve, twenty, hundred ;
	private JButton rollDice ;
	private int diceToRoll = 20 ;
	private int diceResult = 0 ;
	private int hundredDiceResult = 0 ;
	private Random generator = new Random() ;
	
	// ----------------------------------------------------------------------------------------------------------------
	// GUI Constructor
	// ----------------------------------------------------------------------------------------------------------------
	
	public DicePanel()
	{
		// ------------------------------------------------------------------------------------------------------------
		// Dice Result
		// ------------------------------------------------------------------------------------------------------------
		
		diceResultSpot = new JLabel() ;
		add(diceResultSpot) ;
		
		// ------------------------------------------------------------------------------------------------------------
		// Radio Buttons
		// ------------------------------------------------------------------------------------------------------------
		
		four = new JRadioButton("d4") ;
		six = new JRadioButton("d6") ;
		eight = new JRadioButton("d8") ;
		ten = new JRadioButton("d10") ;
		twelve = new JRadioButton("d12") ;
		twenty = new JRadioButton("d20") ;
		hundred = new JRadioButton("d100") ;
		
		ButtonGroup diceChoice = new ButtonGroup() ;
		diceChoice.add(four) ;
		diceChoice.add(six) ;
		diceChoice.add(eight) ;
		diceChoice.add(ten) ;
		diceChoice.add(twelve) ;
		diceChoice.add(twenty) ;
		twenty.setSelected(true) ;
		diceChoice.add(hundred) ;
		
		RadioListener diceListener = new RadioListener() ;
		four.addActionListener(diceListener) ;
		six.addActionListener(diceListener) ;
		eight.addActionListener(diceListener) ;
		ten.addActionListener(diceListener) ;
		twelve.addActionListener(diceListener) ;
		twenty.addActionListener(diceListener) ;
		hundred.addActionListener(diceListener) ;
		
		add(four) ;
		add(six) ;
		add(eight) ;
		add(ten) ;
		add(twelve) ;
		add(twenty) ;
		add(hundred) ;
		
		// ------------------------------------------------------------------------------------------------------------
		// Button
		// ------------------------------------------------------------------------------------------------------------
		
		rollDice = new JButton("Roll Dice!") ;
		ButtonListener rollListener = new ButtonListener() ;
		rollDice.addActionListener(rollListener) ;
		
		add(rollDice) ;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Radio Button Listener
	// ----------------------------------------------------------------------------------------------------------------
	
	private class RadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent rEvent)
		{
			Object source = rEvent.getSource() ;
			
			// --------------------------------------------------------------------------------------------------------
			// Decides which dice to roll
			// --------------------------------------------------------------------------------------------------------
			
			if (source == four)
			{
				diceToRoll = 4 ;
			}
			else
			{
				if (source == six)
				{
					diceToRoll = 6 ;
				}
				else
				{
					if (source == eight)
					{
						diceToRoll = 8 ;
					}
					else
					{
						if (source == ten)
						{
							diceToRoll = 10 ;
						}
						else
						{
							if (source == twelve)
							{
								diceToRoll = 12 ;
							}
							else
							{
								if (source == twenty)
								{
									diceToRoll = 20 ;
								}
								else
								{
									diceToRoll = 100 ;
								}
							}
						}
					}
				}
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// Button Listener
	// ----------------------------------------------------------------------------------------------------------------
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent bEvent)
		{
			if (bEvent.getSource() == rollDice)
			{
				if (diceToRoll <= 8 || diceToRoll >= 12 && diceToRoll<= 20) 
				{
					diceResult = generator.nextInt(diceToRoll) + 1 ;
				}
				else
				{
					if (diceToRoll == 10)
					{
						diceResult = generator.nextInt(10) ;
					}
					else
					{
						diceResult = generator.nextInt(10) ;
						hundredDiceResult = generator.nextInt(10) ;
						
						if (diceResult == 0 && hundredDiceResult == 0)
						{
							diceResult = 100 ;
						}
						else
						{
							hundredDiceResult = hundredDiceResult * 10 ;
							diceResult = diceResult + hundredDiceResult ;
						}
					}
				}			
			}
			diceResultSpot.setText(Integer.toString(diceResult)) ;
		}
	}
}