package com.epam.jwd.strategy;

import com.epam.jwd.models.Line;
import com.epam.jwd.models.Square;
import com.epam.jwd.models.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum  EqualPointsStrategy implements FigurePropertyStrategy {

    INSTANCE;
        @Override
        public Logger getLogg() {
            return LogManager.getLogger(EqualPointsStrategy.class);
        }

        @Override
        public String getTriangleInfo(Triangle triangle) {
            return triangle.getCoordInfo() + "  is not exist. There is at least two equal points";
        }

        @Override
        public String getLineInfo(Line line) {
            return line.getCoordInfo() + "  isn't exist. There is two equal points";
        }

        @Override
        public String getSquareInfo(Square square) {
            return square.getCoordInfo() + "  is not exist. There is at least two equal points";
        }


}
