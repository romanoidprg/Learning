package com.epam.jwd.model;

import com.epam.jwd.models.Figure;
import com.epam.jwd.models.Point;
import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

public class MultiAngleFigure extends Figure {
    private Point[] arrayPoint;

    public MultiAngleFigure(Point[] arrayPoint){
        this.arrayPoint = new Point[arrayPoint.length];
        System.arraycopy(arrayPoint, 0, this.arrayPoint, 0, arrayPoint.length);

       Boolean isRecievedStrategy = false;

       if (!isRecievedStrategy) {
           for (int i = 0; i < arrayPoint.length; i++) {
                for (int j = i + 1; j < arrayPoint.length; j++) {
                    if (arrayPoint[i].samePoint(arrayPoint[j])) {
                        this.setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
                        isRecievedStrategy = true;
                        break;
                    }
                }
           }
       }

        if (!isRecievedStrategy){
            for (int i = 0; i < arrayPoint.length; i++) {
                if (i < arrayPoint.length - 2) {
                    if (arrayPoint[i].IsOnSameLine(arrayPoint[i + 1], arrayPoint[i + 2])) {
                        this.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        isRecievedStrategy = true;
                        break;
                    } else if (arrayPoint[i].IsOnSameLine(arrayPoint[i - arrayPoint.length + 2],
                                                      arrayPoint[i - arrayPoint.length + 3])) {
                        this.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        isRecievedStrategy = true;
                        break;
                    }
                }
            }
        }

        if (!isRecievedStrategy) {
            this.setFigurePropertyStrategy(ExistStrategy.getInstance());
            isRecievedStrategy = true;
        }

    }

    public double perimCalc() {
        double p = 0;
        for (int i = 0; i < arrayPoint.length-1; i++) {
            p+=arrayPoint[i].lengthToPoint(arrayPoint[i+1]);
        }
        p+=arrayPoint[0].lengthToPoint(arrayPoint[arrayPoint.length-1]);
        return p;
    }

    public double areaCalc(){
        return Math.abs((12 ) / 2);
    }

    public String getCoordInfo(){
        String coordInfo = "Square (";
        for (int i = 0; i < arrayPoint.length; i++) {
            coordInfo += arrayPoint[i].GetX() + "," + arrayPoint[i].GetY() + ";  ";
        }
        return coordInfo + ")";
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getMultiAngleInfo(this);
    }

}
