package hou.mianjing.me;

import java.util.ArrayList;

/**
 * @author houweitao 2015年9月9日 下午2:34:02
 */

/*
 * 给一个list, list中有两个数. 过程中可以一直往list中加数进去(append在最后), 但必须一直遵守三个条件: 1.
 * list中所有数均需大于0 2. list中所有数都必须为unique 3. 新加入的数必须为已存在list中的某两数的差
 * 要做的事情是把所有可能的过程(一直加到没办法加入新的数字为止)都给打印或是回传
 */

public class AddNewNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> n = new ArrayList<Integer>();
		n.add(100);
		n.add(5);
		n.add(44);
		AddNewNumber ann=new AddNewNumber();
		ann.addNewNumber(n);
		
		
		System.out.println();
		
		for(int i=0;i<=100;i++)
			if(n.contains(i))
				System.out.print(" "+i);
		
	}

	void addNewNumber(ArrayList<Integer> n) {

		ArrayList<Integer> tmp = new ArrayList<Integer>();
		boolean judge = false;
		boolean judge2=false;
		while (!judge) {
			for (int i = 0; i < n.size(); i++) {
				for (int j = i; j < n.size(); j++) {
					if (n.get(i) > n.get(j)) {
						if (!tmp.contains(n.get(i) - n.get(j)) && !n.contains(n.get(i) - n.get(j))) {
							n.add(n.get(i)-n.get(j));
							int mmm=n.get(i)-n.get(j);
							judge2=true;
							System.out.println(n.get(i)+"-"+n.get(j)+"添加："+mmm);
						}
					} else if (!tmp.contains(n.get(j) - n.get(i)) && !n.contains(n.get(j) - n.get(i))) {
						n.add(n.get(j)-n.get(i));
						judge2=true;
						System.out.println(n.get(j)+"-"+n.get(i));
					}
				}
				
			}
			if(!judge2)
				judge = true;
			else
				judge2=false;
		}
		
		for(int i=0;i<n.size();i++)
			System.out.print("  "+n.get(i));
	}
}
