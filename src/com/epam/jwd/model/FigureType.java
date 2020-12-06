package com.epam.jwd.model;

public enum FigureType {

    LINE,
    TRIANGLE,
    SQUARE,
    MULTI_ANGLE_FIGURE;

    public static final String LINE_EQUAL_POINTS_INFO = "  isn't valid. There is two equal points";
    public static final String MultiAng_EQUAL_POINTS_INFO = "  isn't valid. There is at least two equal points";
    public static final String ONE_POINT_LINE_MSG = "The line with 1 point doesn't exist";
    public static final String TWO_POINT_RECT_MSG = "The triangle with less than 3 points doesn't exist";
    public static final String TREE_POINT_SQUARE_MSG = "The square with less than 4 points doesn't exist";
    public static final String TREE_POINT_MAF_MSG = "You are using less than 4 points, so you must declare another type of figure";
    public static final String FIG_NOTEXIST_ORUNKNOWN_MSG = "Figure doesn't exist or you declared unknown figure.";
    public static final String POINTS_ON_SAME_LINE_MSG = "  isn't valid. Some three points are on the same line";
    public static final String RECT_NOT_SQUARE_MSG = "  isn't valid. THis is rectangle but not square";
}
