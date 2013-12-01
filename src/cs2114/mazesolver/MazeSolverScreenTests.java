package cs2114.mazesolver;

import android.widget.TextView;
import android.widget.Button;
import android.widget.CompoundButton;
import sofia.graphics.ShapeView;

//-------------------------------------------------------------------------
/**
 *  This class tests the Maze Solver class
 *
 *  @author  Dagmawi Yeshiwas dagmawi
 *  @version 2013.03.17
*/
public class MazeSolverScreenTests
    extends student.AndroidTestCase<MazeSolverScreen>
{
    //~ Fields ................................................................

    // References to the widgets that you have in your layout. They
    // will be automatically filled in by the test class before your
    // tests run.
    private ShapeView shapeView;
    private Button drawWalls;
    private Button eraseWalls;
    private Button setStart;
    private Button setGoal;
    private Button solve;
    private TextView infoLabel;

    // This field will store the pixel width/height of a cell in the maze.
    private int cellSize;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public MazeSolverScreenTests()
    {
        super(MazeSolverScreen.class);
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Initializes the text fixtures.
     */
    public void setUp()
    {
        float viewSize =
            Math.min(getScreen().getWidth(), getScreen().getHeight());

        // TODO set cellSize to be the viewSize divided by the size of your
        // maze
        //cellSize = ...

        // TODO Add any other setup code that you need.
    }


    // TODO Add your test methods here.


    //~ Private methods .......................................................

    // ----------------------------------------------------------
    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates moving the finger instantaneously to the middle of the
     * specified cell in the maze.
     */
    private void touchMoveCell(int x, int y)
    {
        touchMove((x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates clicking the middle of the specified cell in the maze. This is
     * equivalent to calling: touchDownCell(x, y); touchUp();
     */
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }
}
