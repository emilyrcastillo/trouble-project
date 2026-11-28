package Piece;

public class Piece {
    private String color; // initializing color attribute
    private int number; // initializing piece number attribute
    private int progress; // initializing progress attribute

    // Initializing constants
    private static final int HOME_CELL_INDEX = -1; //
    private static final int FINISH_LINE_START_INDEX =28;
    private static final int LAST_CELL_INDEX = 31;
    private static final int MAX_SIZE_ROLL = 6;

    public Piece(String color, int number) throws Exception{
        if (number >= 1){
            this.color = color;
            this.number = number;
            this.progress = -1;
        }
        else{
            throw new Exception("Number not in valid range. Number must be greater than or equal to one.");
        }
    }

    // Getter method for progress
    public int getProgres(){
        return progress;
    }

    // Getter method for number
    public int getNumber(){
        return number;
    }

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
        // Play track is between home cell and finish cells
        return (this.progress > HOME_CELL_INDEX && this.progress < FINISH_LINE_START_INDEX);
    }

    // Method that checks if piece is on the last cell
    public boolean isFinished() {
        // A cell is finished if it is passed the finish line and still in the valid range
        return progress >= FINISH_LINE_START_INDEX && progress <= LAST_CELL_INDEX;
    }

    // Method that resets progress to -1 (home cell)
    public void sendHome(){
        progress = HOME_CELL_INDEX;
    }

    // Method that returns true if piece and move, returns false otherwise
    public boolean canMove(int roll){
        // Initializes a flag for output
        boolean output;
        // A piece at home must roll a 6 to leave
        if (isAtHome() && roll == MAX_SIZE_ROLL){
            output = true;
        }
        // if a piece is on the track and the roll would not send them out of the valid range
        // then they can move
        else if (!isAtHome() && progress+roll <= LAST_CELL_INDEX){
            output = true;
        }
        // If neither condition was met, then the piece cannot move
        else{
            output = false;
        }
        return output;
    }

    // Method that updates progress after a roll
    public void move(int roll) {
        // If a piece leaves home it moves forward one space to the start cell
        if (this.isAtHome()) {
            progress += 1;
        }
        // If a piece is on the track it's movement is determined by the number it rolls
        else {
            progress += roll;
        }
    }
}

