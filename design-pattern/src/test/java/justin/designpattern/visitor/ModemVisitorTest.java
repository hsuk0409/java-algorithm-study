package justin.designpattern.visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModemVisitorTest {

    private UnixModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private ErnieModem e;

    @BeforeEach
    public void setup() {
        v = new UnixModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        e = new ErnieModem();
    }

    @DisplayName("비지터 패턴 계층 구조를 검증한다.")
    @Test
    void testModemOfVisitorPattern() {
        h.accept(v);
        assertThat(h.configurationString).isEqualTo("justin");

        z.accept(v);
        assertThat(z.configurationValue).isEqualTo(42);

        e.accept(v);
        assertThat(e.internalPattern).isEqualTo("C is too slow");
    }

}