package pieces;

import java.util.ArrayList;

import chess.Cell;

public class King extends Piece{
	private int x;
	private int y;
	
	// Constructor
	public King(String id, String path, int color, int x, int y) {
		super(id, path, color);
		this.x = x;
		this.y = y;
	}
	
	// setters and getters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
		// clear the possibleMoves array first
		// before deciding next possible set of moves
		possibleMoves.clear();
		
		// King piece can only move one step in all adjacent cell
		int posX[] = {x, x, x+1, x+1, x+1, x-1, x-1, x-1};
		int posY[] = {y-1, y+1, y-1, y, y+1, y-1, y, y+1};
		
		for (int i = 0; i < 8; i++) {
			if (posX[i] >= 0 && posX[i] < 8 && 
					posY[i] >= 0 && posY[i] < 8) {
				if (pos[posX[i]][posY[i]].getPiece() == null || 
						pos[posX[i]][posY[i]].getPiece().getColor() != this.getColor()) {
					possibleMoves.add(pos[posX[i]][posY[i]]);
				}
			}
		}
		
		return possibleMoves;
	}
	
	// method to check whether the Kind is under threat or not
	public boolean isInDanger(Cell[][] state) {
		// check for attack vertically and horizontally
		// from the right
		for (int i = x + 1; i < 8; i++) {
			// if there's nothing in a cell, continue
			if (state[i][y].getPiece() == null) {
				continue;
			}
			// if there's a friendly piece in a way,
			// then there's no threat on that direction
			else if (state[i][y].getPiece().getColor() 
					== this.getColor()) {
				break;
			}
			// if there's an enemy rook or queen, kind in danger
			else {
				if ((state[i][y].getPiece() instanceof Rook) 
						|| (state[i][y].getPiece() instanceof Queen)) {
					return true;
				}
				else {
					break;
				}
			}
		}
		// from the left
		for (int i = x - 1; i >= 0; i--) {
			if (state[i][y].getPiece() == null) {
				continue;
			}
			else if (state[i][y].getPiece().getColor() 
					== this.getColor()) {
				break;
			}
			else {
				if ((state[i][y].getPiece() instanceof Rook) 
						|| (state[i][y].getPiece() instanceof Queen)) {
					return true;
				}
				else {
					break;
				}
			}
		}
		// downwards
		for (int i = y + 1; i < 8; i++) {
			if (state[x][i].getPiece() == null) {
				continue;
			}
			else if (state[x][i].getPiece().getColor() 
					== this.getColor()) {
				break;
			}
			else {
				if ((state[x][i].getPiece() instanceof Rook) 
						|| (state[x][i].getPiece() instanceof Queen)) {
					return true;
				}
				else {
					break;
				}
			}
		}
		// upwards
		for (int i = y - 1; i >= 0; i--) {
			if (state[x][i].getPiece() == null) {
				continue;
			}
			else if (state[x][i].getPiece().getColor() 
					== this.getColor()) {
				break;
			}
			else {
				if ((state[x][i].getPiece() instanceof Rook) 
						|| (state[x][i].getPiece() instanceof Queen)) {
					return true;
				}
				else {
					break;
				}
			}
		}
		
		// check for attacks diagonally
		int diagX = x + 1;
		int diagY = y - 1;
		while (diagX < 8 && diagY >= 0) {
			if (state[diagX][diagY].getPiece() == null) {
				diagX++;
				diagY--;
			}
			else if (state[diagX][diagY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				if (state[diagX][diagY].getPiece() instanceof Bishop
						|| state[diagX][diagY].getPiece() instanceof Queen) {
					return true;
				}
				else {
					break;
				}
			}
		}
		
		diagX = x - 1;
		diagY = y + 1;
		while (diagX >= 0 && diagY < 8) {
			if (state[diagX][diagY].getPiece() == null) {
				diagX--;
				diagY++;
			}
			else if (state[diagX][diagY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				if (state[diagX][diagY].getPiece() instanceof Bishop
						|| state[diagX][diagY].getPiece() instanceof Queen) {
					return true;
				}
				else {
					break;
				}
			}
		}
		
		diagX = x - 1;
		diagY = y - 1;
		while (diagX >= 0 && diagY >= 0) {
			if (state[diagX][diagY].getPiece() == null) {
				diagX--;
				diagY--;
			}
			else if (state[diagX][diagY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				if (state[diagX][diagY].getPiece() instanceof Bishop
						|| state[diagX][diagY].getPiece() instanceof Queen) {
					return true;
				}
				else {
					break;
				}
			}
		}
		
		diagX = x + 1;
		diagY = y + 1;
		while (diagX < 8 && diagY < 8) {
			if (state[diagX][diagY].getPiece() == null) {
				diagX++;
				diagY++;
			}
			else if (state[diagX][diagY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				if (state[diagX][diagY].getPiece() instanceof Bishop
						|| state[diagX][diagY].getPiece() instanceof Queen) {
					return true;
				}
				else {
					break;
				}
			}
		}
		
		// check attacks from Knights
		int[] posX = {x + 1, x + 1, x + 2, x + 2, 
						x - 1, x - 1, x - 2, x - 2};
		int[] posY = {y - 2, y + 2, y - 1, y + 1,
						y - 2, y + 2, y - 1, y + 1};
		for (int i = 0; i < 8; i++) {
			if (posX[i] >= 0 && posX[i] < 8 &&
					posY[i] >= 0 && posY[i] < 8) {
				if ((state[posX[i]][posY[i]].getPiece() != null)
						&& (state[posX[i]][posY[i]].getPiece().getColor() != this.getColor())
							&& (state[posX[i]][posY[i]].getPiece() instanceof Knight)) {
					return true;
				}
			}
		}
		
		// check attacks from Pawns and Kings
		int[] pawnX = {x + 1, x + 1, x + 1, x,
						x, x - 1, x - 1, x - 1};
		int[] pawnY = {y - 1, y + 1, y, y + 1,
						y - 1, y + 1, y - 1, y};
		for (int i = 0; i < 8; i++) {
			if (pawnX[i] >= 0 && pawnX[i] < 8 &&
					pawnY[i] >= 0 && pawnY[i] < 8) {
				if ((state[pawnX[i]][pawnY[i]].getPiece() != null)
						&& (state[pawnX[i]][pawnY[i]].getPiece().getColor() != this.getColor())
							&& (state[pawnX[i]][pawnY[i]].getPiece() instanceof King)) {
					return true;
				}
			}
		}
		
		if (getColor() == 0) {
			if (x > 0 && y > 0 && 
					state[x - 1][y - 1].getPiece() != null &&
						state[x - 1][y - 1].getPiece().getColor() == 1 &&
							state[x - 1][y - 1].getPiece() instanceof Pawn) {
				return true;
			}
			if (x > 0 && y < 7 && 
					state[x - 1][y + 1].getPiece() != null &&
						state[x - 1][y + 1].getPiece().getColor() == 1 &&
							state[x - 1][y + 1].getPiece() instanceof Pawn) {
				return true;
			}
		}
		else {
			if (x < 7 && y > 0 && 
					state[x + 1][y - 1].getPiece() != null &&
						state[x + 1][y - 1].getPiece().getColor() == 0 &&
							state[x + 1][y - 1].getPiece() instanceof Pawn) {
				return true;
			}
			if (x < 7 && y < 7 && 
					state[x + 1][y + 1].getPiece() != null &&
						state[x + 1][y + 1].getPiece().getColor() == 0 &&
							state[x + 1][y + 1].getPiece() instanceof Pawn) {
				return true;
			}
		}
		return false;
	}
}
