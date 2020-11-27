package com.epam.jwd.strategy;

import com.epam.jwd.models.Figure;
import org.apache.logging.log4j.Logger;

public interface FigurePropertyStrategy {

    public Logger getLogg();

    public String getLineInfo(Figure line);

    public String getTriangleInfo(Figure triangle);

    public String getSquareInfo(Figure square);

    public String toString();

}
