package justin.designpattern.monostate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonostateTest{

    @DisplayName("단순히 저장한 값과 일치하는지 확인한다.")
    @Test
    void testInstance() {
        Monostate monostate = new Monostate();
        for (int x = 0; x < 10; ++x) {
            monostate.setX(x);
            assertThat(x).isEqualTo(monostate.getX());
        }
    }

    @DisplayName("인스턴스 하나 생성되는 것 강제하지 않고 동일성을 유지한다.")
    @Test
    void testInstanceBehaveAsOne() {
        Monostate monostate1 = new Monostate();
        Monostate monostate2 = new Monostate();
        for (int x = 0; x < 10; ++x) {
            monostate2.setX(x);
            assertThat(x).isEqualTo(monostate2.getX());
        }

        assertThat(monostate1).isNotSameAs(monostate2);
        assertThat(monostate1.getX()).isSameAs(monostate2.getX());
    }

}