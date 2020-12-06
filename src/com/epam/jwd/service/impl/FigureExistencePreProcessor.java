package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureProcessor;
import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.NotSquareStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

public class FigureExistencePreProcessor implements FigureProcessor {
    @Override
    public Figure process(Figure figure) throws FigureNotExistException {
        Point[] figurePointArray = figure.getFigurePointArray();
        Boolean isRecievedStrategy = false;


        if (!isRecievedStrategy) {
            for (int i = 0; i < figurePointArray.length; i++) {
                for (int j = i + 1; j < figurePointArray.length; j++) {
                    if (figurePointArray[i].samePoint(figurePointArray[j])) {
                        figure.setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
                        isRecievedStrategy = true;
                        break;
                    }
                }
            }
        }

        if ((!isRecievedStrategy) && (figure.getFigureType() != FigureType.LINE)) {
            for (int i = 0; i < figurePointArray.length; i++) {
                if (i < figurePointArray.length - 2) {
                    if (figurePointArray[i].IsOnSameLine(figurePointArray[i + 1], figurePointArray[i + 2])) {
                        figure.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        isRecievedStrategy = true;
                        break;
                    }
                } else if (i == figurePointArray.length - 2) {
                    if (figurePointArray[i].IsOnSameLine(figurePointArray[i + 1], figurePointArray[0])) {
                        figure.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        isRecievedStrategy = true;
                        break;
                    }
                } else if (i == figurePointArray.length - 1) {
                    if (figurePointArray[i].IsOnSameLine(figurePointArray[0], figurePointArray[1])) {
                        figure.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        isRecievedStrategy = true;
                        break;
                    }
                }
            }
        }

            if ((figure.getFigureType() == FigureType.SQUARE)
                    && !(figurePointArray[0].lengthToPoint(figurePointArray[1]) == figurePointArray[1].lengthToPoint(figurePointArray[2])
                    && figurePointArray[1].lengthToPoint(figurePointArray[2]) == figurePointArray[2].lengthToPoint(figurePointArray[3])
                    && figurePointArray[2].lengthToPoint(figurePointArray[3]) == figurePointArray[3].lengthToPoint(figurePointArray[0])
                    && figurePointArray[0].lengthToPoint(figurePointArray[2]) == figurePointArray[1].lengthToPoint(figurePointArray[3]))) {
                figure.setFigurePropertyStrategy(NotSquareStrategy.getInstance());
                isRecievedStrategy = true;
            }

            if (!isRecievedStrategy) {
                figure.setFigurePropertyStrategy(ExistStrategy.getInstance());
            }

            return figure;
        }
    }
