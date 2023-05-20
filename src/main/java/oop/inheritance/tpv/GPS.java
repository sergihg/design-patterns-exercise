package oop.inheritance.tpv;

import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

public interface GPS {
    void open();
    void send(Transaction transaction);
    TransactionResponse receive();
    void close();
}
