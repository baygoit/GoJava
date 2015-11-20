/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson3.cachedemo;

import com.gojava6.persistence.lesson2.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/16/15
 */
public class Cache {
    private Map<Class, Map<Object, Object>> cacheMap = new HashMap<>();

    public void put(Class type, Object id, Object value) {
        Map<Object, Object> map = cacheMap.get(type);
        if (map == null) {
            map = new HashMap<>();
            cacheMap.put(type, map);
        }
        map.put(id, value);
    }

    public Object get(Class type, Object id) {
        return cacheMap.get(type).get(id);
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        Book book = new Book();
        book.setId(1L);
        book.setTitle("MyCache");
        cache.put(Book.class, 1L, book);
        System.out.println(cache.get(Book.class, 1L));
    }
}
