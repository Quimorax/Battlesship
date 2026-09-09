import java.util.List;

public class ManualShipPlacer extends ShipPlacer {
    private final InputParser parser;

    public ManualShipPlacer(InputParser parser) {
        this.parser = parser;
    }

    @Override
    public void placeShips(PlayerField field, List<Integer> shipSizes) {
        // TODO: add feature, that you init also List<Ship> list
        for (int size : shipSizes) {
            Position position;
            Orientation orientation;
            int[] values;

            while (true) {
                try {
                    values = parser.parseShipPlacement(size, field.getSize());
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Enter one more time");
                    continue;
                }
                position = new Position(values[0], values[1]);
                orientation = Orientation.values()[values[2]];  // ??

                if (isValid(field, position, orientation, size)) {
                    break;
                }
            }

            // fill in into place this this...

        }
    }
}
