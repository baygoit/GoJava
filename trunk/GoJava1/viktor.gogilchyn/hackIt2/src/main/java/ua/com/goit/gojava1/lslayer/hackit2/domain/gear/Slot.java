package ua.com.goit.gojava1.lslayer.hackit2.domain.gear;

import java.io.Serializable;

public class Slot implements Serializable {
    private static final long serialVersionUID = -4712771534009282499L;

    private String name;
    private int version = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
