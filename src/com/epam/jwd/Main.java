package com.epam.jwd;

import com.epam.jwd.model.FigureFabric;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.models.Line;
import com.epam.jwd.models.Point;
import com.epam.jwd.models.Square;
import com.epam.jwd.models.Figure;
import com.epam.jwd.models.Triangle;

public class Main {

    public static void main(String[] args) {

        FigureFabric plateFabric = new FigureFabric();

        Point[] arrayPoint = {new Point(0,0),
                              new Point(4,4),
                              new Point(5,5),
                              new Point(4,0)};

        Figure[] arrayLine = {plateFabric.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[0],arrayPoint[1]}),
                              plateFabric.CreateFigure(FigureType.LINE, new Point[]{arrayPoint[2],arrayPoint[3]})};



        Figure [] arrayTriangle = {plateFabric.CreateFigure(FigureType.TRIANGLE,
                                        new Point[]{arrayPoint[0],arrayPoint[1]}),
                                   plateFabric.CreateFigure(FigureType.TRIANGLE, new Point[]{arrayPoint[2],arrayPoint[3]})};

        Square[] arraySquare = {new Square(arrayPoint[0],arrayPoint[1],arrayPoint[2],arrayPoint[3])};

        int i = 0;
        do {
           arrayPoint[i].infoLogg();
           i++;
        } while (i<arrayPoint.length);

        for (Figure line: arrayLine){
            line.infoLogg();
        }

        for (Triangle triangle: arrayTriangle){
            triangle.infoLogg();
        }

        for (Square square: arraySquare){
            square.infoLogg();
        }

    }

}
