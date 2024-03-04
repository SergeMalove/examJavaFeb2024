package examJavaFeb2024;

import java.util.Date;

public class LotteryPresenter {
    private LotteryModel lotteryModel;
    private LotteryView lotteryView;


    public LotteryPresenter(LotteryModel lotteryModel, LotteryView lotteryView) {
        this.lotteryModel = lotteryModel;
        this.lotteryView = lotteryView;
    }

    public void run() {
        System.out.println("Вас привествует система розыгрыша игрушек!\n");
        int point = 0;

        while (point != 5) {
            lotteryView.showMenu();
            point = lotteryView.userInput();
            switch (point) {
                case 1:
                    lotteryModel.fillToyList(lotteryModel.getToys());
                    System.out.println("Создан новый розыгрыш от " + new Date() + "\n");
                    break;
                case 2:
                    if (lotteryModel.getLotToyList().isEmpty()) {
                        lotteryView.showToys(lotteryModel.getLotToyList(), "Cписок разыгрываемых игрушек пуст!\n");
                    } else {
                        lotteryView.showToys(lotteryModel.getLotToyList(), "Список игрушек в лототроне:\n");
                    }
                    break;
                case 3:
                    if (lotteryModel.getLotToyList().isEmpty()) {
                        lotteryView.showToys(lotteryModel.getPrizeToys(), "Cписок призовых игрушек пуст!\n");
                    } else {
                        lotteryView.showToys(lotteryModel.getPrizeToys(), "Список призовых игрушек:\n");
                    }
                    break;
                case 4:
                    lotteryModel.raffle(lotteryModel.getLotToyList(), lotteryModel.getPrizeToys());
                    break;
                case 5:
                    lotteryModel.writeResults(lotteryModel.getPrizeToys());
                    System.out.println("Розыгрыш завершён! До новых встреч!");
                    break;
                default:
                    point = 5;
            }
        }
    }
}
