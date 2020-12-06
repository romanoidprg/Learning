package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

import java.util.ArrayList;

public class FigureFabric {

    public static ArrayList<Figure> figureCash = new ArrayList<>();

    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint) throws FigureException {

        Figure figure;
        FigureExistencePreProcessor preProcessor = new FigureExistencePreProcessor();
        FigureExistencePostProcessor postProcessor = new FigureExistencePostProcessor();

        switch (figureType) {
            case LINE:
                if (arrayPoint.length >= 2) {
                    figure = preProcessor.process(new Line(arrayPoint[0], arrayPoint[1]));
                } else {
                    throw new FigureNotExistException(FigureType.ONE_POINT_LINE_MSG);
                }
                break;

            case TRIANGLE:
                if (arrayPoint.length >= 3) {
                    figure = preProcessor.process(new Triangle(arrayPoint[0], arrayPoint[1], arrayPoint[2]));
                } else {
                    throw new FigureNotExistException(FigureType.TWO_POINT_RECT_MSG);
                }
                break;

            case SQUARE:
                if (arrayPoint.length >= 4) {
                    figure = preProcessor.process(new Square(arrayPoint[0], arrayPoint[1], arrayPoint[2], arrayPoint[3]));
                } else {
                    throw new FigureNotExistException(FigureType.TREE_POINT_SQUARE_MSG);
                }
                break;

            case MULTI_ANGLE_FIGURE:
                if (arrayPoint.length >= 4) {
                    figure = preProcessor.process(new MultiAngleFigure(arrayPoint));
                } else {
                    throw new FigureNotExistException(FigureType.TREE_POINT_MAF_MSG);
                }
                break;
            default:
                figure = null;

        }
        return postProcessor.process(figure);
    }
}
