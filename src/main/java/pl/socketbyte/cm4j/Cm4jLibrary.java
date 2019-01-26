package pl.socketbyte.cm4j;

import com.sun.jna.Library;

/**
 * Main heart of the whole Cm4j library.
 * Handles the connection between Java and Coolermaster's SDK written in C using JNA.
 */
interface Cm4jLibrary extends Library {

    int GetCM_SDK_DllVer();

    boolean IsDevicePlug();

    boolean EnableLedControl(boolean bEnable, int deviceIndex);

    boolean SetLedColor(int iRow, int iColumn, byte r, byte g, byte b, int deviceIndex);

    boolean SetFullLedColor(byte r, byte g, byte b, int deviceIndex);

    float GetNowVolumePeekValue();

    boolean SwitchLedEffect(int iEffectIndex, int deviceIndex);

    void SetControlDevice(int deviceIndex);

    int GetDeviceLayout();

}
