package pl.socketbyte.cm4j;

import com.sun.jna.Native;

public class Cm4j {

    /**
     * Holds the Cm4jLibrary instance.
     * It is very important, as it handles all the connection between
     * Java and C library.
     */
    private static final Cm4jLibrary CM4J_LIBRARY;

    static {
        // Loads library named SDKDLL.dll or SDKDLL.lib
        // It must be named like that in order to work properly!
        // Requires JNA to work.
        CM4J_LIBRARY = Native.load("SDKDLL", Cm4jLibrary.class);
    }

    private Cm4jDevice device;

    /**
     * Cm4j main constructor that requires the Cm4jDevice object to work
     * @param device Cm4jDevice object holding the information about the device
     */
    public Cm4j(Cm4jDevice device) {
        this.device = device;
        CM4J_LIBRARY.SetControlDevice(this.device.getIndex());
    }

    /**
     * Enables the LED connection.
     * Turns the keyboard into "SW" (Software) mode
     * @return True if everything went successfull, otherwise false
     */
    public boolean enable() {
        return CM4J_LIBRARY.EnableLedControl(true, this.device.getIndex());
    }

    /**
     * Disables the LED connection.
     * Turns the keyboard into "FM" (Firmware) mode
     * @return True if everything went successfull, otherwise false
     */
    public boolean disable() {
        return CM4J_LIBRARY.EnableLedControl(false, this.device.getIndex());
    }

    /**
     * @return Current Coolermaster SDK version
     */
    public int getSdkVersion() {
        return CM4J_LIBRARY.GetCM_SDK_DllVer();
    }

    /**
     * Sets the full keyboard LED colors (every key)
     * @param color The color to set
     * @return True if everything went successfull, otherwise false
     */
    public boolean setKeyboardColor(Cm4jColor color) {
        return CM4J_LIBRARY.SetFullLedColor(
                color.getRedAsByte(),
                color.getGreenAsByte(),
                color.getBlueAsByte(),
                device.getIndex());
    }

    /**
     * Sets the single-key LED color
     * @param color The color to set
     * @return True if everything went successfull, otherwise false
     */
    public boolean setKeyColor(int row, int column, Cm4jColor color) {
        return CM4J_LIBRARY.SetLedColor(row, column,
                color.getRedAsByte(),
                color.getGreenAsByte(),
                color.getBlueAsByte(),
                device.getIndex());
    }

    /**
     * @return If the device is plugged and works properly
     */
    public boolean isDevicePlugged() {
        return CM4J_LIBRARY.IsDevicePlug();
    }

    /**
     * Sets the effect
     * @param effect The effect to set
     * @return True if everything went successfull, otherwise false
     */
    public boolean setEffect(Cm4jEffect effect) {
        return CM4J_LIBRARY.SwitchLedEffect(effect.getIndex(), device.getIndex());
    }

    /**
     * @return Current keyboard layout
     */
    public Cm4jLayout getLayout() {
        return Cm4jLayout.fromIndex(CM4J_LIBRARY.GetDeviceLayout());
    }

    /**
     * Volume peak value, used by equalizer effect
     * The louder the system audio is, higher the value.
     * @return Volume peak value in 0 to 1 format
     */
    public float getVolumePeekValue() {
        return CM4J_LIBRARY.GetNowVolumePeekValue();
    }

    /**
     * @return Device model
     */
    public Cm4jDevice getDevice() {
        return this.device;
    }

}
