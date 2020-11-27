package com.epam.jwd.strategy;

import com.epam.jwd.models.Figure;
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
    public String getTriangleInfo(Figure figure) {
        return figure.getCoordInfo() + "  is not exist. The points are on the same line";
    }

    @Override
    public String getLineInfo(Figure figure){
        return "This is not line strategy";
    }

    @Override
    public String getSquareInfo(Figure figure){
        return figure.getCoordInfo() + "  is not exist. Some three points are on the same line";
    }

    @Override
    public String getMultiAngleInfo(Figure figure) {
        return figure.getCoordInfo() + "  is not exist. Some three points are on the same line";
    }
}
