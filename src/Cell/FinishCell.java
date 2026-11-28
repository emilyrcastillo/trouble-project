package Cell;
import Piece.Piece;

public class FinishCell extends Cell {
    private String color;
    private int finishIndex;

    //Constructor
    public FinishCell(int row, int column, String color, int finishIndex){
        super (row, column);
        this.color = color;
        this.finishIndex = finishIndex;
    }

    // Getter method for color
    public String getColor(){
        return color;
    }

    // Getter method for finish index
    public int getFinishIndex(){
        return finishIndex;
    }

    // Method returns true only for its own color,& only if the space is empty.
    @Override
    public boolean canLandHere(Piece piece){
        // Comparing color of finish cell and piece
        // Checking if space is empty
        return (this.color.equals(piece.getColor())) && (this.isEmpty());
    }
}
