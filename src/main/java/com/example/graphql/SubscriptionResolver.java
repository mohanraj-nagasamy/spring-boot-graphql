package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.model.http.Score;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import org.apache.commons.lang3.RandomUtils;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SubscriptionResolver implements GraphQLSubscriptionResolver {
    public Publisher<Score> scores(String title) {

        Observable<Score> observable = Observable.interval(1, 1, TimeUnit.SECONDS).map(aLong -> {
            int score = RandomUtils.nextInt(1, 100);
            return Score.builder()
                    .score(score)
                    .title(title + " => " + score)
                    .build();
        });

        ConnectableObservable<Score> connectableObservable = observable.share().publish();
        connectableObservable.connect();

        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }
}
