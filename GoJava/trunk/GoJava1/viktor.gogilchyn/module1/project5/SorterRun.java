package ua.com.goit.gojava.lslayer.module1.project5;

public class SorterRun {
    public static void main(String[] args) {
        int size = 0;
        while (true) {
            Sorter sorter = new Sorter(size);
            size += 1000000;
            long bubbleTimer = System.nanoTime(); 
            int bubbleIterationCount = sorter.bubleSortCounter(sorter.dataArray);
            bubbleTimer = System.nanoTime() - bubbleTimer; 
//            long quickTimer = System.nanoTime(); 
//            int quickSortIterationCount = sorter.quickSortcounter(sorter.dataArray);
//            quickTimer = System.nanoTime() - quickTimer; 
//            System.out.println(size+";" + quickSortIterationCount+ ";" + quickTimer);
            if (bubbleTimer > 1000000000) break; 
        }
    }
}
