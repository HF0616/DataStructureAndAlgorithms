package Observation;

public class Three_brute_force {
    public static int count(int[] a){
        int sum=0;
        int N = a.length;
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    sum++;
                    if(a[i]+a[j]+a[k]==0){
                        count++;
                    }

                }
            }
        }
        return count;
    }

}
