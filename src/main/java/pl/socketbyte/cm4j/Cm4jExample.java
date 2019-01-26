package pl.socketbyte.cm4j;

import java.awt.*;

public class Cm4jExample {

    public static void main(String[] args) {
        Cm4j cm4j = new Cm4j(Cm4jDevice.MK750);
        cm4j.enable();

        cm4j.setEffect(Cm4jEffect.WATER_RIPPLE);
        cm4j.setKeyboardColor(new Cm4jColor(0, 0, 255));
        cm4j.setKeyColor(2, 5, Cm4jColor.from(Color.MAGENTA));

        cm4j.disable();

        Cm4jDevice device = cm4j.getDevice();
        Cm4jLayout layout = cm4j.getLayout();

        boolean isPlugged = cm4j.isDevicePlugged();
        float volumePeek = cm4j.getVolumePeekValue();
        int version = cm4j.getSdkVersion();
    }
}
