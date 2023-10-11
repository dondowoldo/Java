package foundation.oop.generals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTest {
    static General general;
    static General general2;
    static General general3;

    @BeforeEach
    void init() {
        general = new General("Daniel", 28);
        general2 = new General("Thomas", 20);
        general3 = new General("Jack", 0);
    }

    @Test
    void punch() {
        general.punch(general2);
        assertEquals(28, general.getMotivation());
    }

    @Test
    void gotPunched() {
        general.punch(general2);
        assertEquals(18, general2.getMotivation());
    }

    @Test
    void noMotivation() {
        general3.punch(general);
        assertEquals(28, general.getMotivation());
    }
}