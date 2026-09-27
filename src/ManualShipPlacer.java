import java.util.List;

public class ManualShipPlacer extends ShipPlacer {
    private final InputReader reader;

    public ManualShipPlacer(InputReader reader) {
        this.reader = reader;
    }

    @Override
    public void placeShips(PlayerField field, List<Integer> shipSizes) {
        for (int size : shipSizes) {
            Position position;
            Orientation orientation;
            int[] values;

            while (true) {
                values = reader.readShipPlacement(size, field.getSize());
                position = new Position(values[0], values[1]);
                orientation = Orientation.values()[values[2]];

                if (isValid(field, position, orientation, size)) {
                    break;
                }
                System.out.println("Position isn't valid, enter one more time\n");
            }

            setShipPlace(field, position, orientation, size);
            PlayerFieldRenderer.render(field);
        }
    }
}
