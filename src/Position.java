public record Position(int row, int col) {
    public Position {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Coordinates can't be < 0");
        }
    }
}
