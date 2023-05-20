package oop.inheritance.tpv.verifone240;

import oop.inheritance.tpv.*;
import oop.inheritance.tpv.ingenico.*;

public class Verifone240DeviceFactory extends TpvDeviceFactory {
    public static Verifone240DeviceFactory instance = new Verifone240DeviceFactory();

    private Keyboard keyboard = new Verifone240KeyboardAdapter();
    private Display display = new Verifone240DisplayAdapter();

    private Verifone240DeviceFactory(){}
    public static Verifone240DeviceFactory getInstance(){
        return instance;
    }
    @Override
    public Keyboard getKeyboard() {
        return new Verifone240KeyboardAdapter();
    }

    @Override
    public Display getDisplay() {
        return new Verifone240DisplayAdapter();
    }
    @Override
    public CardSwipper getCardSwipper(){
        return null;
    }

    @Override
    public ChipReader getChipReader() {
        return null;
    }

    @Override
    public Printer getPrinter() {
        return null;
    }

    @Override
    public Ethernet getEthernet() {
        return null;
    }

    @Override
    public Modem getModem() {
        return null;
    }

    @Override
    public GPS getGPS() {
        return null;
    }

}
