package ua.com.goit.gojava.plotnikov.heapsort;
import java.util.Random;

public class HeapSort 
{
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;
    
	public static int operations =0;

    public static void main(String[] args) {
    	int size=10;
    	int[] array = new int[size];
    	
    	fill(array, size);
    	
    	show(array, size);
    	
        sort(array);

        show(array, size);
		System.out.print("\noperations: " + operations);
    }
    
    public static void buildheap(int []array){
        n=array.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(array,i);
        }
    }
    
    public static void maxheap(int[] array, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && array[left] > array[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && array[right] > array[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(i,largest);
            maxheap(array, largest);
        }
    }
    
    public static void swap(int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp; 
        operations++;
        }
    
    public static void sort(int []array){
        a=array;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            swap(0, i);
            n-=1;
            maxheap(a, 0);
        }
    }
    
	public static void fill(int[] array, int size){
		for(int i = 0; i<size; i++){
			Random ran = new Random();
			int x = ran.nextInt(size*10);
			array[i] = x;
		}
	}
	
	public static void show(int[] array, int size){
		for(int i = 0; i<size; i++){
			System.out.print(array[i] +" ");
		}
		System.out.println("");
	}
}