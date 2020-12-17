package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JLabel;

public class Time {
	private JLabel label;
	Timer countdownTimer;
	int timeRem;
	
	public Time(JLabel passedLabel) {
		countdownTimer = new Timer(1000, 
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int min;
						int sec;
						
						if (timeRem > 0) {
							min = timeRem / 60;
							sec = timeRem % 60;
							
							label.setText(
										String.valueOf(min) 
										+ ":" +  
										(sec >= 10 ? String.valueOf(sec) : 
											"0" + String.valueOf(sec))
									);
							timeRem--;
						}
						else {
							label.setText("Time's up!");
							reset();
							start();
//							Main.Mainboard.changechance();
						}
					}
			
				}
		);

	}
	
	public void start() {
		countdownTimer.start();
	}
	public void reset() {
//		timeRem = Main.timeRemaining;
	}
}
