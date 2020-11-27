package com.epam.jwd.models;

import com.epam.jwd.strategy.FigurePropertyStrategy;

public class Figure {

    private FigurePropertyStrategy figurePropertyStrategy;

    public void setFigurePropertyStrategy(FigurePropertyStrategy figurePropertyStrategy) {
        this.figurePropertyStrategy = figurePropertyStrategy;
    }

    public FigurePropertyStrategy getFigurePropertyStrategy() {
        return figurePropertyStrategy;
    }

    public void infoLogg(){
        figurePropertyStrategy.getLogg().log(figurePropertyStrategy.getLogg().getLevel(), this.toString());
    }

    public String getCoordInfo(){
        return "Unknown figure";
    }

    public double perimCalc(){
        return 0;
    }

    public double areaCalc(){
        return 0;
    }

}
