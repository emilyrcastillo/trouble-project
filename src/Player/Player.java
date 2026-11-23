package Player;

import Piece.Piece;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name; // Initializing name attribute for player
    private String color; // Initializing color attribute for player
    private Piece[] pieces = new Piece[4]; // Initializing players pieces(4)
    private int startIndex;


    // Method to roll die
    public int rollDie(){
        // Chooses a random number from 1-6
        return ((int)(Math.random() * 6) + 1);
    }

    //Creates a list of pieces that can legally move with a roll and returns it
    public ArrayList<Piece> getMovablePieces(int roll) {
        ArrayList<Piece> movablePieces = new ArrayList<Piece>();
        for (Piece i : pieces) {
            if (i.canMove(roll)) {
                movablePieces.add(i);
            }
        }
        return movablePieces;
    }

    // Tells player what pieces are movable and asks which piece to move
    public Piece choosePiece(ArrayList<Piece> movable, Scanner input){
        for (Piece i: movable){
            System.out.println(i + " is movable.");
        }
        System.out.println("Choose the number associated with the piece you want to move.");
        int choice = input.nextInt();
        return movable.get(choice-1);
    }

    // Method that checks if all pieces are finished, if true the user has won
    public boolean hasWon(){
        boolean won = true;
        for (Piece i: pieces){
            if (!i.isFinished()){
                won = false;
                break;
            }
        }
        return won;
    }

    // A method that returns a counter of the number of pieces a player has at home
    public int piecesAtHome(){
        int homePieces = 0;
        for (Piece i: pieces){
            if (i.isAtHome()){
                homePieces+=1;
            }
        }
        return homePieces;
    }
}
