package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String notifyAndRead(String message){
        System.out.println(message);
        return Console.readLine();
    }
}