package cs2114.mazesolver;

import sofia.graphics.Color;
import sofia.app.ShapeScreen;
import sofia.graphics.RectangleShape;
import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * This class controls the screen for the Maze Solver app
 *
 * @author Dagmawi Yeshiwas dagmawi
 * @version 2013.03.17
 */
public class MazeSolverScreen
    extends ShapeScreen
{
    // ~ Fields ................................................................

    private Maze maze;

    private boolean drawButtonSelected;
    private boolean eraseButtonSelected;
    private boolean startButtonSelected;
    private boolean goalButtonSelected;


    // ~ Public methods ........................................................
    /**
     * This initializes a new maze for the solver
     */
    public void initialize()
    {
        // Initialized the maze
        int mazeSize = 8;
        maze = new Maze(mazeSize);

        // Create tiles
        float minDim = Math.min(getShapeView().getWidth(), getShapeView().getHeight());
        float x = (minDim / 8);

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                RectangleShape tile =
                    new RectangleShape(j * x, i * x, (j + 1) * x, (i + 1) * x);
                this.add(tile);
                tile.setColor(Color.black);
            }
        }
    }


    // ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * This method returns the maze that was initialized
     *
     * @return the maze
     */
    public IMaze getMaze()
    {
        return maze;
    }


    /**
     * This method reacts to the user touch the screen down
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coodinate
     * @return tile that was touched down
     */
    public RectangleShape onTouchDown(float x, float y)
    {
        RectangleShape tile =
            getShapes().locatedAt(x, y).withClass(RectangleShape.class).front();

        return tile;


    }


    /**
     * This method reacts to the user moving thier finger on the screen
     *
     * @param x
     *            the x coordinate
     * @param y
     *            the y coodinate
     * @return tile that was touched while the user moved on screen
     */
    public RectangleShape onTouchMove(float x, float y)
    {
        // Reacts
        RectangleShape tile =
            getShapes().locatedAt(x, y).withClass(RectangleShape.class).front();
        return tile;





    }

    /**
     * This tells the application that it's in the drawing walls mode
     * @return true if the wall click button is pressed
     */
    public boolean drawWalls() {
        //
        return true;

    }


}
