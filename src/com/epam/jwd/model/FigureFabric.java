package com.epam.jwd.model;

import com.epam.jwd.models.*;

public class FigureFabric {
    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint){

        Figure figure = null;

        switch (figureType){
            case LINE:
                if (arrayPoint.length>=2) {
                    figure = new Line(arrayPoint[0],arrayPoint[1]);
                }
                break;

            case TRIANGLE:
                if (arrayPoint.length>=3) {
                    figure = new Triangle(arrayPoint[0], arrayPoint[1], arrayPoint[2]);
                }
                break;

            case SQUARE:
                if (arrayPoint.length>=4) {
                    figure = new Square(arrayPoint[0], arrayPoint[1], arrayPoint[2], arrayPoint[3]);
                }
                break;

        }
        return figure;

    }
}
