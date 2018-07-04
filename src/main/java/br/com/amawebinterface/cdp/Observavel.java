package br.com.amawebinterface.cdp;

import java.util.ArrayList;
import java.util.Observable;

public class Observavel {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void add(Observer ob){
        observers.add(ob);
    }

    public void del(Observer ob){
        observers.remove(ob);
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this);
        }
    }

}
