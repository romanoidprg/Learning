package com.epam.jwd.models;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;

public class OldLine extends Figure {
    private Point pointA;
    private Point pointB;

    public OldLine(Point pA, Point pB){
        pointA = pA;
        pointB = pB;
        if (pointA.samePoint(pointB)) {
            this.setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
        } else {
            this.setFigurePropertyStrategy(ExistStrategy.getInstance());
        }
    }

    public double perimCalc() {
        return pointA.lengthToPoint(pointB);
    }

    public String getCoordInfo(){
        return "Line ("
                + pointA.GetX() + "," + pointA.GetY() + ";  "
                + pointB.GetX() + "," + pointB.GetY() + "):";
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getLineInfo(this);
    }
}
