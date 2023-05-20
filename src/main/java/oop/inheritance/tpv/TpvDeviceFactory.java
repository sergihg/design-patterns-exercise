package oop.inheritance.tpv;

import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.tpv.ingenico.IngenicoDeviceFactory;
import oop.inheritance.tpv.verifone240.Verifone240DeviceFactory;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoCardSwipper;

public abstract class TpvDeviceFactory {
    public abstract Keyboard getKeyboard();
    public abstract Display getDisplay();
    public abstract CardSwipper getCardSwipper();
    public abstract ChipReader getChipReader();
    public abstract Printer getPrinter();
    public abstract Ethernet getEthernet();
    public abstract Modem getModem();
    public abstract GPS getGPS();
    public static TpvDeviceFactory getFactory(SupportedTerminal supportedTerminal){
        return switch (supportedTerminal){
            case INGENICO -> IngenicoDeviceFactory.getInstance();
            case VERIFONE -> Verifone240DeviceFactory.getInstance();
        };
    }
}
