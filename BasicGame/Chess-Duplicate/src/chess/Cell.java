package chess;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.*;

public class Cell extends JPanel implements Cloneable {
	// cell attributes
	private static final long serialVersionUID = 1L;
	private boolean isPossibleDestination;
	private JLabel content;
	private Piece piece;
	
	// coordinates to form a checker board
	// coordinates to place pieces
	int x;
	int y;
	
	private boolean isSelected = false;
	private boolean isCheck = false;
	
	//Constructors
	public Cell(int x, int y, Piece p) {
		this.x = x;
		this.y = y;
		
		setLayout(new BorderLayout());
		
		// determine whether a cell should be black or white
		if ((x + y) % 2 == 0) {
			setBackground(Color.BLACK);
		}
		else {
			setBackground(Color.WHITE);
		}
		
		// if a piece exist, place it
		if (p != null) {
			setPiece(p);
		}
	}
	public Cell(Cell cell) throws CloneNotSupportedException {
		this.x = cell.x;
		this.y = cell.y;
		
		setLayout(new BorderLayout());
		
		if ((x + y) % 2 == 0) {
			setBackground(Color.BLACK);
		}
		else {
			setBackground(Color.WHITE);
		}
		
		if (cell.getPiece() != null) {
			setPiece(cell.getPiece().getCopy());
		}
		else {
			piece = null;
		}
	}
	
	// method to place a chess piece in a cell
	public void setPiece(Piece p) {
		piece = p;
		// get a piece's image
		ImageIcon img = new ImageIcon(
					this.getClass().getResource(p.getPath())
				);
		// then add it to the panel
		content = new JLabel(img);
		this.add(content);
	}
	// method to remove a chess piece
	public void removePiece() {
		if (piece instanceof King) {
			piece = null;
			this.remove(content);
		}
		else {
			piece = null;
			this.remove(content);
		}
	}
	// method to return a piece in a cell
	public Piece getPiece() {
		return this.piece;
	}
	
	// method to indicate that a cell is selected
	public void select() {
		this.setBorder(BorderFactory.createLineBorder(Color.RED, 6));
		this.isSelected = true;
	}
	// method to indicate that a cell is deselected
	public void deselect() {
		this.setBorder(null);
		this.isSelected = false;
	}
	public boolean isSelected() {
		return this.isSelected;
	}
	
	// method to highlight all possible moves
	public void setPossibleDestination() {
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
		this.isPossibleDestination = true;
	}
	// method to indicate that a cell is no longer a possible destination
	public void removePossibleDestination() {
		this.setBorder(null);
		this.isPossibleDestination = false;
	}
	public boolean isPossibleDestination() {
		return this.isPossibleDestination;
	}
	
	// method to highlight that a King is in check
	public void setCheck() {
		this.setBackground(Color.RED);
		this.isCheck = true;
	}
	// method to remove check highlight
	public void removeCheck() {
		this.setBorder(null);
		if ((x + y) % 2 == 0) {
			setBackground(Color.BLACK);
		}
		else {
			setBackground(Color.WHITE);
		}
		
		this.isCheck = false;
	}
	public boolean isCheck() {
		return this.isCheck;
	}
}
