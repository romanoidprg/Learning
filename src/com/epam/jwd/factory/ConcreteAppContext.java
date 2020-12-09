package com.epam.jwd.factory;

import com.epam.jwd.decorator.PostProcessFactory;
import com.epam.jwd.decorator.PreProcessFactory;
import com.epam.jwd.model.SimpleFigureFactory;

public class ConcreteAppContext implements AppContext{
    @Override
    public FigureFactory createFigureFactory() {
        return  new PostProcessFactory(new PreProcessFactory(SimpleFigureFactory.INSTANCE));
    }
}
