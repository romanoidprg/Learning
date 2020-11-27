package com.epam.jwd.strategy;

import com.epam.jwd.models.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum  EqualPointsStrategy implements FigurePropertyStrategy {

    INSTANCE;
        @Override
        public Logger getLogg() {
            return LogManager.getLogger(EqualPointsStrategy.class);
        }

        @Override
        public String getTriangleInfo(Figure triangle) {
            return triangle.getCoordInfo() + "  is not exist. There is at least two equal points";
        }

        @Override
        public String getLineInfo(Figure line) {
            return line.getCoordInfo() + "  isn't exist. There is two equal points";
        }

        @Override
        public String getSquareInfo(Figure square) {
            return square.getCoordInfo() + "  is not exist. There is at least two equal points";
        }


}
