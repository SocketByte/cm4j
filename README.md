# Cm4j
### High-level API and bindings to Coolermaster SDK

## Usage
```java
public class Cm4jExample {

    public static void main(String[] args) {
        // Create the Cm4j instance and assign your keyboard/mouse model
        Cm4j cm4j = new Cm4j(Cm4jDevice.MK750);
        // Take control over your LEDs (enable the Software mode)
        cm4j.enable();

        // Apply effect
        cm4j.setEffect(Cm4jEffect.WATER_RIPPLE);
        // Set keyboard full color (all LEDs)
        cm4j.setKeyboardColor(new Cm4jColor(0, 0, 255));
        // Set single-key LED color
        cm4j.setKeyColor(2, 5, Cm4jColor.from(Color.MAGENTA));

        // Turn the keyboard back into Firmware mode
        cm4j.disable();

        // Get the device information
        Cm4jDevice device = cm4j.getDevice();
        // Get current keyboard layout
        Cm4jLayout layout = cm4j.getLayout();

        // Other methods
        boolean isPlugged = cm4j.isDevicePlugged();
        float volumePeek = cm4j.getVolumePeekValue();
        int version = cm4j.getSdkVersion();
    }
}
``` 