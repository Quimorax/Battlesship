import java.util.ArrayList;
import java.util.List;

public class PlayerField {
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private CellStatus[][] grid;
    private List<Ship> fleet;

    public PlayerField() {
        this(DEFAULT_SIZE);
    }

    public PlayerField(int size) {
        this.size = size;
        this.fleet = new ArrayList<>();

        this.grid = new CellStatus[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = CellStatus.EMPTY;
            }
        }
    }

    public enum CellStatus {
        EMPTY,     // Пустая клетка (без корабля, выстрела не было)
        SHIP,      // Занята кораблем (выстрела не было)
        MISS,      // Промах (выстрел в пустую клетку)
        HIT,       // Попадание (корабль ранен)
        SUNK       // Затоплен (все палубы корабля уничтожены)
    }

    public void setCell(Position position, CellStatus cellStatus) {
        grid[position.row()][position.col()] = cellStatus;
    }

    public CellStatus getCell(Position position) {
        return grid[position.row()][position.col()];
    }

    public int getSize() {
        return size;
    }
}
