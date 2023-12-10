package menu.domain.wrapper;

import menu.handler.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CoachWithRestrictedMenuTest {

    private static Stream<Arguments> testMenuFormat() {
        return Stream.of(
                Arguments.of("토미", "우동-,스시"),
                Arguments.of("제임스", "뇨끼1,월남쌈"),
                Arguments.of("포비", "AAA,고추잡채")
        );
    }

    private static Stream<Arguments> testExistMenu() {
        return Stream.of(
                Arguments.of("토미", "우엉,스시"),
                Arguments.of("제임스", "카츠,월남쌈"),
                Arguments.of("포비", "스파,고추잡채")
        );
    }

    private static Stream<Arguments> testMenuRange() {
        return Stream.of(
                Arguments.of("토미", "우동,스시,월남쌈"),
                Arguments.of("제임스", "가츠동,월남쌈,우동,스시")
        );
    }

    private static Stream<Arguments> testMenuDuplicate() {
        return Stream.of(
                Arguments.of("토미", "우동,우동"),
                Arguments.of("제임스", "월남쌈,월남쌈")
        );
    }

    @DisplayName("메뉴 입력 형식이 다른 경우 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {1}")
    @MethodSource("testMenuFormat")
    void createMenuWithInvalidMenuFormat(String coachName, String restrictedMenu) {
        assertThatThrownBy(() -> CoachWithRestrictedMenu.of(coachName, restrictedMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_MENU_FORMAT.getException().getMessage());
    }

    @DisplayName("메뉴가 존재하지 않는 경우 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {1}")
    @MethodSource("testExistMenu")
    void createMenuWithNonExistentMenu(String coachName, String restrictedMenu) {
        assertThatThrownBy(() -> CoachWithRestrictedMenu.of(coachName, restrictedMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.NON_EXISTENT_MENU.getException().getMessage());
    }

    @DisplayName("메뉴의 개수가 0과 2사이가 아니라면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {1}")
    @MethodSource("testMenuRange")
    void createMenuWithInvalidMenuRange(String coachName, String restrictedMenu) {
        assertThatThrownBy(() -> CoachWithRestrictedMenu.of(coachName, restrictedMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.INVALID_MENU_RANGE.getException().getMessage());
    }

    @DisplayName("못 먹는 메뉴가 중복된다면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {1}")
    @MethodSource("testMenuDuplicate")
    void createMenuWithDuplicate(String coachName, String restrictedMenu) {
        assertThatThrownBy(() -> CoachWithRestrictedMenu.of(coachName, restrictedMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.DUPLICATE_MENU.getException().getMessage());
    }
}
