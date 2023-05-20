package oop.inheritance.tpv.verifone240;

import oop.inheritance.tpv.Display;
import oop.library.v240m.VerifoneV240mDisplay;

public class Verifone240DisplayAdapter implements Display {
    private VerifoneV240mDisplay display = new VerifoneV240mDisplay();
    @Override
    public void print(int x, int y, String message){
        display.print(x,y,message);
    }
    @Override
    public void clear(){
        display.clear();
    }
}
