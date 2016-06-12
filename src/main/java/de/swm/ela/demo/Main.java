package de.swm.ela.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by xie on 2016/6/12.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Demo demo = (Demo) Class.forName("de.swm.ela.demo.Demo").newInstance();
        demo.output();

    }
}
