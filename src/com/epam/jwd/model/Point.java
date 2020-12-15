package com.epam.jwd.model;

public class Point  {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double lengthToPoint(Point point){
        return Math.sqrt(
                Math.pow(this.getX()-point.getX(), 2)
                +Math.pow(this.getY()-point.getY(), 2) );
    }

    public boolean samePoint(Point point){
        return this.x==point.x && this.y==point.y;
    }

    public boolean IsOnSameLine(Point p1, Point p2){
       return ((p2.x-this.x)*(p1.y-this.y)==(p1.x-this.x)*(p2.y-this.y));
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y+") ";
    }

}
