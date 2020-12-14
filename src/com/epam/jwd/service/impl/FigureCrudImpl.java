package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigureCrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud {

    private List<Figure> storage;

    public FigureCrudImpl(List<Figure> storage) {
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
    public void delete(int position) {
        storage.remove(position);

    }

    @Override
    public void update(int position, Figure figure) {
        storage.set(position, figure);
    }

    @Override
    public List find(Figure figure) {
        return storage.stream().filter(figure::equals).collect(Collectors.toList());
    }

    @Override
    public Figure findById(int id) {
        return storage.get(id);
    }

    @Override
    public List<Figure> findByCriterion(FigureSearchCriterions searchCriterions) {
        return (storage.stream().
                filter(figure -> (searchCriterions.getFigureType() == null) ? figure != null : figure.getFigureType() == searchCriterions.getFigureType()).
                filter(figure -> (searchCriterions.getFigureStrategy() == null) ? figure != null : figure.getFigurePropertyStrategy() == searchCriterions.getFigureStrategy()).
                filter(figure -> (searchCriterions.getArrayPoints() == null) ? figure.getFigureType() != null : Arrays.asList(figure.getFigurePointArray()).containsAll(Arrays.asList(searchCriterions.getArrayPoints()))).
                collect(Collectors.toList()));
    }
}
