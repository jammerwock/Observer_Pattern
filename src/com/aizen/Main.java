package com.aizen;// http://www.javenue.info/post/76

import java.util.ArrayList;

interface IObserver {
    void created(Object obj);

    void modified(Object obj);
}

class DefaultObserver implements IObserver {

    @Override
    public void created(Object obj) {
        System.out.println("com.aizen.DefaultObserver::created() for " + obj);
    }

    @Override
    public void modified(Object obj) {
        System.out.println("com.aizen.DefaultObserver::modified() for " + obj);
    }
}

class MyObserver implements IObserver {

    @Override
    public void created(Object obj) {
        System.out.println("com.aizen.MyObserver::created() for " + obj);
    }

    @Override
    public void modified(Object obj) {
        System.out.println("com.aizen.MyObserver::modified() for " + obj);
    }
}


class Observers<T extends IObserver> extends ArrayList<T> {
    public void notifyCreated(Object obj) {
        for (T obs : Observers.this) {
            obs.created(obj);
        }
    }

    public void notifyModified(Object obj) {
        for (T obs : Observers.this) {
            obs.modified(obj);
        }
    }
}

public class Main {
    Observers obs = new Observers();

    @Override
    public String toString() {
        return "com.aizen.Main";
    }


    Main() {
        obs.add(new DefaultObserver());
        obs.add(new MyObserver());
        obs.notifyCreated(this);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.t();
    }

    void t() {
        obs.notifyModified(this);
    }


}

