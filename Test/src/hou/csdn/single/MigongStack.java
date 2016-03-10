package hou.csdn.single;

import java.util.Stack;

/**
 * @author houweitao
 * 2015年9月16日 上午10:36:37
 */

public class MigongStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] map=
			{
			    {1,1,1,1,1,1,1,1,1,1},
			    {1,0,0,1,0,0,0,1,0,1},
			    {1,0,1,1,0,0,0,1,0,1},
			    {1,0,0,0,0,1,1,0,0,1},
			    {1,0,1,1,0,0,0,0,0,1},
			    {1,0,0,0,1,0,0,0,0,1},
			    {1,0,1,0,0,0,1,0,0,1},
			    {1,0,1,1,1,0,1,1,1,1},
			    {1,1,0,0,0,0,0,0,0,1},
			    {1,1,1,1,1,1,1,1,1,1}
			};
		
//		Stack<Dot> s=null;
//		Dot dot=new Dot(0,0,-1);
//		s.push(dot);
		
		System.out.println(map[4][2]);
		
		MigongStack ms=new MigongStack();
		ms.findRode(map, 1, 1);
		
	}

	void findRode(int[][] map,int m,int n){
		boolean find=false;
		Dot dot=new Dot(m,n,-1);
		Stack<Dot> stack=new Stack<Dot>();
		stack.push(dot);
		
		while(!stack.isEmpty()){
			Dot d=stack.peek();
			int di=d.di;
			int i=d.i;
			int j=d.j;
			find=false;
			
			System.out.println("now postion: ("+i+","+j+")");
			
			if(i==8 && j==8){
				System.out.println("find!");
				for(Dot dOut:stack){
					System.out.println("("+dOut.i+","+dOut.j+")");
				}
				
				stack.clear();
				
				return;
			}
			
			while(di<4 && !find){
				di++;
				switch(di){
				case 0:
					j=d.j+1;
					break;
				case 1:
					i=d.i+1;
					break;
				case 2:
					j=d.j-1;
					break;
				case 3:
					i=d.i-1;
					break;
				}
				
				if(map[i][j]==0){
					find=true;
					d.di=di;
					map[d.i][d.j]=1;
				}
				else{
					i=d.i;
					j=d.j;
				}
			}
			
			if(find){
				d.di=di;
				stack.push(new Dot(i,j,-1));
//				System.out.println("("+i+","+j+")");
			}
			else{
				Dot dTmp= stack.peek();
				map[dTmp.i][dTmp.j]=0;
				stack.pop();
			}
		}
		
		System.out.println("can not find");
	}
	
}

class Dot{
	int i;
	int j;
	int di;
	
	Dot(int i,int j,int di){
		this.i=i;
		this.j=j;
		this.di=di;
	}
}
