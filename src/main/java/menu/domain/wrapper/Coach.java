package menu.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static menu.handler.ConstantsHandler.*;
import static menu.handler.ErrorHandler.*;

public class Coach {

    private final List<String> coachNames;

    private Coach(String inputNames) {
        this.coachNames = validateNameFormat(inputNames);
        validateNameLength(coachNames);
        validateCoachRange(coachNames);
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

    private void validateNameLength(List<String> coachNames) {
        for (String coachName : coachNames) {
            if (coachName.length() < MIN_COACH_NAME.getValue() || coachName.length() > MAX_COACH_NAME.getValue()) {
                throw INVALID_NAME_LENGTH.getException();
            }
        }
    }

    private void validateCoachRange(List<String> coachNames) {
        if (coachNames.size() < MIN_COACH.getValue() || coachNames.size() > MAX_COACH.getValue()) {
            throw INVALID_COACH_RANGE.getException();
        }
    }
}
