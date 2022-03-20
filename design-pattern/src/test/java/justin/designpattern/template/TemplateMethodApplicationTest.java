package justin.designpattern.template;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TemplateMethodApplicationTest {

    @DisplayName("템플릿 메서드 매펀, 추상 클래스르 사용한 구현부 위임 테스트")
    @Test
    void testTemplateMethod() {
        TemplateMethodApplication application = new TemplateMethod();

        application.run();

    }

}