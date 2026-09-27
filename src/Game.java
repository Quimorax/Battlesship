import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private InputReader reader;

    private Player currentPlayer;
    private Status status;

    private enum Status {
        ACTIVE, FINISHED
    }

    public Game(boolean isPvp, int size, InputReader reader) {
        this.player1 = new Player(false, size);  // our player
        this.currentPlayer = player1;
        this.reader = reader;

        boolean isBot = !isPvp;
        this.player2 = new Player(isBot, size);  // opponent or bot
        this.status = Status.ACTIVE;
    }

    public void start() {
        int fieldSize = player1.getField().getSize();

        while (status == Status.ACTIVE) {
            // TODO: implement rule of constant shooting
            System.out.println();
            PlayerFieldRenderer.render(player1.getField(), player2.getField(), currentPlayer.getField());

            PlayerField opponentField = nextPlayer().getField();
            Position target;

            System.out.println(currentPlayer + " making move");
            if (currentPlayer.isBot()) {
                target = PositionUtils.generateRandomPosition(fieldSize);
            } else {
                target = reader.readPosition(fieldSize);
            }
            currentPlayer.shoot(target, opponentField);

            if (opponentField.getCell(target) != PlayerField.CellStatus.HIT) {
                currentPlayer = nextPlayer();
            } else {
                opponentField.renderSunkShip(target);
            }
            status = updateStatus();
        }

        System.out.println();
        System.out.println(currentPlayer + " won!");
    }

    private Player nextPlayer() {
        return currentPlayer.equals(player1) ? player2 : player1;
    }

    public void fillPlayerFields(boolean playerFillAutomatically, boolean opponentFillAutomatically) {
        fillPlayerField(playerFillAutomatically, player1.getField());
        fillPlayerField(opponentFillAutomatically, player2.getField());
    }

    private void fillPlayerField(boolean fillAutomatically, PlayerField field) {
        if (fillAutomatically) {
            // different ship sizes in future
            new RandomShipPlacer().placeShips(field, ShipPlacer.getDefaultShipSizes());
        } else {
            PlayerFieldRenderer.render(field);
            new ManualShipPlacer(reader).placeShips(field, ShipPlacer.getDefaultShipSizes());
        }
    }

    private Status updateStatus() {
        if (player1.getField().isFleetSunk() || player2.getField().isFleetSunk()) {
            return Status.FINISHED;
        }
        return Status.ACTIVE;
    }
}
