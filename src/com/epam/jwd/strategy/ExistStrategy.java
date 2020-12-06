package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExistStrategy implements FigurePropertyStrategy {

    private static ExistStrategy instance;

    private ExistStrategy(){
    }

    public static ExistStrategy getInstance(){
        if (instance == null){
            instance = new ExistStrategy();
        }
        return instance;
    }

    @Override
    public Logger getLogg(){
        return LogManager.getLogger(ExistStrategy.class);
    }

    @Override
    public String getInfo(Figure figure) {
        switch (figure.getFigureType()) {
            case LINE:
                return figure.getCoordInfo() + ".  LineLength = " + String.format("%.3f", figure.perimCalc());
            case TRIANGLE:
            case SQUARE:
            case MULTI_ANGLE_FIGURE:
                return figure.getCoordInfo() + ".  Perimetr = " + String.format("%.3f",figure.perimCalc())
                        + ".  Area = " + String.format("%.3f",figure.areaCalc());
            default:
                return "";
        }
    }
}
