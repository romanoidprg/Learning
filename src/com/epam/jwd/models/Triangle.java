package com.epam.jwd.models;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

public class Triangle extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pA, Point pB, Point pC){
        pointA = pA;
        pointB = pB;
        pointC = pC;

        if (pointA.samePoint(pointB)||pointA.samePoint(pointC)||pointB.samePoint(pointC)) {
            setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
        } else if (pointA.IsOnSameLine(pointB,pointC)
                || pointB.IsOnSameLine(pointC,pointA)
                || pointC.IsOnSameLine(pointA,pointB)) {
            setFigurePropertyStrategy(SameLineStrategy.getInstance());
        } else {
            setFigurePropertyStrategy(ExistStrategy.getInstance());
        }
    }

    public String getCoordInfo(){
        return "Triangle (x1,y1;  x2,y2;  x3,y3):  "
                + pointA.GetX() + "," + pointA.GetY() + ";  "
                + pointB.GetX() + "," + pointB.GetY() + ";  "
                + pointC.GetX() + "," + pointC.GetY();
    }

    public double perimCalc() {
              return pointA.lengthToPoint(pointB) + pointB.lengthToPoint(pointC) + pointC.lengthToPoint(pointA);
           }

     public double areaCalc(){
        return Math.abs((pointA.GetX()*(pointB.GetY()-pointC.GetY())
              + pointB.GetX()*(pointC.GetY()-pointA.GetY())
              + pointC.GetX()*(pointA.GetY()-pointB.GetY()) ) / 2);
     }

    @Override
    public String toString() {
            return getFigurePropertyStrategy().getTriangleInfo(this);
    }

}
