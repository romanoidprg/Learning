package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotSquareStrategy implements FigurePropertyStrategy {

    private static NotSquareStrategy instance;

    private NotSquareStrategy() {
    }

    public static synchronized NotSquareStrategy getInstance() {
        if (instance == null) {
            instance = new NotSquareStrategy();
        }
        return instance;
    }

    @Override
    public Logger getLogg() {
        return LogManager.getLogger(NotSquareStrategy.class);
    }

    @Override
    public String getInfo(Figure figure) {
        switch (figure.getFigureType()) {
            case SQUARE:
                return figure.getCoordInfo() + FigureType.RECT_NOT_SQUARE_MSG;
            default:
                return "";
        }
    }
}
