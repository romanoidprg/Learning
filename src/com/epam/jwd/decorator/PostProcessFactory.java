package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.SimpleFigureFactory;

public class PostProcessFactory extends FigureFactoryDecorator {

    public PostProcessFactory(FigureFactory f) {
        super(f);
    }

    @Override
    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint) throws FigureException {
        Figure figure = super.CreateFigure(figureType, arrayPoint);

        if (figure == null) {
            throw new FigureNotExistException(FigureType.FIG_NOTEXIST_ORUNKNOWN_MSG);
        }

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
                figure = SimpleFigureFactory.figureCash.get(indexOfExistFig);
            }
        }
        return figure;
    }
}
