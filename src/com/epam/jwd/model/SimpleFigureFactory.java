package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePreProcessor;

import java.util.ArrayList;

public enum  SimpleFigureFactory implements FigureFactory {

    INSTANCE;

    public static ArrayList<Figure> figureCash = new ArrayList<>();

    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint) throws FigureException {

        FigureExistencePreProcessor preProcessor = new FigureExistencePreProcessor();

        switch (figureType) {
            case LINE:
                return preProcessor.process(new Line(arrayPoint[0], arrayPoint[1]));
            case TRIANGLE:
                return preProcessor.process(new Triangle(arrayPoint[0], arrayPoint[1], arrayPoint[2]));
            case SQUARE:
                return preProcessor.process(new Square(arrayPoint[0], arrayPoint[1], arrayPoint[2], arrayPoint[3]));
            case MULTI_ANGLE_FIGURE:
                return preProcessor.process(new MultiAngleFigure(arrayPoint));
            default:
                return null;
        }
    }
}
