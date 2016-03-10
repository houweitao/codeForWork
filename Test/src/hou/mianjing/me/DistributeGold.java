package hou.mianjing.me;

import java.util.Scanner;

/**
 * @author houweitao
 * 2015年9月18日 上午11:14:41
 */

public class DistributeGold     //主函数
{
	public static void main(String args[])
	{
		thieves thi = new thieves();
		thi.thievesNum = 5;
		thi.agree=false;
		thi.init(thi.thievesNum);
		while(thi.agree == false)
		{
			thi.makeChoice(thi.thievesNum);
			thi.checkOut(thi.thievesNum);
			thi.showCheckOut();
			System.out.println();
			thi.agreeJudge(); 
			System.out.println("现在共有"+thi.thievesNum+"个人 ");  //大家不满意。阵亡一个。
			System.out.println("其中有"+thi.yesCount+"个人同意，有"+thi.noCount+"个人不同意。");
			
			if(thi.yesCount<=thi.noCount)
			{
				System.out.println("因此,"+thi.thieves[thi.thievesNum-1]+"被扔入大海喂鲨鱼");
				System.out.println();
				thi.thievesNum--;//因为分配不被认可，所以一个盗贼被喂鲨鱼。盗贼人数-1
				System.out.println("接下来由下一个盗贼来分配金子。还剩"+thi.thievesNum+"个盗贼");
				
				thi.yesCount=thi.noCount=0;
			}
			else
				System.out.println("因此，分配完毕!");
		}
		//System.out.println("分配完毕");
		
	}
}

class thieves
{
	String thieves[] = {"five","four","three","two","one"};  //盗贼的名字
	int gold[] = new int[5];          //用于记录金子的分配情况，和上面的数组一一对应
	String choice[]=new String[5];  //用于记录各个盗贼的态度，分布为“死亡”，“YES”，“NO”
	boolean agree = false;          //用于表现某盗贼的决议是否得到大家的肯定。即有没有通过，没通过则扔进大海喂鲨鱼
	int yesCount=0,noCount=0;  //用于记录同意/不同意的盗贼的人数	
	int thievesNum;  //还幸存的盗贼的数量。
	
	void init(int thievesNum)   //初始化
	{
		int num = thievesNum;
		System.out.println("现在仍然幸存的盗贼有：");
            for(int i=num-1;i>=0;i--)
            	System.out.print(thieves[i]+" ");
            System.out.println();
	}
	
	void makeChoice(int thievesNum) //输入的参数是还剩多少人.某个盗贼的金子分配方案函数
	{
		boolean makesure = false; //100块金子是否完全分配
		int goldNum = 0;
		//int choicePeople = 6-thievesNum;//做决定的人所在位置
		System.out.println("现在做决定的是:  盗贼 "+ this.thieves[thievesNum-1]);
		System.out.println("请输入您要分配的金子数量，总和为100");
		
		while (makesure == false)
		{
			for (int j = thievesNum;j>0;j--)
			{
				System.out.println("请您帮盗贼"+ this.thieves[j-1]  +"分配金子");
				Scanner reader = new Scanner(System.in);
				int dNum = reader.nextInt();
				gold[j-1] = dNum;
				goldNum = goldNum+gold[j-1];
			}
			if(goldNum == 100)
			{
				makesure = true;
				System.out.println("分配情况如下:");
				System.out.println("盗贼  one two three four  five");
				System.out.print("金子");
				for (int k=0;k<5;k++)
					
				{
					if(k<5-this.thievesNum)
						System.out.print("  死亡 ");
					else
						System.out.print("   "+gold[4-k]+"    ");
				}	
				System.out.println(" ");
			}
			else
				System.out.println("金子只和只能为100！！！麻烦您重新分配");
		}				
	}
	
	void checkOut(int thievesNum)   //其他盗贼权衡利弊来投票的函数。其中进行决策的盗贼必定会同意。
	{
		switch(thievesNum)
		{
			case 1:
			{
				choice[0] = "OK";
				choice[1]="阵亡";
				choice[2]="阵亡";
				choice[3]="阵亡";
				choice[4]="阵亡";
			};break;
			case 2:
			{
				choice[0] = "NO";
				choice[1]="YES";
				choice[2]="阵亡";
				choice[3]="阵亡";
				choice[4]="阵亡";
			};break;
			case 3:
			{
				choice[0]="NO";
				choice[1]="YES";
				choice[2]="YES";
				choice[3]="阵亡";
				choice[4]="阵亡";
			};break;
			case 4:
			{
				if(gold[0]>0) choice[0]="YES";
				else choice[0]="NO";
				if(gold[1]>0) choice[1]="YES";
				else choice[1]="NO";
				
				choice[2] ="NO";
				choice[3]="YES";
				choice[4]="阵亡";
			};break;
			case 5:
			{
				if(gold[0]>1) choice[0]="YES";
				else choice[0] ="NO";
				if(gold[1]>1) choice[1]="YES";
				else choice[1] ="NO";
				if(gold[2]>0) choice[2]="YES";
				else choice[2]="NO";
				if(gold[3]>98) choice[3]="YES";
				else choice[3]="NO";
				
				choice[4]="YES";
			};break;
		}
	}
	
	void showCheckOut()   //展示投票结果
	{
		System.out.println("投票结果如下：");
		System.out.println("one   two   three   four   five");
		for (int l = 4;l>=0;l--)
			System.out.print(choice[l]+"   ");		
	}
	
	void agreeJudge()   //看看分配方案有没有得到超过一半人的认可
	{
		//int yesCount=0,noCount=0;
		for(int l =4;l>=0;l--)
		{
			if (choice[l]=="YES")   yesCount++;
			else if(choice[l]=="NO") noCount++;
		}
		if(yesCount-noCount>0)
			agree= true;
	}
}