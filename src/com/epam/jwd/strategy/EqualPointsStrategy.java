package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum  EqualPointsStrategy implements FigurePropertyStrategy {

    INSTANCE;
        @Override
        public Logger getLogg() {
            return LogManager.getLogger(EqualPointsStrategy.class);
        }

        @Override
        public String getTriangleInfo(Figure figure) {
            return figure.getCoordInfo() + "  is not exist. There is at least two equal points";
        }

        @Override
        public String getLineInfo(Figure figure) {
            return figure.getCoordInfo() + "  isn't exist. There is two equal points";
        }

        @Override
        public String getSquareInfo(Figure figure) {
            return figure.getCoordInfo() + "  is not exist. There is at least two equal points";
        }

        @Override
        public String getMultiAngleInfo(Figure figure) {
            return figure.getCoordInfo() + "  is not exist. There is at least two equal points";
        }
}
