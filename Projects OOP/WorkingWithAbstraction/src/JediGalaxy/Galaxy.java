package JediGalaxy;

public class Galaxy {
    private Field field;

    public Galaxy(Field field) {
        this.field = field;
    }

    public void moveSith(int row, int col) {
        while (row >= 0 && col >= 0) {
            if (field.isInBounds(row, col)) {
                field.setValue(row, col, 0);
            }
            row--;
            col--;
        }
    }

    public long moveJedi(int row, int col) {
        long starPowerCollected = 0;
        while (row >= 0 && col < this.field.getColLenght(1)) {
            if (field.isInBounds(row, col)) {
                starPowerCollected += this.field.getValue(row, col);
            }

            col++;
            row--;
        }
        return starPowerCollected;
    }
}
