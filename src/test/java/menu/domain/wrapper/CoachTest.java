package menu.domain.wrapper;

import menu.handler.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CoachTest {

    @DisplayName("코치 이름 형식이 다른 경우 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @ValueSource(strings = {"토미1,제임스", "토비@,제임스", "토비-,ARS"})
    void createCoachNameWithInvalidNameFormat(String inputNames) {
        assertThatThrownBy(() -> Coach.from(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_NAME_FORMAT.getException().getMessage());
    }

    @DisplayName("코치 이름의 길이가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @ValueSource(strings = {"토미제임스,제임스", "토비포코포코,제임스", "토비,APPLY"})
    void createCoachNameWithInvalidNameLength(String inputNames) {
        assertThatThrownBy(() -> Coach.from(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_NAME_LENGTH.getException().getMessage());
    }

    @DisplayName("함께 식사하는 코치 인원의 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @ValueSource(strings = {"토미,제임스,포코,포비,유코,아코", "토비포코", "one"})
    void createCoachNameWithInvalidCoachRange(String inputNames) {
        assertThatThrownBy(() -> Coach.from(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_COACH_RANGE.getException().getMessage());
    }
}
