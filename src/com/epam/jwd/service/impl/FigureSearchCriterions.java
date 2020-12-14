package com.epam.jwd.service.impl;

import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigurePropertyStrategy;

public class FigureSearchCriterions {
    private FigureType figureType;
    private FigurePropertyStrategy figureStrategy;
    private Point[] arrayPoints;

    public FigureType getFigureType() {
        return figureType;
    }

    public FigurePropertyStrategy getFigureStrategy() {
        return figureStrategy;
    }

    public Point[] getArrayPoints() {
        return arrayPoints;
    }

    public static class CriterionBuilder {
        private FigureSearchCriterions searchCriterions;

        public CriterionBuilder() {
            searchCriterions = new FigureSearchCriterions();
        }

        public CriterionBuilder withFigureType(FigureType type) {
            searchCriterions.figureType = type;
            return this;
        }

        public CriterionBuilder withFigureStrategy(FigurePropertyStrategy strategy) {
            searchCriterions.figureStrategy = strategy;
            return this;
        }

        public CriterionBuilder withArrayPoints(Point[] arrayPoints) {
            searchCriterions.arrayPoints = arrayPoints;
            return this;
        }
        public FigureSearchCriterions build(){
            return searchCriterions;
        }
    }
}
