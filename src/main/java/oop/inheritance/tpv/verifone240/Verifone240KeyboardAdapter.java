package oop.inheritance.tpv.verifone240;

import oop.inheritance.tpv.Keyboard;
import oop.library.v240m.VerifoneV240mKeyboard;

public class Verifone240KeyboardAdapter implements Keyboard {
    private VerifoneV240mKeyboard keyboard = new VerifoneV240mKeyboard();
    @Override
    public String getChar() {
        return keyboard.get();
    }
}
