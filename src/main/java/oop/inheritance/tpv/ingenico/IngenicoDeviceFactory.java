package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.*;
import oop.library.ingenico.services.IngenicoPrinter;

public class IngenicoDeviceFactory extends TpvDeviceFactory {
    public static IngenicoDeviceFactory instance = new IngenicoDeviceFactory();

    private Keyboard keyboard = new IngenicoKeyboardAdapter();
    private Display display = new IngenicoDisplayAdapter();
    private CardSwipper cardSwipper = new IngenicoCardSwipperAdapter();
    private ChipReader chipReader = new IngenicoChipReaderAdapter();
    private Printer printer = new IngenicoPrinterAdapter();
    private Ethernet ethernet = new IngenicoEthernetAdapter();
    private Modem modem = new IngenicoModemAdapter();
    private GPS gps = new IngenicoGPSAdapter();

    private IngenicoDeviceFactory(){}
    public static IngenicoDeviceFactory getInstance(){
        return instance;
    }
    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public Display getDisplay() {
        return display;
    }
    @Override
    public CardSwipper getCardSwipper(){
        return cardSwipper;
    }

    @Override
    public ChipReader getChipReader() {
        return chipReader;
    }

    @Override
    public Printer getPrinter() {
        return printer;
    }

    @Override
    public Ethernet getEthernet() {
        return ethernet;
    }

    @Override
    public Modem getModem() {
        return modem;
    }

    @Override
    public GPS getGPS() {
        return gps;
    }
}
