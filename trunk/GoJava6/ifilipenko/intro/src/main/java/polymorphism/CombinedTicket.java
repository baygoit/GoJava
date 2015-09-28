package polymorphism;

import java.util.HashSet;
import java.util.Set;

public class CombinedTicket extends StandardTicket{

    Set<Ticket> options = new HashSet<Ticket>();

    @Override
    public int price() {
        return 10;
    }




}
