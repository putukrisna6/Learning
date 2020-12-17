package game;

import javax.swing.JFrame;

import gameState.Board;

import java.awt.EventQueue;

@SuppressWarnings("serial")
public class Breakout extends JFrame {

    public Breakout() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {

            Breakout game = new Breakout();
            game.setVisible(true);
        });
    }
//	public static void main(String[] args) {
//		JFrame window = new JFrame("Wacky Game");
//		window.setContentPane(new BreakoutPanel());
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(false);
//		window.pack();
//		window.setVisible(true);
//	}
}
