/**
 * Created by Ыўср on 23.09.2015.
 */
public class Aplication  {
    public static void main( String[] args )
    {
        LoayaltyProgram loayaltyProgram = new LoayaltyProgram();

        Observer client1 = new Client("Yan", "Serfo", "erf@gg.com");
        Observer client2 = new Client("Tim", "Tornvald", "tim@bbol.com");

        loayaltyProgram.register(client1);
        loayaltyProgram.register(client2);

        loayaltyProgram.notifyAllObservers();
    }
}
