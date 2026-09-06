import java.util.List;

public class Ship {
    private List<Position> positions;
    private int hits = 0;

    public Ship(List<Position> positions) {
        this.positions = positions;  // length = size of the ship
    }

    public boolean occupies(Position pos) {
        return positions.contains(pos);
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= positions.size();
    }

    public List<Position> getPositions() {
        return positions;
    }
}
