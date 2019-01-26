package pl.socketbyte.cm4j;

/**
 * Keyboard layout information
 */
public enum Cm4jLayout {
    INVALID(0),
    US(1),
    EU(2),
    JP(3);

    private int index;

    Cm4jLayout(int index) {
        this.index = index;
    }

    protected int getIndex() {
        return this.index;
    }

    protected static Cm4jLayout fromIndex(int index) {
        for (Cm4jLayout layout : Cm4jLayout.values()) {
            if (index == layout.getIndex())
                return layout;
        }
        return Cm4jLayout.INVALID;
    }
}
