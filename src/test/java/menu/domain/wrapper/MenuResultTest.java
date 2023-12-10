package menu.domain.wrapper;

import menu.handler.ErrorHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuResultTest {

    private static Stream<Arguments> testDuplicateCategory() {
        return Stream.of(
                Arguments.of("토미,포비", List.of("우동", "스시", "김밥", "월남쌈", "규동"), List.of("일식", "일식", "한식", "아시안", "일식")),
                Arguments.of("제임스,초코", List.of("우동", "팟타이", "김밥", "월남쌈", "나시고렝"), List.of("일식", "아시안", "한식", "아시안", "아시안"))
        );
    }

    @DisplayName("카테고리가 3회 이상 중복되면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0}")
    @MethodSource("testDuplicateCategory")
    void createCategoryWithDuplicate(String coachName, List<String> recommendMenu, List<String> categories) {
        assertThatThrownBy(() -> MenuResult.of(coachName, recommendMenu, categories))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorHandler.DUPLICATE_CATEGORY.getException().getMessage());
    }
}
