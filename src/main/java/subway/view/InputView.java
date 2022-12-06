package subway.view;

import java.util.Scanner;
import subway.constant.MainCommand;

public class InputView {

    private static final String INPUT_VIEW_PREFIX = "## ";
    private static final String INPUT_MAIN_COMMAND = INPUT_VIEW_PREFIX + "원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_TO_REGISTER = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_TO_DELETE = "삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_TO_REGISTER = "등록할 노선 이름을 입력하세요.";
    private static final String INPUT_LINE_TO_DELETE = "삭제할 노선 이름을 입력하세요.";
//    private static final String = "등록할 노선의 상행 종점역 이름을 입력하세요.";
//    private static final String = "등록할 노선의 하행 종점역 이름을 입력하세요.";
//    private static final String = "노선을 입력하세요.";
//    private static final String = "역이름을 입력하세요.";
//    private static final String = "순서를 입력하세요.";
//    private static final String = "삭제할 구간의 노선을 입력하세요.";
//    private static final String = "삭제할 구간의 역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readCommand() {
        System.out.println(INPUT_MAIN_COMMAND);
        return MainCommand.from(readLine());
    }

    private String readLine() {
        String input = scanner.nextLine().trim();
        validateHasInput(input);
        return input;
    }

    private void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
