package com.gojava6.springioc.reflection;

import java.lang.reflect.Method;

/**
 * Created by Jeka on 19/10/2014.
 */
public class ObjectFactory {
    public static  <T> T createObject(Class<T> type) throws Exception {
        T t = type.newInstance();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                for (int i=0;i<annotation.repeat();i++) {
                    method.invoke(t);
                }
            }
        }
        return t;
    }
}
