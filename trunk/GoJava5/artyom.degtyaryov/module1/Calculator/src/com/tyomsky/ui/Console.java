package com.tyomsky.ui;

import java.util.Scanner;

/**
 * Created by tyoms_000 on 30.06.2015.
 */
public class Console {

    public String read(){
        Scanner scanner = new Scanner(System.in);
        String result;
//        if (scanner.hasNext()){
        	result = scanner.nextLine();
//        }else{
//        	result = "";
//        }
        scanner.close();
        return result;
    }

    public void write(String message){
        System.out.println(message);
    }


}
