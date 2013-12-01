package cs2114.mazesolver;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * This is the test class for the Maze class
 *
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 25, 2013
 */
public class MazeTest
    extends TestCase
{

    private Maze     maze;
    private int      size;
    private Location end;
    private Location start;
    private Location south;

    // Maze 2--------------------------------------------------
    private Maze     maze2;
    private int      size2;
    private Location south2;
    private Location east2;

    // Maze 3--------------------------------------------------
    private Maze     maze3;
    private int      size3;
    private Location south3;

    // Maze 4--------------------------------------------------
    private Maze     maze4;
    private int      size4;
    private Location east4;


    /**
     * This is the setup method to test the Maze class
     */
    public void setUp()
    {
        size = 4;
        maze = new Maze(size);
        start = new Location(0, 0);
        end = new Location(size - 1, size - 1);
        south = new Location(1, 0);
        maze.setCell(south, MazeCell.WALL);

        // Maze 2-------------------------------------------------
        size2 = 2;
        maze2 = new Maze(size2);
        south2 = new Location(1, 0);
        east2 = new Location(0, 1);
        maze2.setCell(south2, MazeCell.WALL);
        maze2.setCell(east2, MazeCell.WALL);

    }


// -------------------------------------------------------------------------

    /**
     * This test the method to retreive the selected cell for the Maze class
     */
    public void testGetCell()
    {
        Location outBounds = new Location(5, 0);

        assertEquals(MazeCell.UNEXPLORED, maze.getCell(start));
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(outBounds));
    }


    /**
     * This method tests the get location methods of the maze class
     */
    public void testGetLocations()
    {
        assertEquals(end, maze.getGoalLocation());
        assertEquals(start, maze.getStartLocation());
    }


    /**
     * This method tests the method that returns the size for the Maze class
     */
    public void testSize()
    {
        int x = 4;
        assertEquals(x, maze.size());
    }


    /**
     * This method tests the set location methods of the maze class
     */
    public void testSetLocations()
    {
        maze.setGoalLocation(end);
        assertEquals(end, maze.getGoalLocation());
        maze.setStartLocation(start);
        assertEquals(start, maze.getStartLocation());

    }


    /**
     * This method tests the solve method for the maze class
     */
    public void testSolve()
    {
        assertEquals(
            "(0,0)(0,1)(0,2)(0,3)(1,3)(1,2)(1,1)(2,1)(2,2)(2,3)(3,3)",
            maze.solve());

        assertEquals(null, maze2.solve());

        // Maze 3--------------------------------------------------
        // This tests the condition for east movement
        size3 = 2;
        maze3 = new Maze(size3);
        south3 = new Location(1, 1);
        maze.setCell(south3, MazeCell.WALL);

        assertEquals("(0,0)(0,1)(1,1)", maze3.solve());

        // Maze 4--------------------------------------------------
        size4 = 2;
        maze4 = new Maze(size4);
        east4 = new Location(0, 1);
        maze4.setCell(east4, MazeCell.WALL);

        assertEquals("(0,0)(1,0)(1,1)", maze4.solve());

        //assertEquals(null, maze4.solve());

        // Maze 5----------------------------------------------------
        // Tests west
        int size5 = 4;
        Maze maze5 = new Maze(size5);
        Location start5 = new Location(0, 0);
        Location end5 = new Location(size - 1, size - 1);
        maze5.setStartLocation(start5);
        maze5.setGoalLocation(end5);
        Location block = new Location(1, 0);
        Location block2 = new Location(2, 0);
        Location block3 = new Location(3, 0);
        Location block4 = new Location(3, 1);
        Location block5 = new Location(3, 2);
        Location block6 = new Location(2, 1);
        Location block7 = new Location(0, 2);
        Location block8 = new Location(0, 3);
        Location block9 = new Location(1, 3);
        maze5.setCell(block, MazeCell.WALL);
        maze5.setCell(block2, MazeCell.WALL);
        maze5.setCell(block3, MazeCell.WALL);
        maze5.setCell(block4, MazeCell.WALL);
        maze5.setCell(block5, MazeCell.WALL);
        maze5.setCell(block6, MazeCell.WALL);
        maze5.setCell(block7, MazeCell.WALL);
        maze5.setCell(block8, MazeCell.WALL);
        maze5.setCell(block9, MazeCell.WALL);
        assertEquals("(0,0)(0,1)(1,1)(1,2)(2,2)(2,3)(3,3)", maze5.solve());

        maze.setGoalLocation(start);
        assertEquals("(0,0)", maze.solve());

    }

}
