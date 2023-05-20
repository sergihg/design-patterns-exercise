package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.Ethernet;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoEthernet;

public class IngenicoEthernetAdapter implements Ethernet {
    IngenicoEthernet ethernet = new IngenicoEthernet();
    @Override
    public void open() {
        ethernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        ethernet.send(transaction);

    }

    @Override
    public TransactionResponse receive() {
        return ethernet.receive();
    }

    @Override
    public void close() {
        ethernet.close();
    }
}
