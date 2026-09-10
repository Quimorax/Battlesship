import java.util.*;

public abstract class ShipPlacer {
    private static final List<Integer> DEFAULT_SHIP_SIZES = List.of(4, 3, 3, 2, 2, 2, 1, 1, 1, 1);

    public abstract void placeShips(PlayerField field, List<Integer> shipSizes);

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

    protected void setShipPlace(PlayerField field, Position position, Orientation orientation, int shipSize) {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < shipSize; i++) {
            Position currentPosition = orientation == Orientation.HORIZONTAL ? new Position(position.row(), position.col() + i) : new Position(position.row() + i, position.col());
            positions.add(currentPosition);
            field.setCell(currentPosition, PlayerField.CellStatus.SHIP);
        }

        Ship ship = new Ship(positions);
        field.addSHip(ship);
    }

    public static List<Integer> getDefaultShipSizes() {
        return DEFAULT_SHIP_SIZES;
    }
}
