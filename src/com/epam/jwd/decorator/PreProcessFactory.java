package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;


public class PreProcessFactory extends FigureFactoryDecorator {

    public PreProcessFactory(FigureFactory f){
        super(f);
    }

    @Override
    public Figure CreateFigure(FigureType figureType, Point[] arrayPoint) throws FigureException {
        switch (figureType) {
            case LINE:
                if (arrayPoint.length < 2) {
                    throw new FigureNotExistException(FigureType.ONE_POINT_LINE_MSG);
                }
                break;

            case TRIANGLE:
                if (arrayPoint.length < 3) {
                    throw new FigureNotExistException(FigureType.TWO_POINT_RECT_MSG);
                }
                break;

            case SQUARE:
                if (arrayPoint.length < 4) {
                    throw new FigureNotExistException(FigureType.TREE_POINT_SQUARE_MSG);
                }
                break;

            case MULTI_ANGLE_FIGURE:
                if (arrayPoint.length < 4) {
                    throw new FigureNotExistException(FigureType.TREE_POINT_MAF_MSG);
                }
                break;
            default:
                throw new FigureNotExistException(FigureType.UNDEF_FIG_MSG);
        }

        return super.CreateFigure(figureType, arrayPoint);
    }
}
