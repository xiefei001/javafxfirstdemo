package de.swm.ela.demo;

import sun.reflect.Reflection;

/**
 * Created by xie on 2016/6/12.
 */
public class Demo {

    public void output(){
        System.out.println(System.getSecurityManager());
        System.out.println("output invoked from: " + Reflection.getCallerClass().getName());
    }
}
