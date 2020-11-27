package com.epam.jwd.strategy;

import com.epam.jwd.models.Figure;
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
    public String getTriangleInfo(Figure figure){
        return figure.getCoordInfo() + ".  Perimetr = " + String.format("%.3f",figure.perimCalc())
                + ".  Area = " + String.format("%.3f",figure.areaCalc());
    }

    @Override
    public String getLineInfo(Figure figure){
        return figure.getCoordInfo() + ".  LineLength = " + String.format("%.3f", figure.perimCalc());
    }

    @Override
    public String getSquareInfo(Figure figure){
        return figure.getCoordInfo() + ".  Perimetr = " + String.format("%.3f", figure.perimCalc())
                + ".  Area = " + String.format("%.3f", figure.areaCalc());
    }

}
