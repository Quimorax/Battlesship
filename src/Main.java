import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser(scanner);

        int size = getSize(inputParser);
        boolean isPvP = getYesNoQuestion("Do you want to play with player? (y/n):", inputParser);

        String message = "Do you want to fill your field automatically? (y/n): ";
        boolean playerFillAutomatically = getYesNoQuestion(message, inputParser);
        boolean opponentFillAutomatically = false;

        if (isPvP) {
            opponentFillAutomatically = getYesNoQuestion(message, inputParser);
        }

        Game game = new Game(isPvP, size);

        fillPlayerField(playerFillAutomatically, game.getPlayer1().getPlayerField(), inputParser);
        fillPlayerField(opponentFillAutomatically, game.getPlayer2().getPlayerField(), inputParser);

        while (game.getStatus() == Game.Status.ACTIVE) {  // main game cycle

        }
    }

    private static boolean getYesNoQuestion(String message, InputParser inputParser) {
        boolean answer;
        while (true) {
            try {
                answer = inputParser.parseYesNoQuestions(message);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one more time");
                continue;
            }
            break;
        }
        return answer;
    }

    private static int getSize(InputParser inputParser) {
        int size;
        while (true) {
            try {
                size = inputParser.parseSize();
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one more time");
                continue;
            }
            break;
        }
        return size;
    }

    private static void fillPlayerField(boolean fillAutomatically, PlayerField playerField, InputParser inputParser) {
        if (fillAutomatically) {
            // different ship sizes in future
            new RandomShipPlacer().placeShips(playerField, ShipPlacer.getDefaultShipSizes());
        } else {
            new ManualShipPlacer(inputParser).placeShips(playerField, ShipPlacer.getDefaultShipSizes());
        }
    }
}