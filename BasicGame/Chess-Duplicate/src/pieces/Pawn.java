package pieces;

import java.util.ArrayList;

import chess.Cell;

public class Pawn extends Piece{

	public Pawn(String id, String path, int color) {
		super(id, path, color);
	}

	@Override
	public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		if (getColor() == 0) {
			// invalid state
			if (x == 0) {
				return possibleMoves;
			}
			if (pos[x - 1][y].getPiece() == null) {
				possibleMoves.add(pos[x - 1][y]);
				
				if (x == 6) {
					if (pos[4][y].getPiece() == null) {
						possibleMoves.add(pos[4][y]);
					}
				}
			}
			// if can take enemy piece
			if ((y > 0) && 
					(pos[x - 1][y - 1].getPiece() != null) &&
						(pos[x - 1][y - 1].getPiece().getColor() != this.getColor())) {
				possibleMoves.add(pos[x - 1][y - 1]);
			}
			if ((y < 7) && 
					(pos[x - 1][y + 1].getPiece() != null) &&
						(pos[x - 1][y + 1].getPiece().getColor() != this.getColor())) {
				possibleMoves.add(pos[x - 1][y + 1]);
			}
		}
		else {
			if (x == 8) {
				return possibleMoves;
			}
			if (pos[x + 1][y].getPiece() == null) {
				possibleMoves.add(pos[x + 1][y]);
				
				if (x == 1) {
					if (pos[3][y].getPiece() == null) {
						possibleMoves.add(pos[3][y]);
					}
				}
			}
			// if can take enemy piece
			if ((y > 0) && 
					(pos[x + 1][y - 1].getPiece() != null) &&
						(pos[x + 1][y - 1].getPiece().getColor() != this.getColor())) {
				possibleMoves.add(pos[x + 1][y - 1]);
			}
			if ((y < 7) && 
					(pos[x + 1][y + 1].getPiece() != null) &&
						(pos[x + 1][y + 1].getPiece().getColor() != this.getColor())) {
				possibleMoves.add(pos[x + 1][y + 1]);
			}
		}
		
		return possibleMoves;
	}

}
