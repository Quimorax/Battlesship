import java.util.Map;

public class PlayerFieldRenderer {
    private static final Map<PlayerField.CellStatus, String> SYMBOLS = Map.of(
            PlayerField.CellStatus.EMPTY, ".",
            PlayerField.CellStatus.SHIP, "S",
            PlayerField.CellStatus.HIT, "X",
            PlayerField.CellStatus.MISS, "*",
            PlayerField.CellStatus.FOG, "~",
            PlayerField.CellStatus.SUNK, "!"
    );

    private static final String FIELD_GAP = "     ";  // length 5

    public static void render(PlayerField firstField, PlayerField secondField, PlayerField currentField) {
        int size = firstField.getSize();

        printHeader(size);
        System.out.print(FIELD_GAP);
        printHeader(size);
        System.out.println();

        for (int row = 0; row < size; row++) {
            printRow(firstField, row, size, firstField != currentField);
            System.out.print(FIELD_GAP);
            printRow(secondField, row, size, secondField != currentField);
            System.out.println();
        }
    }

    public static void render(PlayerField field) {
        int size = field.getSize();
        boolean fillWithFog = false;

        printHeader(size);
        System.out.println();

        for (int row = 0; row < size; row++) {
            printRow(field, row, size, fillWithFog);
            System.out.println();
        }
    }

    private static void printHeader(int size) {
        System.out.print(FIELD_GAP);
        for (int col = 0; col < size; col++) {
            System.out.print((char) ('A' + col) + " ");
        }
    }

    private static void printRow(PlayerField field, int row, int size, boolean fillWithFog) {
        System.out.printf("%2d | ", row + 1);
        for (int col = 0; col < size; col++) {
            String symbol = SYMBOLS.getOrDefault(field.getCell(new Position(row, col)), "?");
            if (fillWithFog) {
                if (symbol.equals(SYMBOLS.get(PlayerField.CellStatus.SHIP)) || symbol.equals(SYMBOLS.get(PlayerField.CellStatus.EMPTY))) {
                    symbol = SYMBOLS.get(PlayerField.CellStatus.FOG);
                }
            }
            System.out.print(symbol + " ");
        }
    }
}