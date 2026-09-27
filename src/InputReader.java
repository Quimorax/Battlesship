import java.util.Scanner;
import java.util.function.Supplier;

public class InputReader {
    private final Scanner scanner;
    private final InputParser parser;

    public InputReader(Scanner scanner, InputParser parser) {
        this.scanner = scanner;
        this.parser = parser;
    }

    private <T> T handleInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter one more time:");
            }
        }
    }

    public boolean readYesNoQuestion(String message) {
        return handleInput(() -> {
            System.out.println(message);
            return parser.parseYesNo(scanner.nextLine());
        });
    }

    public int readSize() {
        return handleInput(() -> {
            System.out.println("Enter desk size: ");
            return parser.parseSize(scanner.nextLine());
        });
    }

    public int[] readShipPlacement(int shipSize, int fieldSize) {
        return handleInput(() -> {
            System.out.println("Enter placement for your ship with size " + shipSize + " in format A4 H (or E7 V): ");
            return parser.parseShipPlacement(scanner.nextLine(), fieldSize);
        });
    }

    public Position readPosition(int fieldSize) {
        return handleInput(() -> {
            System.out.println("Enter position: ");
            return parser.parsePosition(scanner.nextLine(), fieldSize);
        });
    }
}