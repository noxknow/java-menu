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
    void createMenuByInvalidMenuFormat(String inputNames) {
        assertThatThrownBy(() -> Coach.from(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_NAME_FORMAT.getException().getMessage());
    }
}
