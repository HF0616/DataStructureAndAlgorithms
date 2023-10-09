package Dynamic_Connectivity;
import StdIn.StdIn;
public class Dynamic_Connectivity {
    public static void main(String[] args) {
        System.out.println("QuickFoundUF的测试：");
        StdIn.openFile("Data/tinyUF.txt");
        int N = StdIn.readInt();
        QuickFindUF fuf = new QuickFindUF(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            System.out.println(p+" "+q);
            fuf.union(p,q);
        }
        StdIn.close();
        System.out.println("QuickUnionUF的测试：");
        StdIn.openFile("Data/tinyUF.txt");
        int N1 = StdIn.readInt();
        QuickUnionUF uuf = new QuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uuf.union(p,q);
            System.out.println(p+" "+q);

        }
        StdIn.close();
    }

}
