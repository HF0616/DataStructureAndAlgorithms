package MeasureTheRunningTime;

public class Stopwatch {
    private long startTime;

    public void start(){
        startTime = System.nanoTime();
    }

    public double elapsedTime(){
        long endTime = System.nanoTime();
        long elaspedTime = endTime - startTime;

        //将纳秒转换为秒
        return (double) elaspedTime/1000000000.0;
    }
}
