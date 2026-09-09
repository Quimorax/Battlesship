import java.util.*;

public abstract class ShipPlacer {
    int[] DEFAULT_SHIP_SIZES = new int[]{4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

    public abstract void placeShips(PlayerField field, int[] shipSizes);

    protected boolean isValid(PlayerField field, Position position, Orientation orientation, int shipSize) {
        int row = position.row();
        int col = position.col();

        Position shiftedPosition;
        int changedValue;
        for (int shift = 0; shift < shipSize; shift++){
            if (orientation == Orientation.HORIZONTAL) {
                changedValue = col + shift;
                shiftedPosition = new Position(row, col + shift);
            } else {
                changedValue = row + shift;
                shiftedPosition = new Position(row + shift, col);
            }
            if (changedValue < 0 || changedValue >= field.getSize()) {
                return false;
            }

            if (field.getCell(shiftedPosition) != PlayerField.CellStatus.EMPTY) {
                return false;
            }
            shipSize--;
        }
        return true;
    }
}
