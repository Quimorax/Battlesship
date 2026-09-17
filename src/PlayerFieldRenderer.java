import java.util.Map;

public class PlayerFieldRenderer {
    private static final Map<PlayerField.CellStatus, String> SYMBOLS = Map.of(
            PlayerField.CellStatus.EMPTY, ".",
            PlayerField.CellStatus.SHIP, "S",
            PlayerField.CellStatus.HIT, "X",
            PlayerField.CellStatus.MISS, "*"
    );

    private static final String FIELD_GAP = "     ";  // length 5

    public static void render(PlayerField firstField, PlayerField secondField) {
        int size = firstField.getSize();

        printHeader(size);
        System.out.print(FIELD_GAP);
        printHeader(size);
        System.out.println();

        for (int row = 0; row < size; row++) {
            printRow(firstField, row, size);
            System.out.print(FIELD_GAP);
            printRow(secondField, row, size);
            System.out.println();
        }
    }

    private static void printHeader(int size) {
        System.out.print(FIELD_GAP); // Отступ под номера строк (например: " 1 | ")
        for (int col = 0; col < size; col++) {
            System.out.print((char) ('A' + col) + " ");
        }
    }

    private static void printRow(PlayerField field, int row, int size) {
        System.out.printf("%2d | ", row + 1);
        for (int col = 0; col < size; col++) {
            String symbol = SYMBOLS.getOrDefault(field.getCell(new Position(row, col)), "?");
            System.out.print(symbol + " ");
        }
    }
}