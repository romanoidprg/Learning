package com.epam.jwd.model;


class Square extends Figure {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    Square(Point pointA, Point pointB, Point pointC, Point pointD) {
        figureType = FigureType.SQUARE;

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;

        figurePointArray = new Point[4];
        figurePointArray[0] = pointA;
        figurePointArray[1] = pointB;
        figurePointArray[2] = pointC;
        figurePointArray[3] = pointD;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Square square = (Square) (obj);
        return (this.pointA.samePoint(square.pointA)
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
    public double areaCalc() {
        return Math.abs((pointA.getX() * pointB.getY() + pointB.getX() * pointC.getY()
                + pointC.getX() * pointD.getY() + pointD.getX() * pointA.getY()
                - pointB.getX() * pointA.getY() - pointC.getX() * pointB.getY()
                - pointD.getX() * pointC.getY() - pointA.getX() * pointD.getY()) / 2);
    }

    @Override
    public String getCoordInfo() {
        return "Square ("
                + pointA.getX() + "," + pointA.getY() + ";  "
                + pointB.getX() + "," + pointB.getY() + ";  "
                + pointC.getX() + "," + pointC.getY() + ";  "
                + pointD.getX() + "," + pointD.getY() + ")";
    }

}
