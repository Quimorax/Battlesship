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

    public Player(boolean isPvP) {
        this.playerField = new PlayerField();
        this.isBot = !isPvP;
    }

    public boolean isBot() {
        return isBot;
    }

    public PlayerField getPlayerField() {
        return playerField;
    }
}
