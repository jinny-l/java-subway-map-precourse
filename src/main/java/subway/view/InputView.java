package subway.view;

import java.util.Scanner;
import subway.constant.ErrorMessage;

public class InputView {

    private static final String INPUT_VIEW_PREFIX = "## ";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readCommand() {
        System.out.printf("%s원하는 기능을 선택하세요.%n", INPUT_VIEW_PREFIX);
        return readLine();
    }

    public String readObjectToRegister(String object) {
        System.out.printf("%n%s등록할 %s을 입력하세요.%n", INPUT_VIEW_PREFIX, object);
        return readLine();
    }

    public String readObjectToDelete(String object) {
        System.out.printf("%n%s삭제할 %s을 입력하세요.%n", INPUT_VIEW_PREFIX, object);
        return readLine();
    }

    private String readLine() {
        String input = scanner.nextLine().trim();
        validateHasInput(input);
        return input;
    }

    private void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString());
        }
    }
}
