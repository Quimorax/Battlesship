import java.util.*;

public class PlayerFieldRenderer {
    private static final Map<PlayerField.CellStatus, String> symbols = Map.of(
            PlayerField.CellStatus.EMPTY, ".",
            PlayerField.CellStatus.SHIP, "S",
            PlayerField.CellStatus.HIT, "X",
            PlayerField.CellStatus.MISS, "*"
    );

    public static void render(PlayerField firstField, PlayerField secondField) {
        int size = firstField.getSize();

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < 2; k++) {
                PlayerField field = k == 0 ? firstField : secondField;

                for (int j = 0; j < size; j++) {
                    if (j > 0) System.out.print(" ");
                    System.out.print(symbols.get(field.getCell(new Position(i, j))));
                }

                if (k == 0) System.out.print("   |   ");
            }
            System.out.println();
        }
    }
}
