package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertyStrategy;

import java.util.Arrays;

public abstract class Figure {

    protected FigureType figureType;

    public FigureType getFigureType() {
        return figureType;
    }

    protected Point[] figurePointArray;

    public Point[] getFigurePointArray() {
        return figurePointArray;
    }

    private FigurePropertyStrategy figurePropertyStrategy;

    public void setFigurePropertyStrategy(FigurePropertyStrategy figurePropertyStrategy) {
        this.figurePropertyStrategy = figurePropertyStrategy;
    }

    public FigurePropertyStrategy getFigurePropertyStrategy() {
        return figurePropertyStrategy;
    }

    public void infoLogg() {
        figurePropertyStrategy.getLogg().log(figurePropertyStrategy.getLogg().getLevel(), this.toString());
    }

    public String getCoordInfo() {
        return FigureType.UNDEF_FIG_MSG;
    }

    public double perimCalc() {
        return 0;
    }

    public double areaCalc() {
        return 0;
    }

    @Override
    public String toString() {
        return this.getFigurePropertyStrategy().getInfo(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
         Figure fig = (Figure) (obj);
        return (Arrays.asList(fig.figurePointArray).containsAll(Arrays.asList(this.figurePointArray))
        && Arrays.asList(this.figurePointArray).containsAll(Arrays.asList(fig.figurePointArray)));

    }

    @Override
    public int hashCode() {
        return (figurePointArray.length+Arrays.hashCode(figurePointArray))*5;
    }
}