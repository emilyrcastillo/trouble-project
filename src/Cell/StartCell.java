package Cell;

import Piece.Piece;

public class StartCell extends PlayTrackCell {
    private String color;

    public StartCell(int row, int column, String color, int trackIndex){
        super(row, column, trackIndex);
        this.color = color;
    }

    // Getter method to get private color attribute
    public String getColor(){
        return color;
    }

    // Method that checks if a cell is the start cell for a piece
    public boolean isStartFor(Piece piece){
        return piece.getColor().equals(this.color);

    }
}