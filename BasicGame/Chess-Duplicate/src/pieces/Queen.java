package pieces;

import java.util.ArrayList;

import chess.Cell;

public class Queen extends Piece{

	public Queen(String id, String path, int color) {
		super(id, path, color);
	}

	@Override
	public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		// check moves vertically
		int tempX = x - 1;
		while (tempX >= 0) {
			if (pos[tempX][y].getPiece() == null) {
				possibleMoves.add(pos[tempX][y]);
			}
			else if (pos[tempX][y].getPiece().getColor() 
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[tempX][y]);
				break;
			}
			tempX--;
		}
		tempX = x + 1;
		while (tempX < 8) {
			if (pos[tempX][y].getPiece() == null) {
				possibleMoves.add(pos[tempX][y]);
			}
			else if (pos[tempX][y].getPiece().getColor() 
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[tempX][y]);
				break;
			}
			tempX++;
		}
		// check moves horizontally
		int tempY = y - 1;
		while (tempY >= 0) {
			if (pos[x][tempY].getPiece() == null) {
				possibleMoves.add(pos[x][tempY]);
			}
			else if (pos[x][tempY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[x][tempY]);
			}
			tempY--;
		}
		tempY = y + 1;
		while (tempY < 8) {
			if (pos[x][tempY].getPiece() == null) {
				possibleMoves.add(pos[x][tempY]);
			}
			else if (pos[x][tempY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[x][tempY]);
			}
			tempY++;
		}
		// check moves diagonally
		tempX = x + 1;
		tempY = y - 1;
		while (tempX < 8 && tempY >= 0) {
			if (pos[tempX][tempY].getPiece() == null) {
				possibleMoves.add(pos[tempX][tempY]);
			}
			else if (pos[tempX][tempY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[tempX][tempY]);
				break;
			}
			tempX++;
			tempY--;
		}
		tempX = x - 1;
		tempY = y + 1;
		while (tempX >= 0 && tempY < 8) {
			if (pos[tempX][tempY].getPiece() == null) {
				possibleMoves.add(pos[tempX][tempY]);
			}
			else if (pos[tempX][tempY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[tempX][tempY]);
				break;
			}
			tempX--;
			tempY++;
		}
		tempX = x - 1;
		tempY = y - 1;
		while (tempX >= 0 && tempY >= 0) {
			if (pos[tempX][tempY].getPiece() == null) {
				possibleMoves.add(pos[tempX][tempY]);
			}
			else if (pos[tempX][tempY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[tempX][tempY]);
				break;
			}
			tempX--;
			tempY--;
		}
		tempX = x + 1;
		tempY = y + 1;
		while (tempX < 8 && tempY < 8) {
			if (pos[tempX][tempY].getPiece() == null) {
				possibleMoves.add(pos[tempX][tempY]);
			}
			else if (pos[tempX][tempY].getPiece().getColor()
					== this.getColor()) {
				break;
			}
			else {
				possibleMoves.add(pos[tempX][tempY]);
				break;
			}
			tempX++;
			tempY++;
		}
		
		return possibleMoves;
	}
	
}
