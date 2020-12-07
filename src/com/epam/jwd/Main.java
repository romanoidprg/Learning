package com.epam.jwd;

import com.epam.jwd.decorator.PostProcessFactory;
import com.epam.jwd.decorator.PreProcessFactory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Figure;

public class Main {

    public static void main(String[] args) throws FigureException {


        FigureFactory simpleFigureFactory = new PostProcessFactory(new PreProcessFactory(new SimpleFigureFactory()));


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

        Figure[] arrayLine = new Figure[0];
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

        System.out.println(arrayLine[0].hashCode() + "   " + arrayLine[2].hashCode());

    }

}
