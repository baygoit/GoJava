package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import java.util.List;

public interface Component {

    public int getThroughput();

    public void setThroughput(int throughput);

    public List<Slot> getSlots();

    public void setSlots(List<Slot> slots);

    public void setPlaceholder(Slot placeholder);

    public Slot getPlaceholder();

}
