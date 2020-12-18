package com.epam.jwd.model;

class Triangle extends Figure {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;

    Triangle(Point pA, Point pB, Point pC) {
        figureType = FigureType.TRIANGLE;

        pointA = pA;
        pointB = pB;
        pointC = pC;

        figurePointArray = new Point[3];
        figurePointArray[0] = pA;
        figurePointArray[1] = pB;
        figurePointArray[2] = pC;
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

}
