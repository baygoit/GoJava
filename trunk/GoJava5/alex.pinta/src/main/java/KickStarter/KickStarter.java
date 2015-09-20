package KickStarter;

import KickStarter.controller.Dispatcher;
import KickStarter.dao.LoadingStrategy;
import KickStarter.dao.ManualInput;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 11.07.15
 * Time: 6:34
 * @version: 1.0
 */
public class KickStarter {
    private Input deviceIn;
    private Output deviceOut;
    public KickStarter(InputStream pInputStream, OutputStream pOutputStream) {
        deviceIn = new Input(pInputStream);
        deviceOut = new Output(pOutputStream);
    }

    public void run(){
        LoadingStrategy loadingStrategy = new LoadingStrategy();
        Dispatcher dispatcher = new Dispatcher(deviceIn, deviceOut);
        dispatcher.startApplication(loadingStrategy.getDaoComponent("kickstarter.ini"));
        dispatcher.actionPerformed();
    }

}
