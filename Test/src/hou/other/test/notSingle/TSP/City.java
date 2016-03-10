package hou.other.test.notSingle.TSP;

/**
 * @author houweitao
 * @date 2015年11月4日 下午4:49:15
 * http://www.acmerblog.com/simulated-annealing-algorithm-tsp-5841.html
 */

public class City {
    int x;
    int y;

    // 生成一个随机的城市
    public City(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }

    public City(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    // 计算两个城市之间的距离
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
    }

    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}