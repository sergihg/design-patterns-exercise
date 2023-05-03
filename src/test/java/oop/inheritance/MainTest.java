package oop.inheritance;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainTest {
    @Test
    public void when1IsTyped_thenDoSaleIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);

        Mockito.when(application.readKey()).thenReturn("1");

        //When
        Main.run(application);

        //Then
        Mockito.verify(application).clearScreen();
        Mockito.verify(application).showMenu();
        Mockito.verify(application).readKey();
        Mockito.verify(application).doSale();

        Mockito.verifyNoMoreInteractions(application);
    }
    @Test
    public void when2IsTyped_thenDoRefundIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);

        Mockito.when(application.readKey()).thenReturn("2");

        //When
        Main.run(application);

        //Then
        Mockito.verify(application).clearScreen();
        Mockito.verify(application).showMenu();
        Mockito.verify(application).readKey();
        Mockito.verify(application).doRefund();

        Mockito.verifyNoMoreInteractions(application);
    }
    @Test
    public void when3IsTyped_thenPrintReportIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);

        Mockito.when(application.readKey()).thenReturn("3");

        //When
        Main.run(application);

        //Then
        Mockito.verify(application).clearScreen();
        Mockito.verify(application).showMenu();
        Mockito.verify(application).readKey();
        Mockito.verify(application).printReport();

        Mockito.verifyNoMoreInteractions(application);
    }
    @Test
    public void when4IsTyped_thenShowConfigurationIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);

        Mockito.when(application.readKey()).thenReturn("4");

        //When
        Main.run(application);

        //Then
        Mockito.verify(application).clearScreen();
        Mockito.verify(application).showMenu();
        Mockito.verify(application).readKey();
        Mockito.verify(application).showConfiguration();

        Mockito.verifyNoMoreInteractions(application);
    }
}
