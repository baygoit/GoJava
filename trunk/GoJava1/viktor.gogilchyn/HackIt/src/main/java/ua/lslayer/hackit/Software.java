package ua.lslayer.hackit;

public class Software {
    private static final float SIZE_INCREASE_RATIO = 0.3f;
    private String name;
    private int version;
    private int sizeOnDisk;
    
    public Software(String name) {
        this.name = name;
        this.version = 0; //Just an idea of software. 
    }

    public int getSize() {
        return this.sizeOnDisk * (int) (SIZE_INCREASE_RATIO * this.version);
    }

    @Override
    public String toString() {
        return this.name + " v. " + this.version;
    }

    public void runSoftware() {
        //Here we go!
    }
    
    
}
