package com.epam.jwd.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigureFactory {
    Figure CreateFigure(FigureType figureType, Point[] arrayPoint) throws FigureException;
}