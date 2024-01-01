package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    private enum Message {
        INPUT_MAIN_OPTION("메인 옵션");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    public String read() {
        System.out.println(Message.INPUT_MAIN_OPTION.message);
        return Console.readLine();
    }

}