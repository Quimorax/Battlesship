//public enum Player {
//    PLAYER_ONE,
//    PLAYER_TWO,
//    AI;
//
//    public Player next(boolean isPvP) {
//        if (this == PLAYER_ONE) {
//            return isPvP ? PLAYER_TWO : AI;
//        }
//        return PLAYER_ONE;
//    }
//}
//

public class Player {
    private PlayerField playerField;
    private boolean isBot;

    public Player(boolean isBot, int fieldSize) {
        this.playerField = new PlayerField(fieldSize);
        this.isBot = isBot;
    }

    public boolean isBot() {
        return isBot;
    }

    public PlayerField getPlayerField() {
        return playerField;
    }

//    public void shoot(Position position, PlayerField opponentField) {
//        opponentField.setCell(); // ???
//    }
}
