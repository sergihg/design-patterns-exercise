package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.Modem;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoModem;

public class IngenicoModemAdapter implements Modem {
    IngenicoModem modem = new IngenicoModem();
    @Override
    public void open() {
        modem.open();
    }

    @Override
    public void send(Transaction transaction) {
        modem.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return (modem.receive());
    }

    @Override
    public void close() {
        modem.close();
    }
}
