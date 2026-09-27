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

            do {
                position = PositionUtils.generateRandomPosition(field.getSize());
                orientation = Orientation.values()[random.nextInt(orientationCount)];
            } while (!isValid(field, position, orientation, size));

            setShipPlace(field, position, orientation, size);

        }
    }
}
