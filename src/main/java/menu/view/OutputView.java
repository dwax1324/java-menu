package menu.view;

import java.util.List;
import menu.ComputerDto;

public class OutputView {
    public void printByMessage(String message) {
        System.out.println(message);
    }

    public void printResult(ComputerDto dto) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(dto);
        printMenu(dto);
    }

    private void printMenu(ComputerDto dto) {
        List<List<String>> menus = dto.menus();
        StringBuilder result = new StringBuilder();
        for (List<String> recommendMenus : menus) {
            result.append("[ ");
            recommendMenus.forEach(r -> result.append(r).append(" | "));
            result.setLength(result.length() - 3);
            result.append(" ]\n");
        }
        System.out.print(result);
    }

    private void printCategory(ComputerDto dto) {
        StringBuilder result = new StringBuilder();
        result.append("[ 카테고리 | ");
        for (String name : dto.categories()) {
            result.append(name).append(" | ");
        }
        result.setLength(result.length() - 3);
        result.append(" ]");
        System.out.println(result);
    }
}