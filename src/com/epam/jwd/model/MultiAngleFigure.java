package com.epam.jwd.model;

class MultiAngleFigure extends Figure {

    MultiAngleFigure(Point[] arP) {
        figureType = FigureType.MULTI_ANGLE_FIGURE;
        figurePointArray = new Point[arP.length];
        System.arraycopy(arP, 0, figurePointArray, 0, figurePointArray.length);

    }

    @Override
    public double perimCalc() {
        double p = 0;
        for (int i = 0; i < figurePointArray.length - 1; i++) {
            p += figurePointArray[i].lengthToPoint(figurePointArray[i + 1]);
        }
        p += figurePointArray[0].lengthToPoint(figurePointArray[figurePointArray.length - 1]);
        return p;
    }

    @Override
    public double areaCalc() {
        int s = 0;
        for (int i = 0; i < figurePointArray.length - 1; i++) {
            s += figurePointArray[i].getX() * figurePointArray[i + 1].getY() - figurePointArray[i + 1].getX() * figurePointArray[i].getY();
        }
        s += figurePointArray[figurePointArray.length - 1].getX() * figurePointArray[0].getY()
                - figurePointArray[0].getX() * figurePointArray[figurePointArray.length - 1].getY();
        return Math.abs(s / 2);
    }

    @Override
    public String getCoordInfo() {
        String coordInfo = "MultiAngel of " + figurePointArray.length + " points (";
        for (int i = 0; i < figurePointArray.length; i++) {
            coordInfo += figurePointArray[i].getX() + "," + figurePointArray[i].getY() + ";  ";
        }
        return coordInfo.substring(0, coordInfo.length() - 3) + ")";
    }

}
