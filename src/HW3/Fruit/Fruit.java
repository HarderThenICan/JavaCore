package HW3.Fruit;

public class Fruit  {
    private double wight;

    public double getWight() {
        return wight;
    }

    public Fruit(double wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "wight=" + wight +
                '}';
    }
}