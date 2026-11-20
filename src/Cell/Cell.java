package Cell;

import Piece.Piece;

public class Cell {
    private int row; // Initializing row attribute, row of cell in grid.
    private int column; // Initializing column attribute, column of cell in grid.
    private Piece occupant; // Initializing occupant attribute, piece occupying the cell.

    // Method that checks if cell is empty.
    public boolean isEmpty() {
        return occupant == null; // If there's no occupant return True, else False
    }

    // Method that returns occupant in cell.
    public Piece getOccupant() {
        return occupant;
    }

    // Method that places onto a cell.
    public void placePiece(Piece piece) {
        // check if piece can land on cell before placing it
        if (canLandHere(piece)){
            occupant = piece;
        }

    }

    // Method that removes piece from cell.
    public void removePiece() {
        occupant = null;
    }

    // Method that checks if an incoming piece can land on a cell.
    public boolean canLandHere(Piece piece) {
        // A cell can be landed on if it's empty, or if the incoming piece
        // is a different color than the occupant/occupying piece
        return isEmpty()|| !piece.getColor().equals(occupant.getColor());


    }
}
