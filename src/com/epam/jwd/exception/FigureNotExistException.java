package com.epam.jwd.exception;

import com.epam.jwd.exception.FigureException;

public class FigureNotExistException extends FigureException {
    public FigureNotExistException(String message) {
        super(message);
    }
}
