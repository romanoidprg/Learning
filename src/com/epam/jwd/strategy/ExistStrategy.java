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
    public String getTriangleInfo(Figure triangle){
        return triangle.getCoordInfo() + ".  Perimetr = " + String.format("%.3f",triangle.perimCalc())
                + ".  Area = " + String.format("%.3f",triangle.areaCalc());
    }

    @Override
    public String getLineInfo(Figure line){
        return line.getCoordInfo() + ".  LineLength = " + String.format("%.3f", line.perimCalc());
    }

    @Override
    public String getSquareInfo(Figure square){
        return square.getCoordInfo() + ".  Perimetr = " + String.format("%.3f", square.perimCalc())
                + ".  Area = " + String.format("%.3f", square.areaCalc());
    }

}
