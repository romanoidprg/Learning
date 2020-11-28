package com.epam.jwd.model;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;

class Line extends Figure {
    private final Point pointA;
    private final Point pointB;

    Line(Point pA, Point pB){
        pointA = pA;
        pointB = pB;
        if (pointA.samePoint(pointB)) {
            this.setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
        } else {
            this.setFigurePropertyStrategy(ExistStrategy.getInstance());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Line line = (Line)(obj);
        return  (this.pointA.samePoint(line.pointA) && (this.pointB.samePoint(line.pointB)));
    }

    @Override
    double perimCalc() {
        return pointA.lengthToPoint(pointB);
    }

    @Override
    public String getCoordInfo() {
        return "Line ("
                + pointA.getX() + "," + pointA.getY() + ";  "
                + pointB.getX() + "," + pointB.getY() + "):";
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getLineInfo(this);
    }
}
