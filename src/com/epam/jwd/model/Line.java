package com.epam.jwd.model;

class Line extends Figure {
    private final Point pointA;
    private final Point pointB;

    Line(Point pA, Point pB) {
        figureType = FigureType.LINE;
        pointA = pA;
        pointB = pB;

        figurePointArray = new Point[2];
        figurePointArray[0] = pA;
        figurePointArray[1] = pB;
    }

    @Override
    public double perimCalc() {
        return pointA.lengthToPoint(pointB);
    }

    @Override
    public String getCoordInfo() {
        return "Line ("
                + pointA.getX() + "," + pointA.getY() + ";  "
                + pointB.getX() + "," + pointB.getY() + "):";
    }

}
