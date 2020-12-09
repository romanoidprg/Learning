package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureProcessor;
import com.epam.jwd.strategy.EqualPointsStrategy;
import com.epam.jwd.strategy.ExistStrategy;
import com.epam.jwd.strategy.NotSquareStrategy;
import com.epam.jwd.strategy.SameLineStrategy;

public enum FigureCheckAndSetStrategyPreProcessor implements FigureProcessor {

    INSTANCE;

    @Override
    public Figure process(Figure figure) {
        figure.setFigurePropertyStrategy(ExistStrategy.getInstance());
        return checkAndSetNotSquareStrategy(checkAndSetSameLineStrategy(checkAndSetEqualPointsStrategy(figure)));
    }

    private Figure checkAndSetEqualPointsStrategy(Figure f) {
        Point[] fPA = f.getFigurePointArray();

        for (int i = 0; i < fPA.length; i++) {
            for (int j = i + 1; j < fPA.length; j++) {
                if (fPA[i].samePoint(fPA[j])) {
                    f.setFigurePropertyStrategy(EqualPointsStrategy.INSTANCE);
                    break;
                }
            }
        }
        return f;
    }

    private Figure checkAndSetSameLineStrategy(Figure f) {
        if (f.getFigureType() != FigureType.LINE) {

            Point[] fPA = f.getFigurePointArray();
            for (int i = 0; i < fPA.length; i++) {
                if (i < fPA.length - 2) {
                    if (fPA[i].IsOnSameLine(fPA[i + 1], fPA[i + 2])) {
                        f.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        break;
                    }
                } else if (i == fPA.length - 2) {
                    if (fPA[i].IsOnSameLine(fPA[i + 1], fPA[0])) {
                        f.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        break;
                    }
                } else if (i == fPA.length - 1) {
                    if (fPA[i].IsOnSameLine(fPA[0], fPA[1])) {
                        f.setFigurePropertyStrategy(SameLineStrategy.getInstance());
                        break;
                    }
                }
            }
        }
        return f;
    }

    private Figure checkAndSetNotSquareStrategy(Figure f) {
        Point[] fPA = f.getFigurePointArray();
        if ((f.getFigureType() == FigureType.SQUARE)
                && !(fPA[0].lengthToPoint(fPA[1]) == fPA[1].lengthToPoint(fPA[2])
                && fPA[1].lengthToPoint(fPA[2]) == fPA[2].lengthToPoint(fPA[3])
                && fPA[2].lengthToPoint(fPA[3]) == fPA[3].lengthToPoint(fPA[0])
                && fPA[0].lengthToPoint(fPA[2]) == fPA[1].lengthToPoint(fPA[3]))) {
            f.setFigurePropertyStrategy(NotSquareStrategy.getInstance());
        }
        return f;
    }
}
