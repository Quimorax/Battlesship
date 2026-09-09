import java.util.Scanner;

class ParseException extends RuntimeException {
    public ParseException(String message) {
        super(message);
    }
}

public class InputParser {
    private Scanner scanner;

    public InputParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean parseYesNoQuestions(String message) {
        System.out.println(message);
        String input = scanner.next().replace("\\s+", "").toLowerCase();

        if (input.equals("y")) {
            return true;
        } else if (input.equals("n")) {
            return false;
        }
        throw new ParseException("You must enter only y\\n");
    }

    public int parseSize() {
        System.out.println("Enter desk size: ");
        String input = scanner.next();

        int size;
        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParseException(e.getMessage());
        }
        if (size <= 0 || size > 26) {
            throw new ParseException("Size must be in range 0 < size <= 26");
        }

        return size;
    }

    public Position parseShipPlacement(int shipPlacement) {

    }
}
