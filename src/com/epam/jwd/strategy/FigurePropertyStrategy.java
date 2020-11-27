package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import org.apache.logging.log4j.Logger;

public interface FigurePropertyStrategy {

     Logger getLogg();

     String getLineInfo(Figure figure);

     String getTriangleInfo(Figure figure);

     String getSquareInfo(Figure figure);

     String getMultiAngleInfo(Figure figure);

}
