package Cell;

import Piece.Piece;

public class HomeCell extends Cell {
    private String color;

    // Method that returns false because pieces can never be manually placed
    // on home cells
    @Override
    public boolean canLandHere(Piece piece){
        return false;
    }
}