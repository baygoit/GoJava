package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;

public class AbstractComponent extends AbstractHardware implements Component {

    private int throughput = 1;
    private List<Slot> slots = new ArrayList<Slot>();
    private List<Component> installedComponents = new ArrayList<Component>();
    private Slot placeholder = new Slot();

    public AbstractComponent() throws HackitWrongParameterException {
        super();
    }

    public void assemble(Component component) {
        if (this.getSlots().contains(component.getPlaceholder())) {
        }
    }

    public List<Component> getInstalledComponents() {
        return this.installedComponents;
    }

    @Override
    public Slot getPlaceholder() {
        return this.placeholder;
    }

    @Override
    public List<Slot> getSlots() {
        return this.slots;
    }

    @Override
    public int getThroughput() {
        // TODO Auto-generated method stub
        return this.throughput;
    }

    public void setInstalledComponents(List<Component> installedComponents) {
        this.installedComponents = installedComponents;
    }

    @Override
    public void setPlaceholder(Slot placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public void setThroughput(int throughput) {
        this.throughput = throughput;

    }

}
