package hou.oschina.single;

/**
 * @author houweitao
 * 2015年9月21日 下午2:14:36
 * http://www.oschina.net/code/snippet_1275171_51042
 * 
 * 6*6的矩阵，从左上方开始，只经过向下或向右的步骤，到达右下方，找出经过的位置的最大价值；
200,120,400,150,180,300
150,250,360,120,200,130
350,300,250,100,500,260
100,150,260,320,100,150
500,130,260,100,200,170
160,100,250,200,600,200
 */

public class MaxPointMap {
	    public static void main(String[] args) {
	        int[][] value={
	        		{200,120,400,150,180,300},
	                {150,250,360,120,200,130},
	                {350,300,250,100,500,260},
	                {100,150,260,320,100,150},
	                {500,130,260,100,200,170},
	                {160,100,250,200,600,200}};
	        work(value);
	    }
	 
	    public static int work(int value[][]){
	        int maxValue[][] = new int[6][6];
	        maxValue[0][0] = value[0][0];
	        for (int i = 1; i < 6; i++) {
	            maxValue[0][i] = value[0][i]+maxValue[0][i-1];
	        }
	        for (int i = 1; i < 6; i++) {
	            maxValue[i][0] = value[i][0]+maxValue[i-1][0];
	        }
	         
	        for (int i = 1; i < 6; i++) {
	            for (int j = 1; j < 6; j++) {
	                maxValue[i][j] =Math.max(maxValue[i-1][j], maxValue[i][j-1])+value[i][j];
	            }
	        }
	         
	        show(maxValue);
	        return maxValue[5][5];
	    }
	     
	    public static void show(int matrix[][]){
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < matrix.length; j++) {
	                System.out.print(matrix[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }
	}