package menu.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static menu.handler.ConstantsHandler.COMMA_DELIMITER;
import static menu.handler.ErrorHandler.INVALID_NAME_FORMAT;

public class Coach {

    private final List<String> coachNames;

    private Coach(String inputNames) {
        this.coachNames = validateNameFormat(inputNames);
    }

    public static Coach from(String inputNames) {
        return new Coach(inputNames);
    }

    private List<String> validateNameFormat(String inputNames) {
        String regex = "^[a-z|A-Z|ㄱ-ㅎ|가-힣|,]+$";

        if (!Pattern.matches(regex, inputNames)) {
            throw INVALID_NAME_FORMAT.getException();
        }

        return Arrays.stream(inputNames.split(COMMA_DELIMITER.getWord()))
                .collect(Collectors.toList());
    }
}
