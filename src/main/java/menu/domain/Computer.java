package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.ComputerDto;
import menu.domain.category.Categories;
import menu.domain.category.Category;
import menu.domain.coach.Coaches;

public class Computer {

    List<String> categoryData = List.of(
            "일식", "한식", "중식", "아시안", "양식"
    );
    List<String> menuData = List.of(
            "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼",
            "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음",
            "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채",
            "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜",
            "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"
    );
    Categories categories = new Categories();
    Coaches coaches;
    List<Map.Entry<String, List<String>>> result = new ArrayList<>();
    ComputerDto computerDto;

    public Computer(Coaches coaches) {
        this.coaches = coaches;
        for (int i = 0; i < 5; i++) {
            categories.add(new Category(categoryData.get(i), List.of(menuData.get(i).split(","))));
        }
    }

    // 카테고리 추천 및 추천된 카테고리 저장
    // 중복된 카테고리 2개 초과 X
    public void shuffleCategory() {
        Categories trial = new Categories();
        while (trial.size() < 5) {
            Category category = categories.get(Randoms.pickNumberInRange(1, 5) - 1);
            if (trial.getCount(category) >= 2) {
                continue;
            }
            trial.add(category);
        }
        categories = trial;
    }

    // 각 카테고리를 기준으로 메뉴 추천 진행
    public void shuffleMenu() {
        List<List<String>> menus = new ArrayList<>();
        for (int i = 0; i < coaches.size(); i++) {
            List<String> fiveMenu = categories.getFiveMenu(coaches.get(i));
            menus.add(new ArrayList<>());
            menus.get(i).add(coaches.get(i).getName());
            int finalI = i;
            fiveMenu.forEach(r -> menus.get(finalI).add(r));
        }
        computerDto = new ComputerDto(categories.getCategoryNames(), menus);
    }

    public ComputerDto getDto() {
        return computerDto;
    }
}