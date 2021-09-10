import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class Test {

    private Disposable mDisposable;

    public static void main(String[] args) {

        /*创建被观察者*/
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);//要发送的事件
                e.onComplete();
            }
        });

        /*创建观察者*/
        Observer<Integer> observer = new Observer<Integer>() {
            private Disposable mDisposable;
            @Override
            public void onSubscribe(Disposable d) {
                //Log.d(TAG, "开始采用subscribe连接");
                System.out.println("开始采用subscribe连接");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                //Log.d(TAG, "对Next事件" + value + "作出相应");
                System.out.println("对Next事件" + value + "作出相应");
                if(value == 2){
                    mDisposable.dispose();
                    //Log.d(TAG,"已经断开连接:"+mDisposable.isDisposed());
                    System.out.println("已经断开连接:"+mDisposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                //Log.d(TAG, "对Error事件作出响应");
                System.out.println("对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                //Log.d(TAG, "对Complete事件作出响应");
                System.out.println("对Complete事件作出响应");
            }
        };

        /*将被观察者和观察者通过订阅关系绑定*/
        observable.subscribe(observer);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
