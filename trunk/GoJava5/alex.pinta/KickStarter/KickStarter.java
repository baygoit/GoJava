package Lessons1.KickStarter;

import Lessons1.KickStarter.controller.Dispatcher;
import Lessons1.KickStarter.controller.MainPageController;
import Lessons1.KickStarter.dao.ManualInput;

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
        Dispatcher dispatcher = new Dispatcher(deviceIn, deviceOut);
        dispatcher.startApplication(new ManualInput());
        dispatcher.actionPerformed();
    }

}
