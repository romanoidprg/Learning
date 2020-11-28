package com.epam.jwd.model;

import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

class MultiAngleFigure extends Figure {
    private Point[] arrayPoint;

    MultiAngleFigure(Point[] arP){
        arrayPoint = new Point[arP.length];
        System.arraycopy(arP, 0, arrayPoint, 0, arrayPoint.length);

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
                    }
                } else if (arrayPoint[i].IsOnSameLine(arrayPoint[i - arrayPoint.length + 2],
                                                      arrayPoint[i - arrayPoint.length + 3])) {
                        this.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        isRecievedStrategy = true;
                        break;
                }
            }
        }


        if (!isRecievedStrategy) {
            this.setFigurePropertyStrategy(ExistStrategy.getInstance());
        }

    }

    @Override
    double perimCalc() {
        double p = 0;
        for (int i = 0; i < arrayPoint.length-1; i++) {
            p+=arrayPoint[i].lengthToPoint(arrayPoint[i+1]);
        }
        p+=arrayPoint[0].lengthToPoint(arrayPoint[arrayPoint.length-1]);
        return p;
    }

    @Override
    double areaCalc(){
        int s = 0;
        for (int i = 0; i < arrayPoint.length-1; i++) {
            s+=arrayPoint[i].getX()*arrayPoint[i+1].getY() - arrayPoint[i+1].getX()*arrayPoint[i].getY();
        }
        s+=arrayPoint[arrayPoint.length-1].getX()*arrayPoint[0].getY()
                -arrayPoint[0].getX()*arrayPoint[arrayPoint.length-1].getY();
        return Math.abs(s / 2);
    }

    @Override
    public String getCoordInfo(){
        String coordInfo = "MultiAngel of " + arrayPoint.length + " points (";
        for (int i = 0; i < arrayPoint.length; i++) {
            coordInfo += arrayPoint[i].getX() + "," + arrayPoint[i].getY() + ";  ";
        }
        return coordInfo.substring(0, coordInfo.length()-3) + ")";
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getMultiAngleInfo(this);
    }

}
