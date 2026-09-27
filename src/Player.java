public class Player {
    private PlayerField field;
    private boolean isBot;
    private int id;
    private static int playersAmount;

    public Player(boolean isBot, int fieldSize) {
        this.field = new PlayerField(fieldSize);
        this.isBot = isBot;

        playersAmount++;
        this.id = playersAmount;
    }

    public boolean isBot() {
        return isBot;
    }

    public PlayerField getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Player №" + id;
    }

    public PlayerField.CellStatus shoot(Position position, PlayerField opponentField) {
        PlayerField.CellStatus status;
        PlayerField.CellStatus cell = opponentField.getCell(position);

        status = switch (cell) {
            case PlayerField.CellStatus.SHIP -> {
                opponentField.getShip(position).hit();
                yield PlayerField.CellStatus.HIT;
            }
            case PlayerField.CellStatus.EMPTY -> PlayerField.CellStatus.MISS;
            default -> cell;
        };

        opponentField.setCell(position, status);
        return status;
    }
}
