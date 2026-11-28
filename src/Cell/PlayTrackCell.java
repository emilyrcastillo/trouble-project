package Cell;

import Piece.Piece;

public class PlayTrackCell extends Cell {
    protected int trackIndex;

    public PlayTrackCell(int row, int column, int trackIndex){
        super(row,column);
        this.trackIndex = trackIndex;

    }

    // Getter method for track index
    public int getTrackIndex(){
        return trackIndex;
    }

    //Checks if there is piece on cell, if yes, compares color
    @Override
    public boolean canLandHere(Piece piece){
        return !(!this.isEmpty() && piece.getColor().equals(this.getOccupant().getColor()));
    }
}