package examJavaFeb2024;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LotteryModel {
    private List<Toy> toys;
    private List<Toy> lotToyList;
    private List<Toy> prizeToys;
    Random random = new Random();

    public LotteryModel() {
        this.lotToyList = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
    }

    public List<Toy> getLotToyList() {
        return lotToyList;
    }

    public List<Toy> getPrizeToys() {
        return prizeToys;
    }

    public void fillToyList(List<Toy> newToyList) {
        lotToyList = new ArrayList<>();
        for (Toy toy : newToyList) {
            addToy(toy.clone(), lotToyList);
        }
        lotToyList.sort(new ToyComparator());
    }

    public void addToy(Toy toy, List<Toy> toyList) {
        toyList.add(toy);
    }

    public void raffle(List<Toy> toyList, List<Toy> prizeToys) {
        if (!toyList.isEmpty()) {
            int randomNum = random.nextInt(100) + 1;
            boolean isWin = false;
            for (Toy toy : toyList) {
                if (randomNum <= toy.getWeight()) {
                    Toy prizeToy = new Toy(toy.getId(), toy.getName(), toy.getWeight(), 1);
                    addToy(prizeToy, prizeToys);
                    int newQTY = toy.getQuantity() - 1;
                    toy.setQuantity(newQTY);
                    if (newQTY == 0) {
                        toyList.remove(toy);
                    }
                    System.out.println("Поздравляем! Вы выиграли игрушку!\nID: " + toy.getId() +
                            ", Name: " + toy.getName() + ", Weight: " + toy.getWeight() + "\n");
                    isWin = true;
                    break;
                }
            }
            if (!isWin) {
                System.out.println("Неудача! Не одна игрушка не выпала! Попробуйте еще раз!\n");
            }
        } else {
            System.out.println("В лототроне не осталось игрушек для розыгрыша!\n");
        }
    }

    public void writeResults(List<Toy> prizeToys) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("prizeToys.txt", true))) {
            bw.write("Розыгрыш от " + new Date() + "\n");
            for (Toy toy : prizeToys) {
                bw.write(toy.toString() + "\n");
            }
            bw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public List<Toy> getToys() {
        return toys;
    }
}
