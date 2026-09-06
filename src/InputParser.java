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

    public boolean parsePvP() {
        return parseYesNoQuestions("Do you want to play with player? (y/n): ");
    }

    public boolean parseAutomaticFilling() {
        return parseYesNoQuestions("Do you want to init your field automatically? (y/n): ");
    }

    private boolean parseYesNoQuestions(String message) {
        System.out.println(message);
        String input = scanner.next().replace("\\s+", "").toLowerCase();

        if (input.equals("y")) {
            return true;
        } else if (input.equals("n")) {
            return false;
        }
        throw new ParseException("You must enter only y\\n");
    }

    public Postion parsePosition(String input) {

    }
}
