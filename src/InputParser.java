public class InputParser {

    public boolean parseYesNo(String input) {
        String cleanInput = input.trim().toLowerCase();
        if (cleanInput.equals("y")) {
            return true;
        } else if (cleanInput.equals("n")) {
            return false;
        }
        throw new ParseException("You must enter only y/n");
    }

    public int parseSize(String input) {
        int size;
        try {
            size = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new ParseException("Incorrect format");
        }
        if (size <= 0 || size > 26) {
            throw new ParseException("Size must be in range 0 < size <= 26");
        }
        return size;
    }

    public int[] parseShipPlacement(String input, int fieldSize) {
        String[] values = input.trim().split("\\s+");
        if (values.length != 2) {
            throw new ParseException("You must type coordinate and orientation");
        }

        Position position = parsePosition(values[0], fieldSize);

        String value = values[1].toUpperCase();
        if (!value.equals("H") && !value.equals("V")) {
            throw new ParseException("Orientation must be H or V");
        }

        Orientation orientation = value.equals("H") ? Orientation.HORIZONTAL : Orientation.VERTICAL;

        return new int[]{position.row(), position.col(), orientation.ordinal()};
    }

    public Position parsePosition(String input, int fieldSize) {
        if (input.length() != 2) {
            throw new ParseException("Coordinate length must be 2");
        }

        String upperInput = input.toUpperCase();
        if (upperInput.charAt(0) < 'A' || upperInput.charAt(0) > 'A' + fieldSize - 1) {
            throw new ParseException("First part of coordinate is out of range");
        }
        if (upperInput.charAt(1) < '1' || upperInput.charAt(1) > '1' + fieldSize - 1) {
            throw new ParseException("Second part of coordinate is out of range");
        }

        int row = upperInput.charAt(1) - '1';
        int col = upperInput.charAt(0) - 'A';

        return new Position(row, col);
    }
}