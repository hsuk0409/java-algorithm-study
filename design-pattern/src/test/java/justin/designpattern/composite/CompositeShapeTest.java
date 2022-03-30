package justin.designpattern.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompositeShapeTest {

    @DisplayName("콘솔에 문자를 출력하는 간단한 컴포지트 개체")
    @Test
    void compositeTest() {
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.add(() -> System.out.println("First Shape"));
        compositeShape.add(() -> System.out.println("Second Shape"));

        compositeShape.draw();
    }
}