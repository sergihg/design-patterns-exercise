package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.ChipReader;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.services.IngenicoChipReader;

public class IngenicoChipReaderAdapter implements ChipReader {
    IngenicoChipReader chipReader = new IngenicoChipReader();

    @Override
    public Card readCard() {
        return chipReader.readCard();
    }
}
