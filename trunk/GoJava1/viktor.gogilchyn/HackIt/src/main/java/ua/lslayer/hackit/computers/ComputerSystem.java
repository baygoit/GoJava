package ua.lslayer.hackit.computers;

import java.util.ArrayList;
import java.util.List;

import ua.lslayer.hackit.Software;
import ua.lslayer.hackit.computers.hardware.Cpu;
import ua.lslayer.hackit.computers.hardware.Ram;
import ua.lslayer.hackit.computers.hardware.Storage;

public class ComputerSystem { 
    public ComputerSystem() {
		super();
	}

	private String name;
    private Cpu cpu; 
    private Ram ram;
    private List<Storage> storage;
    private ArrayList<Software> installedSoftware;
    private boolean operative;  //Is there any constructions/patterns, 
                                //which will disallow to run some methods, 
                                //when operative filed is false? 
                                //Or I should check it every time?

    private int storageSizeAvailable; //Should I make an distinct field or compute it every time?  
    
    private boolean matchesRequirements(Software soft) {
    	return true;
    }
    
    private int getTotalStorage() {
    	int returnValue = 0;
    	for (Storage element : storage) {
    		returnValue += element.getStorageSize();
    	}
    	return returnValue;
    }
    
    public ComputerSystem(int cpuPower, int ramSize, int storageSize) {
		super();
		this.cpu = new Cpu(0, this.name, cpuPower);
		this.ram = new Ram(0, name, ramSize);
		this.storage = new ArrayList<Storage>();
		this.storage.add(new Storage(0, name, storageSize));
		
	}

	private void checkDiskForErrors () {
        int installedSoftwareSize = 0;
        for (Software soft : installedSoftware) {
            installedSoftwareSize += soft.getSize();
        }
        if (storageSizeAvailable == (this.getTotalStorage() - installedSoftwareSize))
            this.operative = false;
    }
    
    public void installSoftware(Software soft) {
        if (this.operative && soft.getSize() < this.storageSizeAvailable) {
            this.installedSoftware.add(soft);
            this.storageSizeAvailable -= soft.getSize();
        } else {
            //Hereafter we will throw an exception 
        }
    }
    
    public void runSoftware(Software soft) {
        if (this.operative) {
            if (!installedSoftware.contains(soft)) {
                //Ask to install software or install without confirmations?
                //this is a question
                installSoftware(soft);
            }
            soft.runSoftware(this);

        } else {
            //Repair your computer first!
        }
    }
}
