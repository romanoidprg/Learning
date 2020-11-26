package com.epam.jwd.models;

import com.epam.jwd.strategy.ExistStrategy;

public class Point extends Figure{
    private int x;
    private int y;

    public Point(int x, int y){
        this.setFigurePropertyStrategy(ExistStrategy.getInstance());
        this.x = x;
        this.y = y;
    }

    public int GetX(){
        return x;
    }

    public int GetY(){
        return y;
    }

    public double lengthToPoint(Point point){
        return Math.sqrt(
                Math.pow(this.GetX()-point.GetX(), 2)
                +Math.pow(this.GetY()-point.GetY(), 2) );
    }

    public boolean samePoint(Point point){
        return this.x==point.x && this.y==point.y;
    }

    public boolean IsOnSameLine(Point p1, Point p2){
       if ((p2.x-this.x)*(p1.y-this.y)==(p1.x-this.x)*(p2.y-this.y)){
           return true;
       } else {
           return false;
       }
    }
    @Override
    public String toString() {
        return "Point(x,y): " + x + ", " + y;
    }

}
