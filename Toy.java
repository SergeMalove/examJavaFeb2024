package examJavaFeb2024;

public class Toy extends BaseToy implements Cloneable{

    public Toy(int id, String name, int weight, int quantity) {
        super(id, name, weight, quantity);
    }

    public Toy clone() {
        try {
            return (Toy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
