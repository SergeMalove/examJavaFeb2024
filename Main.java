package examJavaFeb2024;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LotteryModel lotteryModel = new LotteryModel();
        LotteryView lotteryView = new LotteryView();
        LotteryPresenter lotteryPresenter = new LotteryPresenter(lotteryModel, lotteryView);

        List<Toy> toysForLottery = new ArrayList<>();
        toysForLottery.add(new Toy(1, "Toy1", 10, 10));
        toysForLottery.add(new Toy(2, "Toy2", 20, 10));
        toysForLottery.add(new Toy(3, "Toy3", 30, 10));
        toysForLottery.add(new Toy(4, "Toy4", 40, 10));

        lotteryModel.setToys(toysForLottery);
        lotteryPresenter.run();
    }
}
