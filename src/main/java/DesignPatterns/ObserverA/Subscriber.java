package DesignPatterns.ObserverA;

import java.util.HashMap;
import java.util.Map;

public class Subscriber<T> {
    private Listener<T> listener;
    private Map<T, String> observerMap = new HashMap<>();

    public interface Listener<T>{
        void add(T subject, String desc);
    }

    public void setListener(Listener<T> listener){
        this.listener = listener;
    }

}
