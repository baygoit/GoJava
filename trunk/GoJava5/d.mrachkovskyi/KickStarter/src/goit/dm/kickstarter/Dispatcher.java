package goit.dm.kickstarter;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dispatcher implements InputListener {

    private int[] path = {0,0};

    @Override
    public void onInput(String input) {
        int intInput = Integer.parseInt(input);
        boolean wasUpdated = updatePath(intInput);



    }

    private boolean updatePath(int intInput) {
        if (intInput != 0) {
            for (int i = 0; i < path.length; i++) {
                if (path[i] == 0) {
                    path[i] = intInput;
                    return true;
                }
            }
        } else {
            for (int i = path.length - 1; i <= 0; i--) {
                if (path[i] != 0) {
                    path[i] = intInput;
                    return true;
                }
            }
        }
        return false;
    }
}
