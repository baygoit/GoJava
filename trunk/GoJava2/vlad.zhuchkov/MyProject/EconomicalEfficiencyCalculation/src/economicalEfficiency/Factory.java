package economicalEfficiency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Factory {
	String name;
	UnitDatabase factoryUnitDatabase = new UnitDatabase();
		
	Scanner sc = new Scanner(System.in);
	Factory(){
		System.out.println("name of factory");
		name = sc.nextLine();
		factoryUnitDatabase.add();	
	}
	public void addUnit(){
		factoryUnitDatabase.add();	
	}
	public void cangeNumberOfUnit(String turget){
		Unit tempU = factoryUnitDatabase.unit.get(turget);
		System.out.println("set number of unit");
		tempU.quantity = Integer.valueOf(sc.nextLine());
				
	}
	public void cangeCostOfProduct(String turget) {
		Unit tempU = factoryUnitDatabase.unit.get(turget);
		System.out.println("set new price");
		tempU.product.price = Integer.valueOf(sc.nextLine());
	}
	public void cangeWorkersPay() {
		System.out.println("set new worker's pay");
		for (ProductionUnit value : factoryUnitDatabase.unit.values()) {
		    value.worker.pay=Integer.valueOf(sc.nextLine());
		}
	}
	public void removeUnit(String name){
		factoryUnitDatabase.remove(name);	
		
	}
	public void getStatistics() {
		// TODO Auto-generated method stub
		
	}
	

}
