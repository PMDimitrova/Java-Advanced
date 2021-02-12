package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                this.calculateSurfaceArea(),
                this.calculateLateralSurfaceArea(),
                this.calculateVolume());
    }

    private void setHeight(double height) {
        if (!isValueCorrect(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;

    }

    private void setLength(double length) {
        if (isValueCorrect(length)) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    public void setWidth(double width) {
        if (isValueCorrect(width)) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private boolean isValueCorrect(double num) {
        return !(num <= 0);
    }

    public double calculateSurfaceArea() {
        return 2 * (this.length * this.width) + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (this.length * this.height) + 2 * (this.height * this.width);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}