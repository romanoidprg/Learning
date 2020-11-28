package com.epam.jwd.model;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

class Triangle extends Figure {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;

    Triangle(Point pA, Point pB, Point pC) {
        pointA = pA;
        pointB = pB;
        pointC = pC;

        if (pointA.samePoint(pointB) || pointA.samePoint(pointC) || pointB.samePoint(pointC)) {
            setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
        } else if (pointA.IsOnSameLine(pointB, pointC)
                || pointB.IsOnSameLine(pointC, pointA)
                || pointC.IsOnSameLine(pointA, pointB)) {
            setFigurePropertyStrategy(SameLineStrategy.getInstance());
        } else {
            setFigurePropertyStrategy(ExistStrategy.getInstance());
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
        Triangle triangle = (Triangle) (obj);
        return  (this.pointA.samePoint(triangle.pointA)
                && (this.pointB.samePoint(triangle.pointB))
                && (this.pointC.samePoint(triangle.pointC)));
    }

    @Override
    public String getCoordInfo() {
        return "Triangle ("
                + pointA.getX() + "," + pointA.getY() + ";  "
                + pointB.getX() + "," + pointB.getY() + ";  "
                + pointC.getX() + "," + pointC.getY() + ")";
    }

    @Override
    public double perimCalc() {
        return pointA.lengthToPoint(pointB) + pointB.lengthToPoint(pointC) + pointC.lengthToPoint(pointA);
    }

    @Override
    public double areaCalc() {
        return Math.abs((pointA.getX() * (pointB.getY() - pointC.getY())
                + pointB.getX() * (pointC.getY() - pointA.getY())
                + pointC.getX() * (pointA.getY() - pointB.getY())) / 2);
    }

    @Override
    public String toString() {
        return getFigurePropertyStrategy().getTriangleInfo(this);
    }
}
