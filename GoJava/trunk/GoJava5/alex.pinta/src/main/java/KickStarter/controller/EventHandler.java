package KickStarter.controller;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 14.07.15
 * Time: 13:16
 * @version: 1.0
 */
public interface EventHandler {
    public void actionPerformed(List<Integer> userChoice);
    public boolean isHaveToProcessed(List<Integer> userChoice);
    public boolean isHaveToExpand(int verifiableID);
}
