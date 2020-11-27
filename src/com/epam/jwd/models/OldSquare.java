package com.epam.jwd.models;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.NotSquareStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

public class OldSquare extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public OldSquare(Point pointA, Point pointB, Point pointC, Point pointD){
       this.pointA = pointA;
       this.pointB = pointB;
       this.pointC = pointC;
       this.pointD = pointD;

        if (pointA.samePoint(pointB)
                ||pointA.samePoint(pointC)
                ||pointA.samePoint(pointD)
                ||pointB.samePoint(pointC)
                ||pointB.samePoint(pointD)
                ||pointC.samePoint(pointD)) {
            this.setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
        } else if (pointA.IsOnSameLine(pointB,pointC)
                 ||pointB.IsOnSameLine(pointC,pointD)
                 ||pointC.IsOnSameLine(pointD,pointA)
                 ||pointD.IsOnSameLine(pointA,pointB)){
            this.setFigurePropertyStrategy(SameLineStrategy.getInstance());
        } else if (pointA.lengthToPoint(pointB)==pointB.lengthToPoint(pointC)
                && pointB.lengthToPoint(pointC)==pointC.lengthToPoint(pointD)
                && pointC.lengthToPoint(pointD)==pointD.lengthToPoint(pointA)
                && pointA.lengthToPoint(pointC)==pointB.lengthToPoint(pointD)){
            this.setFigurePropertyStrategy(ExistStrategy.getInstance());
        } else {
            this.setFigurePropertyStrategy(NotSquareStrategy.getInstance());
        }

    }

    public double perimCalc() {
        return pointA.lengthToPoint(pointB) + pointB.lengthToPoint(pointC)
                + pointC.lengthToPoint(pointD) + pointD.lengthToPoint(pointA);
    }

    public double areaCalc(){
        return Math.abs((pointA.GetX()*pointB.GetY() + pointB.GetX()*pointC.GetY()
                      + pointC.GetX()*pointD.GetY() + pointD.GetX()*pointA.GetY()
                      - pointB.GetX()*pointA.GetY() - pointC.GetX()*pointB.GetY()
                      - pointD.GetX()*pointC.GetY() - pointA.GetX()*pointD.GetY() ) / 2);
    }

    public String getCoordInfo(){
        return "Square ("
                + pointA.GetX() + "," + pointA.GetY() + ";  "
                + pointB.GetX() + "," + pointB.GetY() + ";  "
                + pointC.GetX() + "," + pointC.GetY() + ";  "
                + pointD.GetX() + "," + pointD.GetY() + ")";
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getSquareInfo(this);
    }

}
