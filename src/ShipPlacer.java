import java.util.*;

public abstract class ShipPlacer {
    private static final List<Integer> DEFAULT_SHIP_SIZES = List.of(4, 3, 2, 1);

    public abstract void placeShips(PlayerField field, List<Integer> shipSizes);

    protected boolean isValid(PlayerField field, Position position, Orientation orientation, int shipSize) {
        // row -- number, col -- letter
        for (int shift = 0; shift < shipSize; shift++){
            Position shiftedPosition = PositionUtils.shift(position, orientation, shift);
            if (!PositionUtils.isInRange(shiftedPosition, field.getSize())) {
                return false;
            }
            if (field.getCell(shiftedPosition) != PlayerField.CellStatus.EMPTY || isShipNear(shiftedPosition, field)) {
                return false;
            }
        }
        return true;
    }

    protected void setShipPlace(PlayerField field, Position position, Orientation orientation, int shipSize) {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < shipSize; i++) {
            Position currentPosition = PositionUtils.shift(position, orientation, i);
            positions.add(currentPosition);
            field.setCell(currentPosition, PlayerField.CellStatus.SHIP);
        }

        Ship ship = new Ship(positions);
        field.addSHip(ship);
    }

    private boolean isShipNear(Position position, PlayerField field) {
        int[][] shifts = new int[][]{
                {1, 1},
                {-1, -1},
                {1, -1},
                {-1, 1},
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        for (int[] shift : shifts) {
            Position shiftedPosition = PositionUtils.shift(position, shift[0], shift[1]);
            if (PositionUtils.isInRange(shiftedPosition, field.getSize())) {
                if (field.getCell(shiftedPosition) == PlayerField.CellStatus.SHIP) {
                    return true;
                }
            };
        }

        return false;
    }

    public static List<Integer> getDefaultShipSizes() {
        return DEFAULT_SHIP_SIZES;
    }
}
