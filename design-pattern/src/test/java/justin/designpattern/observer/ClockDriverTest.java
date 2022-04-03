package justin.designpattern.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClockDriverTest {

    private MockTimeSource source;
    private MockTimeSink sink;

    @BeforeEach
    void setup() {
        source = new MockTimeSource();
        sink = new MockTimeSink();
        source.registerObserver(sink);
    }

    @DisplayName("[옵저버 패턴 시간 예제] 코드를 점진적으로 개선하여 옵저버 패턴의 모양이 드러날 때 사용한다.")
    @Test
    void testTimeChange() {
        source.setTime(15, 30, 25);
        assertThat(sink.getHours()).isEqualTo(15);
        assertThat(sink.getMinutes()).isEqualTo(30);
        assertThat(sink.getSeconds()).isEqualTo(25);
    }
}