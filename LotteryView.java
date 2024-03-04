package examJavaFeb2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LotteryView {
    public void showMenu() {
        System.out.println("1. Создать новый розыгрыш\n" +
                "2. Показать список игрушек в лототроне\n" +
                "3. Показать список призовых игрушек\n" +
                "4. Провести розыгрыш\n" +
                "5. Выйти из программы\n");
    }

    public void showToys(List<Toy> toysList, String s) {
        System.out.println(s);
        for (Toy t: toysList) {
            System.out.println(t.toString());
        }
        System.out.println();
    }

    public int userInput() {
        String n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введит пункт меню: ");
        try {
            while (true) {
                n = reader.readLine();
                if (n.matches("[1-5]")) {
                    break;
                }
                System.out.println("Неправильный ввод пункта меню.");
            }
            //reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Integer.parseInt(n);
    }
}
