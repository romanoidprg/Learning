package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import org.apache.logging.log4j.Logger;

public interface FigurePropertyStrategy {

    Logger getLogg();

    String getInfo(Figure figure);
}
