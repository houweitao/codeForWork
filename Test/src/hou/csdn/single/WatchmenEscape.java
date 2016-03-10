package hou.csdn.single;

/**
 * @author Elvis
 * @date 2015年11月12日 下午11:12:02
 * 竟然是14年4月的时候存下来的文章。。
 * @source http://blog.csdn.net/lxzh12345/article/details/22750955
 * 本来以为是算法，没想到是决策。。
 */

public class WatchmenEscape {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*	
  	int uiMagic：无符号整型，守望者的初始魔法值
	int uiDistance:无符号整型，守望者所在的初始位置与岛出口之间的距离。
	int uiSec：无符号整型，岛沉没需要的时间，单位为秒
	*/
	public void helpWatcherEscape(int uiMagic, int uiDistance, int uiSec) {
		int SpaceElse = 0, TimeleftElse = uiSec; // SpaceElse为行动距离累加，TimeleftElse为开始剩余时间另存
		while (uiMagic >= 10 && uiSec > 0 && uiDistance - SpaceElse > 0) { // 开始闪烁使用模拟
			if (uiDistance - SpaceElse > 17) {
				SpaceElse += 60;
				uiMagic -= 10;
				uiSec--;
			} else {
				System.out.println("Yes" + (TimeleftElse - uiSec + 1));
			}
		}
		while (uiSec > 0 && uiDistance - SpaceElse > 0) { // 决策判断
			if ((uiMagic == 0 || uiMagic == 1) && uiSec >= 7 && uiDistance - SpaceElse > 102) // 见表格
			{
				uiSec -= 7;
				SpaceElse += 120;
			} else if (uiMagic >= 2 && uiMagic <= 5 && uiSec >= 3 && uiDistance - SpaceElse > 34)// 见表格
			{
				uiMagic -= 2;
				uiSec -= 3;
				SpaceElse += 60;
			} else if (uiMagic >= 6 && uiSec >= 2 && uiDistance - SpaceElse > 17) // 见表格
			{
				uiMagic -= 6;
				uiSec -= 2;
				SpaceElse += 60;
			} else {
				SpaceElse += 17;
				uiSec--;
			}
		}
		if (uiDistance <= SpaceElse) {
			System.out.println("Yes " + (TimeleftElse - uiSec));
		} else {
			System.out.println("No " + SpaceElse);
		}
	}
}
