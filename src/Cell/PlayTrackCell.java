package Cell;

import Piece.Piece;

public class PlayTrackCell extends Cell {
    protected int trackIndex;

    //Checks if there is piece on cell, if yes, compares color
    @Override
    public boolean canLandHere(Piece piece){
        return !(!this.isEmpty() && piece.getColor().equals(this.getOccupant().getColor()));
    }
}