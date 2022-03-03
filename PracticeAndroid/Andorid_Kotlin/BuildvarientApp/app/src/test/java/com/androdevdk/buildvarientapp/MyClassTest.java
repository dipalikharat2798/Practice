package com.androdevdk.buildvarientapp;

import junit.framework.TestCase;

public class MyClassTest extends TestCase {
MyClass myClass;
    public void testCompare() {
        myClass=new MyClass();
        int a =10;
        int b=20;

        boolean f = myClass.compare(a,b);
        boolean expval=false;
        assertFalse(f);
    }

    public void testSum() {
        myClass=new MyClass();
        int a =10;
        int b=20;

        int f = myClass.sum(a,b);
        int expval=30;
        assertEquals(expval,f);
    }

    public void testGetString() {
        myClass=new MyClass();
        String strResult = myClass.getString();
        String strExp="Hello World";
        assertEquals(strExp,strResult);
    }
}