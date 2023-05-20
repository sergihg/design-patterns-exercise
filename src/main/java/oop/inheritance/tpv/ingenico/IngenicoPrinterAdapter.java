package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.Printer;
import oop.library.ingenico.services.IngenicoPrinter;

public class IngenicoPrinterAdapter implements Printer {
    IngenicoPrinter printer = new IngenicoPrinter();

    @Override
    public void print(int x, String message) {
        printer.print(x,message);
    }

    @Override
    public void lineFeed() {
        printer.lineFeed();
    }
}
