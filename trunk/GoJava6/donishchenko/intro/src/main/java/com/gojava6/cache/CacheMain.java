package com.gojava6.cache;

public class CacheMain {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache(2000, 5);

        Data testData = new Data(1, "TestData");

        cache.put(/*testData.getClass(),*/ testData, 1);

        Data getData = cache.get(Data.class, 1);
        System.out.println(getData);

        Thread.sleep(1500);

        getData = cache.get(Data.class, 1);
        System.out.println(getData);

        Thread.sleep(1000);

        getData = cache.get(Data.class, 1);
        System.out.println(getData);
    }
}
