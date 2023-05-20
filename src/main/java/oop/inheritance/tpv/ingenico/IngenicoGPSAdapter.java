package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.GPS;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoGPS;

public class IngenicoGPSAdapter implements GPS {
    IngenicoGPS gps = new IngenicoGPS();
    @Override
    public void open() {
        gps.open();
    }

    @Override
    public void send(Transaction transaction) {
        gps.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return gps.receive();
    }

    @Override
    public void close() {
        gps.close();
    }
}
