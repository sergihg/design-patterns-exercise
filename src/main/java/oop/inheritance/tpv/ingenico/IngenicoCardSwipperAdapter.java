package oop.inheritance.tpv.ingenico;

import oop.inheritance.tpv.CardSwipper;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.services.IngenicoCardSwipper;

public class IngenicoCardSwipperAdapter implements CardSwipper {
    private IngenicoCardSwipper cardSwipper = new IngenicoCardSwipper();
    @Override
    public Card readCard() {
        return cardSwipper.readCard();
    }
}
