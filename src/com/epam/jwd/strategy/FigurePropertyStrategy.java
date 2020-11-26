package com.epam.jwd.strategy;

import com.epam.jwd.models.Line;
import com.epam.jwd.models.Square;
import com.epam.jwd.models.Triangle;

import org.apache.logging.log4j.Logger;

public interface FigurePropertyStrategy {

    public Logger getLogg();

    public String getLineInfo(Line line);

    public String getTriangleInfo(Triangle triangle);

    public String getSquareInfo(Square square);

    public String toString();

}
