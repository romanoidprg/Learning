package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Storage;
import com.epam.jwd.service.FigureCrud;

import java.util.ArrayList;

public class FigureCrudImpl implements FigureCrud {

    private Storage storage;

    FigureCrudImpl(Storage storage){
        this.storage = storage;
    }

    @Override
    public void create(Figure figure) {

    }

    @Override
    public void multiCreate() {

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
