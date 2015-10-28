package com.gojava6.differenttasks;

import java.util.Collections;

/**
 * @Autor Andrey Chaykin
 * @Since 21.09.2015
 */
public class RegEx {


        public static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. " +
                "тайланд - мечты сбываются!";

        public static void main(String[] args){

            System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд", "Украина"));


    }
}

