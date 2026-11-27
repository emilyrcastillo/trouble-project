package Cell;
import Piece.Piece;

public class FinishCell extends Cell {
    private String color;
    private int finishIndex;

    // Method returns true only for its own color,& only if the space is empty.
    @Override
    public boolean canLandHere(Piece piece){
        // Comparing color of finish cell and piece
        // Checking if space is empty
        return (this.color.equals(piece.getColor())) && (this.isEmpty());
    }
}
