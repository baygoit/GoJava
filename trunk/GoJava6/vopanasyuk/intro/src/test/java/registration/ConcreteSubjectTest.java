package registration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;

/**
 * Created by oktopus on 21.09.15.
 */
public class ConcreteSubjectTest {

    @Test
    public void testNotifyAll() {
        //given
        Subject subject = new Validation();

        Observer client = mock(Observer.class);
        subject.register(client);

        Observer host = mock(Observer.class);
        subject.register(host);

        //when
        subject.notifyObservers();

        //then
        verify(client).update("Registered");
        verify(host).update("Registered");
    }



    @Test
    public void testNotifyOnlySubscribes() {
        //given
        Subject subject = new Validation();

        Observer client = mock(Observer.class);
        subject.register(client);

        Observer host = mock(Observer.class);
        subject.register(host);

        //when
        subject.remove(client);
        subject.notifyObservers();

        //then
        verifyNoMoreInteractions(client);
        verify(host).update("Registered");
    }
}
