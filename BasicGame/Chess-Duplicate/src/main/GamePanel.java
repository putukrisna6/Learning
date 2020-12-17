package main;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chess.Cell;
import pieces.*;

public class GamePanel extends JFrame implements MouseListener{
	
	private static final long serialVersionUID = 1L;

	// panel sizes
	private static final int HEIGHT = 700;
	private static final int WIDTH = 1110;
	
	// chess pieces
	private static Rook wr01,wr02,br01,br02;
	private static Knight wk01,wk02,bk01,bk02;
	private static Bishop wb01,wb02,bb01,bb02;
	private static Pawn wp[],bp[];
	private static Queen wq,bq;
	private static King wk,bk;
	
	// cells
	private Cell c;
	private Cell previous;
	private Cell[][] boardState;
	private ArrayList<Cell> destinationList = new ArrayList<Cell>();
	
	// turn
	private int chance = 0;
	
	// player select menu
	private JPanel board=new JPanel(new GridLayout(8,8));
	private JPanel wDetails=new JPanel(new GridLayout(3,3));
	private JPanel bDetails=new JPanel(new GridLayout(3,3));
	private JPanel wComboPanel=new JPanel();
	private JPanel bComboPanel=new JPanel();
	
	// method to change which player can move in a certain turn
	public void chanceChange() {
		if (boardState[getKing(chance).getX()][getKing(chance).getY()].isCheck()) {
			
		}
	}
	
	// method to retrieve King's colour
	private King getKing(int color) {
		if (color == 0) {
			return wk;
		}
		else {
			return bk;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
