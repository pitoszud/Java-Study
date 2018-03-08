package rxjavaS.impl;
import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ObservableMethods {
    public static void main(String[] args) {
        //rangeCount();
        intervalCount();
    }

    public static void rangeCount(){
        List<Integer> nums = new ArrayList<>();
        Observable.range(5,10).subscribe(n -> nums.add(n));
        Collections.sort(nums);
        System.out.println(nums);
    }

    public static void intervalCount() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " ra ta ta ta ta ta ta..."));
        sleep(5000);
    }

    public static void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
