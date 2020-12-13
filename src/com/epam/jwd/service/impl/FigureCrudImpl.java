package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigureCrud;

import java.util.Collection;
import java.util.Collections;

public class FigureCrudImpl implements FigureCrud {

    private Collection<Figure> storage;

    public FigureCrudImpl(Collection<Figure> storage) {
        this.storage = storage;
    }

    @Override
    public void create(Figure figure) {
        storage.add(figure);
    }

    @Override
    public void multiCreate(Collection<Figure> figureCollection) {
        storage.addAll(figureCollection);
    }

    @Override
    public void delete() {


    }

    @Override
    public void update() {

    }

    @Override
    public void find() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void findByCriterion() {

    }
}
