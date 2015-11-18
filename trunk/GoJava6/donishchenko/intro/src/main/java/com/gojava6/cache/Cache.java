package com.gojava6.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cache {
    private Map<Class, Map<Object, Pair>> cache = new HashMap<>();
    private long aliveTimeMs;
    private int maxSize;

    public Cache(long aliveTimeMs, int maxSize) {
        this.aliveTimeMs = aliveTimeMs;
        this.maxSize = maxSize;
    }

    public void put(Object object, Object id) {
        checkCache();
        // find map by class
        Class clazz = object.getClass();
        Map<Object, Pair> map = cache.get(clazz);
        if (map == null) {
            map = new HashMap<>();
            cache.put(clazz, map);
        }

        long deleteTime = System.currentTimeMillis() + aliveTimeMs;
        Pair pair = new Pair(deleteTime, object);

        map.put(id, pair);
    }

    public <T> T get(Class clazz, Object id) {
        checkCache();

        Object object = null;
        Map<Object, Pair> map = cache.get(clazz);
        if (map != null) {
            Pair pair = map.get(id);
            if (pair != null) {
                object = pair.data;
            }
        }

        return (T) object;
    }

    public int size() {
        int size = 0;

        for (Map map : cache.values()) {
            size += map.size();
        }

        return size;
    }

    private void checkCache() {
//        if (size() > maxSize) {
            for (Map<Object, Pair> map : cache.values()) {
                Iterator<Pair> it = map.values().iterator();
                while (it.hasNext()) {
                    Pair pair = it.next();

                    if (pair.deleteTime <= System.currentTimeMillis()) {
                        it.remove();
                    }
                }
            }
//        }
    }

    private class Pair {
        public long deleteTime;
        public Object data;

        public Pair(long deleteTime, Object data) {
            this.deleteTime = deleteTime;
            this.data = data;
        }
    }
}
