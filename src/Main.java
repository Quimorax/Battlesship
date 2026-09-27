import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputParser inputParser = new InputParser();
        InputReader inputReader = new InputReader(scanner, inputParser);

        int size = inputReader.readSize();
        boolean isPvP = inputReader.readYesNoQuestion("Do you want to play with player? (y/n):");

        String message = "Do you want to fill your field automatically? (y/n): ";
        boolean playerFillAutomatically = inputReader.readYesNoQuestion(message);
        boolean opponentFillAutomatically = true;

        if (isPvP) {
            opponentFillAutomatically = inputReader.readYesNoQuestion(message);
        }

        Game game = new Game(isPvP, size, inputReader);
        game.fillPlayerFields(playerFillAutomatically, opponentFillAutomatically);
        game.start();
    }
}
