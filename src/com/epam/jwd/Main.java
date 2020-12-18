package com.epam.jwd;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.AppContext;
import com.epam.jwd.factory.ConcreteAppContext;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.impl.FigureCrudImpl;
import com.epam.jwd.service.impl.FigureSearchCriterions;
import com.epam.jwd.strategy.ExistStrategy;

import java.util.*;

public class Main {

    public static void main(String[] args) throws FigureException {

        AppContext appContext = new ConcreteAppContext();

        FigureFactory simpleFigureFactory = appContext.createFigureFactory();

        Point[] arrayPoint = {
                new Point(0, 0),
                new Point(4, 1),
                new Point(5, 5),
                new Point(4, 0),
                new Point(5, 6),
                new Point(4, 6)
        };

        Point[] arrayPointMAF = {
                new Point(1, 0),
                new Point(26, 1),
                new Point(5, 5),
                new Point(3, 13),
                new Point(5, 6)
        };

        FigureCrudImpl storage = new FigureCrudImpl(new ArrayList<>());

        try {
            storage.create(simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[0], arrayPoint[1]}));

            storage.multiCreate(
                    Arrays.asList(
                            new Figure[]{
                                    simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[0], arrayPoint[1]}),
                                    simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[1], arrayPoint[2]}),
                                    simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[0], arrayPoint[1]}),
                                    simpleFigureFactory.CreateFigure(FigureType.TRIANGLE, new Point[]{arrayPoint[0], arrayPoint[1], arrayPoint[3]}),
                                    simpleFigureFactory.CreateFigure(FigureType.TRIANGLE, new Point[]{arrayPoint[2], arrayPoint[3], arrayPoint[3]}),
                                    simpleFigureFactory.CreateFigure(FigureType.SQUARE, new Point[]{arrayPoint[0], arrayPoint[1], arrayPoint[2], arrayPoint[3]}),
                                    simpleFigureFactory.CreateFigure(FigureType.SQUARE, new Point[]{arrayPoint[2], arrayPoint[3], arrayPoint[2], arrayPoint[3]}),
                                    simpleFigureFactory.CreateFigure(FigureType.MULTI_ANGLE_FIGURE, arrayPoint),
                                    simpleFigureFactory.CreateFigure(FigureType.MULTI_ANGLE_FIGURE, arrayPointMAF)
                            }
                    )
            );
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }

        storage.delete(2);

        try {
            storage.update(2, simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[1], arrayPoint[2]}));
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }


        for (Figure f : storage.findByCriterion(new FigureSearchCriterions())) {
            f.infoLogg();
        }

        for (Figure f : storage.findByCriterion(
                new FigureSearchCriterions.CriterionBuilder()
                        .withArrayPoints(new Point[]{arrayPoint[0], arrayPoint[1]}).build())
        ) {
            f.infoLogg();
        }

        for (Figure f : storage.findByCriterion(
                new FigureSearchCriterions.CriterionBuilder()
                        .withFigureStrategy(ExistStrategy.getInstance())
                        .withFigureType(FigureType.TRIANGLE).build())
        ) {
            f.infoLogg();
        }






/*        Figure[] arrayLine = new Figure[0];
        try {
            arrayLine = new Figure[]{
                    simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[0], arrayPoint[1]}),
                    simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[1], arrayPoint[2]}),
                    simpleFigureFactory.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[0], arrayPoint[1]})
            };
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }


        Figure[] arrayTriangle = new Figure[0];
        try {
            arrayTriangle = new Figure[]{
                    simpleFigureFactory.CreateFigure(FigureType.TRIANGLE, new Point[]{arrayPoint[0], arrayPoint[1], arrayPoint[3]}),
                    simpleFigureFactory.CreateFigure(FigureType.TRIANGLE, new Point[]{arrayPoint[2], arrayPoint[3], arrayPoint[3]})
            };
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }

        Figure[] arraySquare = new Figure[0];
        try {
            arraySquare = new Figure[]{
                    simpleFigureFactory.CreateFigure(FigureType.SQUARE,
                            new Point[]{arrayPoint[0], arrayPoint[1], arrayPoint[2], arrayPoint[3]})};
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }

        Figure[] arrayMAF = new Figure[0];
        try {
            arrayMAF = new Figure[]{
                    simpleFigureFactory.CreateFigure(FigureType.MULTI_ANGLE_FIGURE, arrayPoint),
                    simpleFigureFactory.CreateFigure(FigureType.MULTI_ANGLE_FIGURE, arrayPointMAF),
            };
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }


        int i = 0;
        do {
            arrayPoint[i].infoLogg();
            i++;
        } while (i < arrayPoint.length);

        for (Figure line : arrayLine) {
            line.infoLogg();
        }

        for (Figure triangle : arrayTriangle) {
            triangle.infoLogg();
        }

        for (Figure square : arraySquare) {
            square.infoLogg();
        }

        for (Figure mAF : arrayMAF) {
            mAF.infoLogg();
        }

        System.out.println(arrayLine[0].hashCode() + "   " + arrayLine[2].hashCode());*/

    }

}
