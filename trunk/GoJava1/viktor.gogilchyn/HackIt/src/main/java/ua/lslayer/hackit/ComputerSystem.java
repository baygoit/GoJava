package ua.lslayer.hackit;

import java.util.ArrayList;

public class ComputerSystem { 
    private String name;
    private int cpuPower; //Hereafter there will be a class, which describes CPU
    private int ramSize;
    private int storageSize;
    private ArrayList<Software> installedSoftware;
    private boolean operative;  //Is there any constructions/patterns, 
                                //which will disallow to run some methods, 
                                //when operative filed is false? 
                                //Or I should check it every time?

    private int storageSizeAvailable; //Should I make an distinct field or compute it every time?  
    
    private void checkDiskForErrors () {
        int installedSoftwareSize = 0;
        for (Software soft : installedSoftware) {
            installedSoftwareSize += soft.getSize();
        }
        if (storageSizeAvailable == (this.storageSize - installedSoftwareSize))
            this.operative = false;
    }
    
    public void installSoftware(Software soft) {
        if (this.operative && soft.getSize() < this. storageSizeAvailable) {
            this.installedSoftware.add(soft);
            this.storageSizeAvailable -= soft.getSize();
        } else {
            //Hereafter we will throw an exception 
        }
    }
    
    public void runSoftware(Software soft) {
        if (this.operative) {
            if (installedSoftware.contains(soft)) {
                soft.runSoftware();
            } else {
                //Ask to install software or install without confirmations?
                //this is a question
                installSoftware(soft);
                runSoftware(soft);
            }
        } else {
            //Repair your computer first!
        }
    }
}
