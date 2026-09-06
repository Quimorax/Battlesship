public class Game {
    private Player player1;
    private Player player2;

    private Player currentPlayer;
    private Status status;

    enum Status {
        ACTIVE, FINISHED
    }


    public Game(boolean isPvp) {
        this.player1 = new Player(true);  // our player
        this.currentPlayer = player1;

        this.player2 = new Player(isPvp);
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
}
