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
            throw new ParseException("Incorrect format");
        }
        if (size <= 0 || size > 26) {
            throw new ParseException("Size must be in range 0 < size <= 26");
        }

        return size;
    }

    public int[] parseShipPlacement(int shipSize, int fieldSize) {
        System.out.println("Enter placement for your ship with size " + shipSize + " in format A4 H (or E7 V): ");
        String input = scanner.nextLine();

        String[] values = input.split(" ");
        if (values.length != 2) {
            throw new ParseException("You must typed coordinate and orientation");
        }

        Position position = parsePosition(values[0], fieldSize);

        String value = values[1].toUpperCase();
        if (!value.equals("H") && !value.equals("V")) {
            throw new ParseException("");
        }

        Orientation orientation = value.equals("H") ? Orientation.HORIZONTAL : Orientation.VERTICAL;

        return new int[]{position.row(), position.col(), orientation.ordinal()};
    }

    public Position parsePosition(String input, int fieldSize) {
        if (input.length() != 2) {
            throw new ParseException("Coordinate length must be 2");
        }
        if (input.charAt(0) < 'A' || input.charAt(0) > 'A' + fieldSize - 1) {
            throw new ParseException("First part of coordinate is out of range");
        }
        if (input.charAt(1) < '1' || input.charAt(1) > '1' + fieldSize - 1) {
            throw new ParseException("Second part of coordinate is out of range");
        }

        int row = input.charAt(1) - '1';
        int col = input.charAt(0) - 'A';

        return new Position(row, col);
    }
}
