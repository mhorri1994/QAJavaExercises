/**
 * Created by Matthew on 08/08/2017.
 */
public class Paint {
    private String name;
    private double price;
    private double size;
    private double coverage;

    @Override
    public String toString() {
        return "Paint{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", coverage=" + coverage +
                '}';
    }

    public Paint(String name, double price, double size, double coverage) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.coverage = size * coverage;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
