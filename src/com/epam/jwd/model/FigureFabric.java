package com.epam.jwd.model;


import com.epam.jwd.models.Figure;
import com.epam.jwd.models.Point;
import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.NotSquareStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

import java.util.ArrayList;

public class FigureFabric {

    private ArrayList<Figure> figureHash = new ArrayList<>();

    private Figure cntrlExstFigCreator(Figure figure){
        Figure fig = figure;
        if (figureHash.isEmpty()) {
            figureHash.add(figure);
        } else {
            int i = 0;
            int indexOfExistFig = -1;
            do {
                if (figure.equals(figureHash.get(i))) {
                    indexOfExistFig = i;
                    break;
                }
                i++;
            } while (i < figureHash.size());
            if (indexOfExistFig == -1) {
                figureHash.add(figure);
            } else {
                fig = figureHash.get(indexOfExistFig);
            }
        }
        return fig;

    }

    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint){

        Figure figure = null;

        switch (figureType){
            case LINE:
                if (arrayPoint.length>=2) {
                    figure = cntrlExstFigCreator(new Line(arrayPoint[0], arrayPoint[1]));
                }
                break;

            case TRIANGLE:
                if (arrayPoint.length>=3) {
                    figure = cntrlExstFigCreator(new Triangle(arrayPoint[0], arrayPoint[1], arrayPoint[2]));
                }
                break;

            case SQUARE:
                if (arrayPoint.length>=4) {
                    figure = cntrlExstFigCreator(new Square(arrayPoint[0], arrayPoint[1], arrayPoint[2], arrayPoint[3]));
                }
                break;

            case MULTI_ANGLE_FIGURE:
                if (arrayPoint.length>=4 && arrayPoint.length<=6) {
                    figure = cntrlExstFigCreator(new MultiAngleFigure(arrayPoint));
                }
                break;

        }
        return figure;

    }


    private static class Line extends Figure {
        private final Point pointA;
        private final Point pointB;

        private Line(Point pA, Point pB){
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
        public double perimCalc() {
            return pointA.lengthToPoint(pointB);
        }

        @Override
        public String getCoordInfo() {
            return "Line ("
                    + pointA.GetX() + "," + pointA.GetY() + ";  "
                    + pointB.GetX() + "," + pointB.GetY() + "):";
        }

        @Override
        public String toString() {
            return this.getFigurePropertyStrategy().getLineInfo(this);
        }
    }

    private static class Triangle extends Figure {
        private final Point pointA;
        private final Point pointB;
        private final Point pointC;

        public Triangle(Point pA, Point pB, Point pC) {
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
                    + pointA.GetX() + "," + pointA.GetY() + ";  "
                    + pointB.GetX() + "," + pointB.GetY() + ";  "
                    + pointC.GetX() + "," + pointC.GetY() + ")";
        }

        @Override
        public double perimCalc() {
            return pointA.lengthToPoint(pointB) + pointB.lengthToPoint(pointC) + pointC.lengthToPoint(pointA);
        }

        @Override
        public double areaCalc() {
            return Math.abs((pointA.GetX() * (pointB.GetY() - pointC.GetY())
                    + pointB.GetX() * (pointC.GetY() - pointA.GetY())
                    + pointC.GetX() * (pointA.GetY() - pointB.GetY())) / 2);
        }

        @Override
        public String toString() {
            return getFigurePropertyStrategy().getTriangleInfo(this);
        }
    }


    private static class Square extends Figure {
        private final Point pointA;
        private final Point pointB;
        private final Point pointC;
        private final Point pointD;

        public Square(Point pointA, Point pointB, Point pointC, Point pointD){
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
            return Math.abs((pointA.GetX()*pointB.GetY() + pointB.GetX()*pointC.GetY()
                    + pointC.GetX()*pointD.GetY() + pointD.GetX()*pointA.GetY()
                    - pointB.GetX()*pointA.GetY() - pointC.GetX()*pointB.GetY()
                    - pointD.GetX()*pointC.GetY() - pointA.GetX()*pointD.GetY() ) / 2);
        }

        @Override
        public String getCoordInfo(){
            return "Square ("
                    + pointA.GetX() + "," + pointA.GetY() + ";  "
                    + pointB.GetX() + "," + pointB.GetY() + ";  "
                    + pointC.GetX() + "," + pointC.GetY() + ";  "
                    + pointD.GetX() + "," + pointD.GetY() + ")";
        }

        @Override
        public String toString() {
            return this.getFigurePropertyStrategy().getSquareInfo(this);
        }

    }
}
