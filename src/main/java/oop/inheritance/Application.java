package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.tpv.*;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private TpvDeviceFactory tpvDeviceFactory;

    public Application(TpvDeviceFactory tpvDeviceFactory) {
        this.tpvDeviceFactory = tpvDeviceFactory;
    }
    public void showMenu() {
        Display display = tpvDeviceFactory.getDisplay();

        display.print(5, 5, "MENU");
        display.print(5, 10, "1. VENTA");
        display.print(5, 13, "2. DEVOLUCION");
        display.print(5, 16, "3. REPORTE");
        display.print(5, 23, "4. CONFIGURACION");
    }
    public String readKey() {
        Keyboard keyboard = tpvDeviceFactory.getKeyboard();

        return keyboard.getChar();
    }
    public void doSale() {
        CardSwipper cardSwipper = tpvDeviceFactory.getCardSwipper();
        ChipReader chipReader = tpvDeviceFactory.getChipReader();
        Display display = tpvDeviceFactory.getDisplay();
        Keyboard keyboard = tpvDeviceFactory.getKeyboard();
        Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.print(5, 20, "Capture monto:");

        String amount = keyboard.getChar(); //Amount with decimal point as string

        Transaction transaction = new Transaction();

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            display.print(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            display.print(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        Printer printer = tpvDeviceFactory.getPrinter();
        Card card = transaction.getCard();

        printer.print(5, "APROBADA");
        printer.lineFeed();
        printer.print(5, card.getAccount());
        printer.lineFeed();
        printer.print(5, "" + transaction.getAmountInCents());
        printer.lineFeed();
        printer.print(5, "________________");
    }
    private TransactionResponse sendSale(Transaction transaction) {
        Ethernet ethernet = tpvDeviceFactory.getEthernet();
        Modem modem = tpvDeviceFactory.getModem();
        GPS gps = tpvDeviceFactory.getGPS();
        TransactionResponse transactionResponse = null;

        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        Display display = tpvDeviceFactory.getDisplay();
        display.clear();
    }
}
