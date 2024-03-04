package examJavaFeb2024;

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getWeight() - toy2.getWeight();
    }
}
