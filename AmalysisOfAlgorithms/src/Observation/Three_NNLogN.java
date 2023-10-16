package Observation;

import java.util.Arrays;

public class Three_NNLogN {
    public static int count(int[] a){
        int count=0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int key = -(a[i]+a[j]);
                int lo = j+1;
                int hi = a.length-1;
                while(lo<=hi){
                    int mid = lo+(hi-lo)/2;
                    if(key<a[mid]){
                        hi=mid-1;
                    } else if (key>a[mid]) {
                        lo=mid+1;
                    }else {
                        count++;
                        break;
                    }
                }

            }
        }
        return count;
    }



}
