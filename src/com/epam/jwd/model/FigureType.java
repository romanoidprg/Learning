package com.epam.jwd.model;

import com.epam.jwd.models.Figure;
import com.epam.jwd.models.Line;
import com.epam.jwd.models.Point;

public enum FigureType {
    LINE(pointA, pointB),
    TRIANGLE,
    SQUARE;
    private Point pointA, pointB;
    FigureType(Point pointA, Point pointB){
        this.pointA = pointA;
        this.pointB = pointB;
    }

}
