package com.epam.jwd;

import com.epam.jwd.models.Line;
import com.epam.jwd.models.Point;
import com.epam.jwd.models.Square;
import com.epam.jwd.models.Triangle;

public class Main {

    public static void main(String[] args) {

        Point[] arrayPoint = {new Point(0,0),
                              new Point(4,4),
                              new Point(5,5),
                              new Point(4,0)};

        Line[] arrayLine = {new Line(arrayPoint[0], arrayPoint[1]),
                            new Line(arrayPoint[1],arrayPoint[2])};

        Triangle[] arrayTriangle = {new Triangle(arrayPoint[0],arrayPoint[1],arrayPoint[2]),
                                    new Triangle(arrayPoint[0],arrayPoint[1],arrayPoint[3])};

        Square[] arraySquare = {new Square(arrayPoint[0],arrayPoint[1],arrayPoint[2],arrayPoint[3])};

        int i = 0;
        do {
           arrayPoint[i].infoLogg();
           i++;
        } while (i<arrayPoint.length);

        for (Line line: arrayLine){
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
