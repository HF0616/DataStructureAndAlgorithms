import Dynamic_Connectivity.QuickUnionUF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class percolation extends JFrame {

     private int[][] isOpen =null;
     private int N;  //设置正方格的边长
     private double rate; //设置每个元胞渗透的概率
     public percolation(){
         this.N = 10;
         this.rate = 0;
     }

     public percolation(int N,double rate){
         //构造器
         this.N = N;
         this.rate = rate;

         isOpen = new int[N][N];


         setTitle("渗滤模型可视化");
         setSize(350,350);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JButton button = new JButton("渗滤仿真");
         button.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 //点击按钮时运行的代码
                 simulatePercolation();
                 repaint();
             }

         });

         JPanel buttonPanel = new JPanel();  //创建一个新的JPanel对象，它是一个面板容器，用于承载用户界面上的组件（如按钮）
         buttonPanel.add(button); //将按钮添加到该面板中
         add(buttonPanel, BorderLayout.SOUTH);  //设置按钮位置

         setVisible(true);  //将窗口显示在屏幕上
     }

     public void simulatePercolation(){
         double randomValue;
         Random random = new Random();
         for(int i=0;i<N;i++){
             for(int j=0;j<N;j++){
                 randomValue = random.nextDouble();
                 if(randomValue<=rate){
                     isOpen[i][j]=1;
                 }else {
                     isOpen[i][j]=0;
                 }
             }
         }
         percolationUF();




     }

    public void paint(Graphics g){
        super.paint(g);
        int cellSize = 3; // 设置每个cell的大小（30个像素）

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(isOpen[i][j]==1){
                    g.setColor(Color.WHITE);
                }else if(isOpen[i][j]==0){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.BLUE);
                }
//                绘制方格的内部
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
    }

    public void percolationUF(){
         //定义相邻格子的坐标偏移
        QuickUnionUF uuf = null; //创建存储对象用于连接和查找
        uuf = new QuickUnionUF(N*N+2); //为模型顶部和底部各加一个虚拟点辅助查找（用于提高性能）

        for(int j=0;j<N;j++){
            uuf.union(N*N,j);
            uuf.union(N*N+1,(N-1)*N+j);
        }


        int[][] neighbors  = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                int current = i * N + j;
                for (int[] neighbor : neighbors) {
                    int newRow = i + neighbor[0];
                    int newCol = j + neighbor[1];
                    if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                        int neighborIndex = newRow * N + newCol;
                        if ((isOpen[newRow][newCol] == 1 && isOpen[i][j] == 1) || (isOpen[newRow][newCol] == 2 && isOpen[i][j] == 1)) {
                            uuf.union(current, neighborIndex);
                        }
                    }
                }
            }
        }
        System.out.println("是否渗滤：" + uuf.connected(N * N, N * N + 1));

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new percolation(100,0.6);
            }
        });
    }

}
