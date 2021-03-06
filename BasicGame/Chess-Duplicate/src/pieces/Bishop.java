package pieces;

import java.util.ArrayList;

import chess.Cell;

public class Bishop extends Piece{

	public Bishop(String id, String path, int color) {
		super(id, path, color);
	}

	@Override
	public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		int tempX = x + 1;
		int tempY = y - 1;
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
