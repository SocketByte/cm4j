package pl.socketbyte.cm4j;

/**
 * Device model information
 */
public enum Cm4jDevice {
    MasterKeys_L(0),
    MasterKeys_S(1),
    MasterKeys_L_White(2),
    MasterKeys_M_White(3),
    MasterMouse_L(4),
    MasterMouse_S(5),
    MasterKeys_M(6),
    MasterKeys_S_White(7),
    MM520(8),
    MM530(9),
    MK750(10),
    CK372(11),
    CK550_552(12),
    CK551(13);

    private int index;

    Cm4jDevice(int index) {
        this.index = index;
    }

    protected int getIndex() {
        return this.index;
    }
}
