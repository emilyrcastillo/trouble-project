package Cell;

import Piece.Piece;

public class HomeCell extends Cell {
    private String color;

    public HomeCell( int row, int column, String color){
        super(row, column);
        this.color = color;
    }

    // Getter method for color
    public String getColor(){
        return color;
    }

    // Method that returns false because pieces can never be manually placed
    // on home cells
    @Override
    public boolean canLandHere(Piece piece){
        return false;
    }
}