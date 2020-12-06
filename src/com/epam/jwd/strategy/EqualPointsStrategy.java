package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EqualPointsStrategy implements FigurePropertyStrategy {

    INSTANCE;

    @Override
    public Logger getLogg() {
        return LogManager.getLogger(EqualPointsStrategy.class);
    }

    @Override
    public String getInfo(Figure figure) {
        switch (figure.getFigureType()) {
            case LINE:
                return figure.getCoordInfo() + FigureType.LINE_EQUAL_POINTS_INFO;
            case TRIANGLE:
            case SQUARE:
            case MULTI_ANGLE_FIGURE:
                return figure.getCoordInfo() + FigureType.MultiAng_EQUAL_POINTS_INFO;
            default:
                return "";
        }
    }
}
