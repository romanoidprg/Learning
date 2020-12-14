package com.epam.jwd.service;

import com.epam.jwd.model.Figure;
import com.epam.jwd.service.impl.FigureSearchCriterions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface FigureCrud {
    void create(Figure figure);

    void multiCreate(Collection<Figure> figureCollection);

    void delete(int position);


    void update(int position, Figure figure);


    List find(Figure figure);

    Figure findById(int id);

    List findByCriterion(FigureSearchCriterions serchCriterions);
}
