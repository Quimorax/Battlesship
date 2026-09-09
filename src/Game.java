import java.util.*;

public class Game {
    private Player player1;
    private Player player2;

    private Player currentPlayer;
    private Status status;

    public enum Status {
        ACTIVE, FINISHED
    }

    public Game(boolean isPvp, int size) {
        this.player1 = new Player(false, size);  // our player
        this.currentPlayer = player1;

        boolean isBot = !isPvp;
        this.player2 = new Player(isBot, size);
        this.status = Status.ACTIVE;
    }



    public void makeMove() {

    }

    private Player nextPlayer() {
        return currentPlayer.equals(player1) ? player2 : player1;
    }

    public Status getStatus() {
        return status;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
