package LambdaStreams.Patterns;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Points {
    public interface Consumer<T> extends java.util.function.Consumer<T>{
        void accept(T t);
    }

    private class Client{
        List<Point> pointList = new ArrayList<>();

        public void addPoints(){
            pointList.add(new Point(1,2));
            pointList.add(new Point(2,1));
            pointList.add(new Point(1,1));
            pointList.add(new Point(2,2));

            pointList.forEach(new Consumer<Point>() {
                @Override
                public void accept(Point point) {
                    point.translate(1,1);
                }
            });
        }
    }
}