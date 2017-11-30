package DesignPatterns.ObserverA;

public class Observer {
    private Subscriber<Subject> subscriber;

    public Observer(){
        subscriber = new Subscriber<>();
        subscriber.setListener(new Subscriber.Listener<Subject>(){
            @Override
            public void add(Subject subject, String desc) {
                subject.setName("Subject name");
                System.out.println(subject.getName());
            }
        });
    }

    public void printObserver(){

    }


    private class Subject{
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
