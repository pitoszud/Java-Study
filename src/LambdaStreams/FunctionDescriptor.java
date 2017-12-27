package LambdaStreams;

public class FunctionDescriptor {

    // Function Descriptot describes the signature of the abstract method of a Functional Interface


    // Function Descriptor (input -> output): (String) -> void
    public interface FirstInterface {
        public void singleMethod(String param);
    }


    // Function Descriptor (input -> output):  (int,int) -> long
    public interface SecondInterface {
        public long computeSum(int num1, int num2);
    }


    // Function Descriptor (input -> output):  T -> R
    public interface Function<T, R> {
        R apply(T t);
    }


    // Function Descriptor (input -> output):  () -> T
    public interface Supplier<T> {
        T get();
    }

}
