package mx.irving;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ieReplaySubjectWithTime();
    }

    static void iePublishSubject() {
        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe(System.out::println);
        subject.onNext(2);
        subject.onNext(3);

    }

    static void ieReplaySubject() {
        ReplaySubject<Integer> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(v -> System.out.println("Early: " + v));
        replaySubject.onNext(1);
        replaySubject.onNext(2);
        replaySubject.onNext(3);
        replaySubject.subscribe(v -> System.out.println("Late: " + v));
        replaySubject.onNext(5);
    }

    static void ieReplaySubjectWithSize() {
        ReplaySubject<Integer> replaySubject = ReplaySubject.createWithSize(2);
        replaySubject.onNext(0);
        replaySubject.onNext(1);
        replaySubject.onNext(2);
        replaySubject.subscribe(v -> System.out.println("Late: " + v));
        replaySubject.onNext(3);
    }

    static void ieReplaySubjectWithTime() {
        try {
            // TODO: review this
            ReplaySubject<Integer> replaySubject = ReplaySubject
                    .createWithTime(150, TimeUnit.MILLISECONDS, Schedulers.trampoline());
            replaySubject.onNext(0);
            Thread.sleep(100);
            replaySubject.onNext(1);
            Thread.sleep(100);
            replaySubject.onNext(2);
            replaySubject.subscribe(v -> System.out.println("Late: " + v));
            replaySubject.onNext(3);
            replaySubject.onNext(4);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
