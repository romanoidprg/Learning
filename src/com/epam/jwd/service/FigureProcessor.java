package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;

public interface FigureProcessor {
    Figure process(Figure figure) throws FigureException;
}
