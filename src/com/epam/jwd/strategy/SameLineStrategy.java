package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SameLineStrategy implements FigurePropertyStrategy {


    private static SameLineStrategy instance = new SameLineStrategy();

    private SameLineStrategy(){
    }

    public static SameLineStrategy getInstance(){
        return instance;
    }

    @Override
    public Logger getLogg(){
        return LogManager.getLogger(SameLineStrategy.class);
    }

    @Override
    public String getInfo(Figure figure) {
        switch (figure.getFigureType()) {
            case TRIANGLE:
            case SQUARE:
            case MULTI_ANGLE_FIGURE:
                return figure.getCoordInfo() + FigureType.POINTS_ON_SAME_LINE_MSG;
            default:
                return "";
        }
    }
}
