package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureNotExistException {
        if (figure == null) {
            throw new FigureNotExistException("Figure doesn't exist or you declared unknown figure.");
        }
        return figure;
    }
}
