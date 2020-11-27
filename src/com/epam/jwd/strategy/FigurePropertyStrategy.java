package com.epam.jwd.strategy;

import com.epam.jwd.models.Figure;
import org.apache.logging.log4j.Logger;

public interface FigurePropertyStrategy {

    public Logger getLogg();

    public String getLineInfo(Figure figure);

    public String getTriangleInfo(Figure figure);

    public String getSquareInfo(Figure figure);

    public String getMultiAngleInfo(Figure figure);

    public String toString();

}
