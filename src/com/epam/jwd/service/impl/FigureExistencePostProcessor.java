package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.service.FigureProcessor;

public class FigureExistencePostProcessor implements FigureProcessor {
    @Override
    public Figure process(Figure figure) throws FigureNotExistException {
        if (figure == null) {
            throw new FigureNotExistException(FigureType.FIG_NOTEXIST_ORUNKNOWN_MSG);
        }

        Figure fig = figure;
        if (SimpleFigureFactory.figureCash.isEmpty()) {
            SimpleFigureFactory.figureCash.add(figure);
        } else {
            int i = 0;
            int indexOfExistFig = -1;
            do {
                if (figure.equals(SimpleFigureFactory.figureCash.get(i))) {
                    indexOfExistFig = i;
                    break;
                }
                i++;
            } while (i < SimpleFigureFactory.figureCash.size());
            if (indexOfExistFig == -1) {
                SimpleFigureFactory.figureCash.add(figure);
            } else {
                fig = SimpleFigureFactory.figureCash.get(indexOfExistFig);
            }
        }
        return fig;

    }
}
