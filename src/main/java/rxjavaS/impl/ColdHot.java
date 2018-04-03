package rxjavaS.impl;

import io.reactivex.Observable;

public class ColdHot {
    public static void main(String[] args) {
        cold();
    }

    public static void cold(){
        Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");

        // observer 1
        source.map(s -> s.length()).subscribe(System.out::println);

        // observer 2
        source.map(s -> s.charAt(0)).subscribe(System.out::println);
    }

    public static void hot(){
        /*
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //source = Observable.create(new Observable.OnSubscribe)
            myObservable = Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                    emitter.onNext(tv.getText().toString());
                    emitter.onComplete();
                }
            });

            myObserver = new ObservableMethods() {
                @Override
                public void onSubscribe(DisposeEx d) {

                }

                @Override
                public void onNext(Object o) {
                    tv.setText("toggle is on");
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {
                    tv.setText("toggle is off");
                }
            };
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View v =  inflater.inflate(R.layout.fragment_select, container, false);
            tbv = v.findViewById(R.id.select_option);
            tv = v.findViewById(R.id.toggle_display_text);

            tbv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tbv.isChecked()){
                        myObservable.subscribe(myObserver);
                    }
                }
            });
            return v;
        }
        */
    }

}
