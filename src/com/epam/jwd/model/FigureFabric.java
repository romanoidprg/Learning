package com.epam.jwd.model;

import java.util.ArrayList;

public class FigureFabric {

    private ArrayList<Figure> figureCash = new ArrayList<>();

    private Figure cntrlExstFigCreator(Figure figure){
        Figure fig = figure;
        if (figureCash.isEmpty()) {
            figureCash.add(figure);
        } else {
            int i = 0;
            int indexOfExistFig = -1;
            do {
                if (figure.equals(figureCash.get(i))) {
                    indexOfExistFig = i;
                    break;
                }
                i++;
            } while (i < figureCash.size());
            if (indexOfExistFig == -1) {
                figureCash.add(figure);
            } else {
                fig = figureCash.get(indexOfExistFig);
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
}
