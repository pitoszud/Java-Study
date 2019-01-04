package plimorphismProblems;


public class Main {

    public static void main(String[] args) {

        ClassA cl1 = new ClassB(); // instance of ClassB

        cl1.fly(); // ClassA

        ClassB cl3 = new ClassB(); // instance of ClassB
        cl3.fly(); // ClassB

        ClassA cl2 = new ClassA();  // instance of ClassA
        cl2.fly(); // ClassA

        ABController abc = new ABController();
        abc.checkFly(new ClassA());
        abc.checkFly(new ClassB());

        // -----------------------

        ClassA ca = new ClassA();
        ca.assignCores(32);

        ClassB cb = new ClassB();
        cb.hideOverride(16);
    }



}
