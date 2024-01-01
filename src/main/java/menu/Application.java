package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            List<String> list = List.of("a", "b", "c", "d", "e", "f");
            list = Randoms.shuffle(list);
            System.out.println(list);
        }
//        Controller controller = new Controller(InputView.getInstance(), OutputView.getInstance());
//        controller.run();
    }
}