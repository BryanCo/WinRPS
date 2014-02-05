//WinRPS.java
import java.awt.*;							//Dimension, setLayout
import java.awt.event.*;					
import java.awt.event.ActionListener;		//ActionListener used to listen for button clicks
import javax.swing.*;						//JLabel, JButton, JFrame, Box
import javax.swing.ImageIcon;				//ImageIcon

public class WinRPS							//Start class
{
	JLabel computerGuy, computerLabel;		//declare object instances used in multiple functions
	
	public WinRPS()
	{
		JFrame frame = new JFrame("Rock, Paper, Scissors");				//Main frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box boxArea = Box.createHorizontalBox();						//Main container providing left to right layout
		
		Box chooseArea = Box.createVerticalBox();						//Container for buttons provides top to bottom layout
		
		ImageIcon sciIcon = new ImageIcon("Scissors.gif");				//load images into icons
		ImageIcon rockIcon = new ImageIcon("Rock.gif");
		ImageIcon paperIcon = new ImageIcon("Paper.gif");
		
		JButton buttonCSc = new JButton( "Choose Scissors", sciIcon);	// create scissors button
		buttonCSc.setPreferredSize(new Dimension(300,120));				// set size 120 pixels heigh 300 wide
		buttonCSc.setIcon(sciIcon);										// place icon on button
		sciIcon.setImageObserver( buttonCSc );							// update .gif in icon
		buttonCSc.addActionListener( new ActionListener () {			// listen for button click 
		
			public void actionPerformed(ActionEvent e) 					//if clicked...
			{
				Rules(3);												// run Rules() function pass 3 to it
			} 
		});
		
		JButton buttonCRo = new JButton( "Choose Rock", rockIcon);	// choise 1
		buttonCRo.setPreferredSize(new Dimension(300,120));			// see button CSc documentation
		buttonCRo.setIcon(rockIcon);
		rockIcon.setImageObserver( buttonCRo );
		buttonCRo.addActionListener( new ActionListener () {
		
			public void actionPerformed(ActionEvent e) 
			{
				Rules(1);
			} 
		});
		
		JButton buttonCPa = new JButton( "Choose Paper", paperIcon);	//choise 2
		buttonCPa.setPreferredSize(new Dimension(300,120));				// see button CSc documentation
		buttonCPa.setIcon(paperIcon);
		paperIcon.setImageObserver( buttonCPa );
		buttonCPa.addActionListener( new ActionListener () {
		
			public void actionPerformed(ActionEvent e) 
			{
				Rules(2);
			} 
		});
		
		JLabel youLabel = new JLabel("You Choose");				// label which says "You Choose"
		
		chooseArea.add(youLabel);								// add given objects to chooseArea in listed order
		chooseArea.add(buttonCRo);
		chooseArea.add(buttonCPa);
		chooseArea.add(buttonCSc);
		
		Box computerArea = Box.createVerticalBox();				// declare computerArea
		
		computerLabel = new JLabel("Computer Chooses:");		// label which says "Computer Chooses"
		
		ImageIcon startIcon = new ImageIcon("Start.jpg");		// load Start.jpg into Icon
		computerGuy = new JLabel(startIcon);					// create label to display startIcon 

		computerArea.add(computerGuy);						// add given objects to computerArea in listed order
		computerArea.add(computerLabel);
		
		boxArea.add(chooseArea);							// add chooseArea...
		boxArea.add(computerArea);							// and computerArea to boxArea
		
		frame.getContentPane().add(boxArea, BorderLayout.CENTER );		// place boxArea on frame in center
		frame.pack();													// pack frame as Windows object
        frame.setVisible(true);											// frame can be seen on desktop
	}
	
	private void Rules( int choice )						// Rules function declare choice set equal to number passed to function
	{
		int compChoise;										//declare compChoise
		compChoise = 1 + (int)(Math.random()*3);			// random number between 1 and 3
		ImageIcon frownIcon = new ImageIcon("Frown.gif");	// load Frown.gif into Icon
		ImageIcon smileIcon = new ImageIcon("Smile.gif");	// load Smile.gif into Icon
		
		// computer wins if there is a tie.
		if( choice == compChoise )						
		{
			switch(compChoise)
			{
				case 1: computerLabel.setText("Computer chooses rock and wins by default!");
					break; // break needed between cases
				case 2: computerLabel.setText("Computer chooses paper and wins by default!");
					break;
				case 3: computerLabel.setText("Computer chooses scissors and wins by default!");
					break;
			};
			computerGuy.setIcon(smileIcon);		// If computer wins he is happy!
		}
		else
		{
			switch ( choice )		//start case statement based on what you chose
			{
				case 1:	switch( compChoise )		// you chose rock start computer case statment
						{
							case 2:			// you chose rock computer chose paper
							{
								computerLabel.setText("Paper beats Rock! Sorry!");
								computerGuy.setIcon(smileIcon);
							}
							break;
							case 3:			// you chose rock computer chose scissors
							{
								computerLabel.setText("Rock beats scissors! You win!");
								computerGuy.setIcon(frownIcon);
							}
							break;
						};
						break;
					
				case 2:	switch( compChoise )		// you chose paper start computer case statement
						{
							case 1:			// you chose paper computer chose rock
							{
								computerLabel.setText("Paper beats Rock! You win!");
								computerGuy.setIcon(frownIcon);
							}
							break;
							case 3:			// you chose paper computer chose scissors
							{
								computerLabel.setText("Scissors beat paper! Sorry!");
								computerGuy.setIcon(smileIcon);
							}
							break;
						};
						break;
					
				case 3: switch( compChoise )		// you chose scissors start computer case statment
						{
							case 1:			// you chose scissors computer chose rock
							{
								computerLabel.setText("Rock beats scissors! Sorry!");
								computerGuy.setIcon(smileIcon);
							}
							break;
							case 2:			// you chose scissors computer chose paper
							{
								computerLabel.setText("Scissors beat paper! You win!");
								computerGuy.setIcon(frownIcon);
							}
							break;
						};
						break;
			}	// end switch
		}	// endif
	}	//end Rules()
	
	static public void main(String[] args)	// main function.  will load first when class started
	{       
		new WinRPS();		// start WinRPS function
    }
}	// end class