package netflix.ocelli.client;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subjects.PublishSubject;

public class TestClientConnector implements OnSubscribe<TestClient> {

    private final PublishSubject<TestClient> stream = PublishSubject.create();
    private final TestClient client;
    
    public TestClientConnector(TestClient client) {
        this.client = client;
    }
    
    @Override
    public void call(Subscriber<? super TestClient> s) {
        s.onNext(client);
        s.onCompleted();
        stream.onNext(client);
    }

    public Observable<TestClient> stream() {
        return stream;
    }

}
