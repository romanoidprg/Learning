package com.epam.jwd.model;

import com.epam.jwd.models.Figure;
import com.epam.jwd.models.Line;
import com.epam.jwd.models.Point;

public class FigureFabric {
    public Figure CreateFigure(FigureType figureType){
        switch (figureType){
            case LINE: return new Line();
        }
    }
}
