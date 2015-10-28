package goit.dm.kickstarter;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Input {

    private InputListener inputListener;

    public void listenInput() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            inputListener.onInput(scanner.next());
        }
    }
}
