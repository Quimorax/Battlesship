import java.util.Random;

public class PositionUtils {
    public static Position shift(Position position, Orientation orientation, int shift) {
        if (orientation == Orientation.HORIZONTAL) {
            return new Position(position.row(), position.col() + shift);
        }
        return new Position(position.row() + shift, position.col());
    }

    public static Position shift(Position position, int rowShift, int columnShift) {
        return new Position(position.row() + rowShift, position.col() + columnShift);
    }

    public static boolean isInRange(Position position, int fieldSize) {
        int row = position.row();
        int col = position.col();

        return row >= 0 && row < fieldSize && col >= 0 && col < fieldSize;
    }

    public static Position generateRandomPosition(int fieldSize) {
        Random random = new Random();

        return new Position(
                random.nextInt(fieldSize),
                random.nextInt(fieldSize)
        );
    }
}
