package Observation;
import In.In;
import MeasureTheRunningTime.Stopwatch;

import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        int[] a = In.readInts("/home/hf/Learning/github/" +
                "DataStructureAndAlgorithms/" +
                "AmalysisOfAlgorithms/Data/test.txt");


        Stopwatch stopwatch = new Stopwatch();
        System.out.println(Three_brute_force.count(a));
        double time = stopwatch.elapsedTime();
        System.out.println("暴力计算的时间："+time);

        Arrays.sort(a);
        Stopwatch stopwatch2 = new Stopwatch();
        System.out.println(Three_NNLogN.count(a));
        double time2 = stopwatch2.elapsedTime();
        System.out.println("二叉树搜索改进后的时间："+time2);

    }
}
