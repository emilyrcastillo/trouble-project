package Player;

import Piece.Piece;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name; // Initializing name attribute for player
    private String color; // Initializing color attribute for player
    private Piece[] pieces = new Piece[4]; // Initializing players pieces(4)
    private Piece[] homePieces = new Piece[4]; // Initializing home pieces
    private int startIndex;

    // Initializing constants
    private static final int FIRST_START_CELL_INDEX = 0;
    private static final int START_CELL_INDEX_INCREMENT = 7;
    private static final int LAST_START_CELL_INDEX = 21;

    // Defining constructor to create players from name, color, pieces, and start index
    public Player(String name, String color, int startIndex) throws Exception{
        // Start index must be 0,7,14, or 21
        if (startIndex % START_CELL_INDEX_INCREMENT == FIRST_START_CELL_INDEX && startIndex <= LAST_START_CELL_INDEX) {
            this.name = name;
            this.color = color;
            this.startIndex = startIndex;
            // Makes four new pieces and put them in the players piece array
            for (int i=0; i < 4; i++){
                this.pieces[i] = new Piece(this.color, i+1);
                this.homePieces[i] = this.pieces[i];
            }
        }
        else{
            throw new Exception("Start index not on valid start cell (0,7,14,21).");
        }
    }

    // Method to roll die
    public int rollDie(){
        // Chooses a random number from 1-6
        return ((int)(Math.random() * 6) + 1);
    }

    //Creates a list of pieces that can legally move with a roll and returns it
    public ArrayList<Piece> getMovablePieces(int roll) {
        // Initializing empty array list of pieces
        ArrayList<Piece> movablePieces = new ArrayList<Piece>();
        // Loop through all of players pieces
        for (Piece i : pieces) {
            // If the piece can move, add it to movable pieces
            if (i.canMove(roll)) {
                movablePieces.add(i);
            }
        }
        return movablePieces;
    }

    // Tells player what pieces are movable and asks which piece to move
    public Piece choosePiece(ArrayList<Piece> movable, Scanner input) throws Exception {
        for (int i = 0; i <= movable.size() - 1; i++) {
            System.out.printf("%d) %s is movable.%n", i + 1, movable.get(i).toString());
        }
        System.out.println("Choose the number associated with the piece you want to move.");
        int choice = input.nextInt();
        if (!(choice >= 1 && choice <= movable.size())) {
            throw new Exception("Input not in valid range.");
        }
        return movable.get(choice - 1);
    }

    // Method that checks if all pieces are finished, if true the user has won
    public boolean hasWon(){
        // Initializing flag to true, for checking if user has one
        boolean won = true;
        // Loop through all of players pieces
        for (Piece i: pieces){
            // If one of the pieces is not finished, then the user has not won
            if (!i.isFinished()){
                won = false;
                break;
            }
        }
        return won;
    }

    // A method that returns a counter of the number of pieces a player has at home
    public int piecesAtHome(){
        // Initializing a counter for amount of pieces at home starting at 0
        int homePieces = 0;
        // Loop through all the players pieces
        for (Piece i: pieces){
            // If piece is at home, increment counter
            if (i.isAtHome()){
                homePieces+=1;
            }
        }
        return homePieces;
    }

    // Getter method for name
    public String getName(){
        return name;
    }

    // Getter method for color
    public String getColor(){
        return color;
    }

    // Getter method for start index
    public int getStartIndex(){
        return startIndex;
    }
}
