package menu.controller;

import java.util.Arrays;
import java.util.List;
import menu.domain.Computer;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {


    InputView inputView;
    OutputView outputView;
    Computer computer;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            outputView.printByMessage("점심 메뉴 추천을 시작합니다.");
            computer = new Computer(getCoachInformation());
            computer.shuffleCategory();
            computer.shuffleMenu();
            outputView.printResult(computer.getDto());
        } catch (IllegalArgumentException e) {
            outputView.printByMessage(e.getMessage());
        }
    }

    private Coaches getCoachInformation() {
        String input = inputView.notifyAndRead("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.asList(input.split(","));
        Coaches coaches = new Coaches();
        for (int i = 0; i < coachNames.size(); i++) {
            String input2 = inputView.notifyAndRead(coachNames.get(i) + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            List<String> coachMenus = Arrays.asList(input2.split(","));
            coaches.add(new Coach(coachNames.get(i), coachMenus));
        }
        return coaches;
    }

}
