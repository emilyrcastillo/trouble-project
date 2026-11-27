package Piece;

public class Piece {
    private String color; // initializing color attribute
    private int number; // initializing piece number attribute
    private int progress; // initializing progress attribute

    // Initializing constants
    private final int HOME_CELL_INDEX = -1; //
    private final int FINISH_LINE_START_INDEX =28;
    private final int LAST_CELL_INDEX = 31;
    private final int MAX_SIZE_ROLL = 6;


    // Getter method to get private color attribute
    public String getColor() {
        return color;

    }

    // Method to check if piece is home or not
    public boolean isAtHome() {
        return progress == HOME_CELL_INDEX;

    }

    // Method that checks if the piece is on the track
    public boolean isOnTrack() {
        return (this.progress > HOME_CELL_INDEX && this.progress < FINISH_LINE_START_INDEX);
    }

    // Method that checks if piece is on the last cell
    public boolean isFinished() {
        return progress == LAST_CELL_INDEX;
    }

    // Method that resets progress to -1 (home cell)
    public void sendHome(){
        progress = HOME_CELL_INDEX;
    }

    // Method that checks if piece can move
    public boolean canMove(int roll){
        boolean output;
        if (isAtHome() && roll == MAX_SIZE_ROLL){
            output = true;
        }
        else if (!isAtHome() && progress+roll <= LAST_CELL_INDEX){
            output = true;
        }
        else{
            output = false;
        }
        return output;
    }

    // Method that updates progress after a roll
    public void move(int roll){
        progress += roll;
    }

}

