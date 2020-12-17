package pieces;

import java.util.ArrayList;

import chess.Cell;

public class Knight extends Piece{

	public Knight(String id, String path, int color) {
		super(id, path, color);
	}

	@Override
	public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
		possibleMoves.clear();
		
		//Knight's possible move set
		int[] posX = {x + 1, x + 1, x + 2, x + 2, 
				x - 1, x - 1, x - 2, x - 2};
		int[] posY = {y - 2, y + 2, y - 1, y + 1,
				y - 2, y + 2, y - 1, y + 1};
		
		for (int i = 0; i < 8; i++) {
			if ((pos[posX[i]][posY[i]].getPiece() == null)
					|| pos[posX[i]][posY[i]].getPiece().getColor() != this.getColor()
						) {
				possibleMoves.add(pos[posX[i]][posY[i]]);
			}
		}
		
		return possibleMoves;
	}

}
