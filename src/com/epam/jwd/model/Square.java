package com.epam.jwd.model;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.NotSquareStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

class Square extends Figure {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

     Square(Point pointA, Point pointB, Point pointC, Point pointD){
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

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Square square = (Square) (obj);
        return  (this.pointA.samePoint(square.pointA)
                && (this.pointB.samePoint(square.pointB))
                && (this.pointC.samePoint(square.pointC))
                && (this.pointD.samePoint(square.pointD)));
    }

    @Override
    public double perimCalc() {
        return pointA.lengthToPoint(pointB) + pointB.lengthToPoint(pointC)
                + pointC.lengthToPoint(pointD) + pointD.lengthToPoint(pointA);
    }

    @Override
    public double areaCalc(){
        return Math.abs((pointA.getX()*pointB.getY() + pointB.getX()*pointC.getY()
                + pointC.getX()*pointD.getY() + pointD.getX()*pointA.getY()
                - pointB.getX()*pointA.getY() - pointC.getX()*pointB.getY()
                - pointD.getX()*pointC.getY() - pointA.getX()*pointD.getY() ) / 2);
    }

    @Override
    public String getCoordInfo(){
        return "Square ("
                + pointA.getX() + "," + pointA.getY() + ";  "
                + pointB.getX() + "," + pointB.getY() + ";  "
                + pointC.getX() + "," + pointC.getY() + ";  "
                + pointD.getX() + "," + pointD.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getSquareInfo(this);
    }

}
