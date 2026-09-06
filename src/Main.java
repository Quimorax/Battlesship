import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser(scanner);
        boolean isPvP;

        while (true) {
            try {
                isPvP = inputParser.parsePvP();
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one more time");
                continue;
            }
            break;
        }

        boolean fillAutomatically;
        while (true) {
            try {
                fillAutomatically = inputParser.parseAutomaticFilling();
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one more time");
                continue;
            }
            break;
        }

        Game game = new Game(isPvP);
        while (game.getStatus() == Game.Status.ACTIVE) {  // main game cycle

            if (!game.getCurrentPlayer().isBot()) {
                while (true) {
                    try {
                        System.out.println("Enter cell to attack in format [ E5 ]: ");
                    }
                }
            }

        }
    }
}