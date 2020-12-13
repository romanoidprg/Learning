package com.epam.jwd.service;

import com.epam.jwd.model.Figure;

import java.util.Collection;

public interface FigureCrud {
    void create(Figure figure);
    void multiCreate(Collection<Figure> figureCollection);
    void delete();
    void update();
    void find();
    void findById();
    void findByCriterion();

}
