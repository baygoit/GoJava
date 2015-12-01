package com.gojava6.differenttasks;

/**
 * @Autor Andrey Chaykin
 * @Since 03.10.2015
 */
public class MainClient {
    int[] array;

    public MainClient(int[] arr) {
        this.array = arr;
    }

    public static void main(String[] args) {
        int[] array2 = {10, 25, 40};
        MainClient mainClient = new MainClient(array2);
        array2[0] = 100;

        System.out.println(mainClient.array[0]);

        mainClient.array[0] = 12345;
        System.out.println(mainClient.array[0]);
        System.out.println(array2[0]);

    }
}
