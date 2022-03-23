package justin.designpattern.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonObjectTest {

    @DisplayName("싱글톤 개체 두개 만들면 두 개체는 같은 주소를 갖고 있다.")
    @Test
    void singletonTest() {
        SingletonObject obj1 = SingletonObject.getInstance();
        SingletonObject obj2 = SingletonObject.getInstance();

        assertThat(obj1).isSameAs(obj2);
        assertThat(obj1).isEqualTo(obj2);
    }
}