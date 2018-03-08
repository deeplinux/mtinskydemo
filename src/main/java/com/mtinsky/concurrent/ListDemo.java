package com.mtinsky.concurrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Map> tList = new ArrayList<Map>();
        HashMap tMap1 = new HashMap();
        tMap1.put("","");
        tList.add(tMap1);
        HashMap tMap2 = new HashMap();
        tMap2.put("","");
        tList.add(tMap2);
        HashMap tMap3 = new HashMap();
        tMap3.put("","");
        tList.add(tMap3);
        Iterator<Map> iterable = tList.iterator();

        if(iterable.hasNext()) {
            iterable.next();
            iterable.remove();
        }
        {
            Iterator<Map> iterable2 = tList.iterator();
            if(iterable2.hasNext()) {
                iterable2.next();
                iterable2.remove();
            }
        }
        if(iterable.hasNext()) {
            iterable.next();
            iterable.remove();
        }
    }
}
