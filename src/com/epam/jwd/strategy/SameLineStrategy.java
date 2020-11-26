package com.epam.jwd.strategy;

import com.epam.jwd.models.Line;
import com.epam.jwd.models.Square;
import com.epam.jwd.models.Triangle;
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
    public String getTriangleInfo(Triangle triangle) {
        return triangle.getCoordInfo() + "  is not exist. The points are on the same line";
    }

    @Override
    public String getLineInfo(Line line){
        return "This is not line strategy";
    }

    @Override
    public String getSquareInfo(Square square){
        return square.getCoordInfo() + "  is not exist. Some three points are on the same line";
    }

}
