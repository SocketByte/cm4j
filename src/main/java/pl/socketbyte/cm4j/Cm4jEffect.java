package pl.socketbyte.cm4j;

/**
 * Coolermaster default effects to set
 */
public enum Cm4jEffect {
    FULL_ON(0),
    BREATH(1),
    BREATH_CYCLE(2),
    SINGLE(3),
    WAVE(4),
    RIPPLE(5),
    CROSS(6),
    RAIN(7),
    STAR(8),
    SNAKE(9),
    REC(10),
    SPECTRUM(11),
    RAPID_FIRE(12),
    INDICATOR(13),
    FIRE_BALL(14),
    WATER_RIPPLE(15),
    REACTIVE_PUNCH(16),
    SNOWING(17),
    HEART_BEAT(18),
    REACTIVE_TORNADO(19),
    MULTI_1(0xE0), 
    MULTI_2(0xE1),
    MULTI_3(0xE2),
    MULTI_4(0xE3),
    OFF(0xFE);

    private int index;

    Cm4jEffect(int index) {
        this.index = index;
    }

    protected int getIndex() {
        return this.index;
    }
}
