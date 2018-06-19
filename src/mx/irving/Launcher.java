package mx.irving;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Launcher {

    public static void main(String[] args) {
        Observable<String> myStrings = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        myStrings.subscribe(System.out::println);

        Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);
        secondIntervals.subscribe(System.out::println);
        sleep(6000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
