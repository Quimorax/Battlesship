import java.util.List;
import java.util.Random;

public class RandomShipPlacer extends ShipPlacer{
    private int playerFieldSize;

    @Override
    public void placeShips(PlayerField field, List<Integer> shipSizes) {
        Random random = new Random();
        for (int size : shipSizes) {
            Position position;

            int orientationCount = Orientation.values().length;
            Orientation orientation;

            while (true) {  // generate valid place for ship
                position = new Position(
                        random.nextInt(field.getSize()),
                        random.nextInt(field.getSize())
                );

                orientation = Orientation.values()[random.nextInt(orientationCount)];
                if (isValid(field, position, orientation, size)) {
                    break;
                }
            }

            for (int i = 0; i < size; i++) {
                Position currentPosition = orientation == Orientation.HORIZONTAL ? new Position(position.row(), position.col() + i) : new Position(position.row() + i, position.col());
                field.setCell(currentPosition, PlayerField.CellStatus.SHIP);
            }

        }
    }
}
