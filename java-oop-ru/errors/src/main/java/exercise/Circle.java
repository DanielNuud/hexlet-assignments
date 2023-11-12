package exercise;

// BEGIN
public class Circle extends Point {
    private int radius;

    Circle(Point point, int radius) {
        super(point.getX(), point.getY());
        this.radius = radius;
    }


    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0){
            throw new NegativeRadiusException("Negative radius!");
        }
        return Math.PI * radius * radius;
    }
}
// END
