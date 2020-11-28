package com.epam.jwd.model;

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

    double perimCalc(){
        return 0;
    }

    double areaCalc(){
        return 0;
    }

}
