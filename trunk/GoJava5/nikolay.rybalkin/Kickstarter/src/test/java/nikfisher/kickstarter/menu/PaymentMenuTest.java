package nikfisher.kickstarter.menu;

import nikfisher.kickstarter.Runner;
import nikfisher.kickstarter.model.QuoteGenerate;
import nikfisher.kickstarter.streams.ConsoleInterfaceIO;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class PaymentMenuTest {


    @Test
    public void shouldMenuAddPayment() {
        //given
        ConsoleInterfaceIO io = mock(ConsoleInterfaceIO.class);
        QuoteGenerate generator = mock(QuoteGenerate.class);

        Runner runner = new Runner(io, generator);

        //when

        //1 - выбор категории 1
        //1 - выбор проекта 1
        //1 - инвестировать в проект
        //1 - выбор варианта инвестиции
        //11 - ввод имени (из-за консольного ввода, чтобы упростить тестирование воодимени делаю цифрами)
        //99999999 - ввод номера карты
        //200 - инвестирование средств
        //0 - выход из проекта
        //0 - выход из ватегорий
        //0 - выход из проекта

        when(io.consoleScanInt()).thenReturn(1, 1, 1, 1, 11, 99999999, 200, 0, 0);

        runner.run();

        //then
        verify(io, times(1)).println("Please select payment option:");
        verify(io, times(1)).println("1) If you invest 10% of the required amount, you will receive a 5%.");
        verify(io, times(1)).println("2) If you invest 50% of the required amount, you will receive a 15%.");
        verify(io, times(1)).println("3) If you invest 100% of the required amount, you will receive a 30%.");
        verify(io, times(1)).println("You need to make: 1000");
        verify(io, times(1)).println("-----------------");
        verify(io, times(1)).println("Enter your name");
        verify(io, times(1)).println("Enter the number of your card");
        verify(io, times(1)).println("Enter the amount of money");
//        verify(io, times(1)).println("Thank you 11 your money is successfully transferred to the account of the project");
        verify(io, times(4)).println("---------------------------------------");
    }
}