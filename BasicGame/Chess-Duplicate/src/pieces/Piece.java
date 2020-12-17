package pieces;

import java.util.ArrayList;

import chess.Cell;

public abstract class Piece implements Cloneable {
	// basic attributes
	private int color;
	private String id;
	private String path;
	
	// setter and getters
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	// possible moves and positioning
	protected ArrayList<Cell> possibleMoves = new ArrayList<Cell>();
	public abstract ArrayList<Cell> move(Cell[][] pos, int x, int y);
	
	// function to clone object but with different reference
	public Piece getCopy() throws CloneNotSupportedException {
		return (Piece) this.clone();
	}
	
	// Constructor
	public Piece(String id, String path, int color) {
		this.id = id;
		this.path = path;
		this.color = color;
	}
	
}
