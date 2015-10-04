package com.azuiev;

import org.omg.CORBA.*;

import java.lang.Object;
import java.util.Objects;

/**
 * Created by Lera on 21.09.2015.
 */
public class OurLinkedList {
    OurNode head;
    int size=0;
    OurNode end;

    private class OurNode {
        OurNode next;
        Object obj;
        OurNode(Object obj){
            this.obj=obj;
            next=null;
        }

    }
    void add(Object o){
        if (size==0){
            head=new OurNode(o);
            end = head;
        } else {
            end.next = new OurNode(o);
            end = end.next;
        }

        size++;
    }

    Object get (int index){
        if (size==0||index>size || index <0) {
            return null;
        } else {
            OurNode temp = head;
            for (int i = 0; i <index ; i++) {
                temp = temp.next;
            }
            return temp.obj;
        }
    }
    int size(){
        return size;
    }

}
