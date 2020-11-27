package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotSquareStrategy implements FigurePropertyStrategy {

    private static NotSquareStrategy instance;

    private NotSquareStrategy(){
    }

    public static synchronized NotSquareStrategy getInstance(){
        if (instance == null){
            instance = new NotSquareStrategy();
        }
        return instance;
    }

    @Override
    public Logger getLogg(){
        return LogManager.getLogger(NotSquareStrategy.class);
    }

    @Override
    public String getTriangleInfo(Figure figure){
        return figure.getCoordInfo() + ".  Perimetr = " + figure.perimCalc() + ".  Area = " + figure.areaCalc();
    }

    @Override
    public String getLineInfo(Figure figure){
        return figure.getCoordInfo() + ".  LineLength = " + figure.perimCalc();
    }

    @Override
    public String getSquareInfo(Figure figure){
        return figure.getCoordInfo() + "  is just rectangle, but is not square";
    }

    @Override
    public String getMultiAngleInfo(Figure figure) {
        return "Its funny";
    }
}
