package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

abstract public class FigureFactoryDecorator implements FigureFactory {
    FigureFactory figureFactory;
    public FigureFactoryDecorator(FigureFactory figureFactory){
        this.figureFactory = figureFactory;
    }
    @Override
    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint) throws FigureException{
        return figureFactory.CreateFigure(figureType, arrayPoint);
    }

}
