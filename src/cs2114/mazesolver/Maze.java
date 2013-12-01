package cs2114.mazesolver;

import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * This is the maze class that implements the maze structure that will be
 * created for the solver
 *
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 25, 2013
 */
public class Maze
    implements IMaze
{

    private MazeCell[][] maze1;
    private int          size;
    private Location     end;
    private Location     start;


    // ----------------------------------------------------------
    /**
     * Create a new Maze object.
     *
     * @param size
     *            the size of the maze
     */
    public Maze(int size)
    {
        this.size = size;
        maze1 = new MazeCell[size][size];
        end = new Location(size - 1, size - 1);
        start = new Location(0, 0);

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                maze1[i][j] = MazeCell.UNEXPLORED;
            }
        }
    }


    /**
     * This method gets the cell that is selected
     *
     * @param location
     *            the location to obtain
     * @return cell that is selected
     */
    public MazeCell getCell(ILocation location)
    {
        // Checks within boundaries
        if (checkBounds(location))
        {
            return maze1[location.x()][location.y()];
        }
        return MazeCell.INVALID_CELL;

    }


    /**
     * This method checks bounds
     *
     * @param location
     *            to check for position in bounds
     * @return true if the cell is within the bounds of the maze
     */
    public boolean checkBounds(ILocation location)
    {
        // Check to see if the cell is inside the maze
        if (location.x() < size && location.y() < size && location.x() >= 0
            && location.y() >= 0)
        // check if its less than zero
        {
            return true;
        }
        return false;
    }


    /**
     * This gets the end location that is at the end of the maze
     *
     * @return end of the maze
     */
    public ILocation getGoalLocation()
    {
        // how to find the end of the maze

        return end;
    }


    /**
     * This method returns the start location of the maze
     *
     * @return start of the maze
     */
    public ILocation getStartLocation()
    {
        return start;
    }


    /**
     * This method sets the location for a cell
     *
     * @param location
     *            the location to set the cell at
     * @param cell
     *            the cell to be set to the location
     */
    public void setCell(ILocation location, MazeCell cell)
    {
        if (maze1[start.x()][start.y()] != MazeCell.WALL
            && maze1[end.x()][end.y()] != MazeCell.WALL
            && checkBounds(location))
        {
            maze1[location.x()][location.y()] = cell;
        }

    }


    /**
     * This method sets the end of the maze, which is the goal
     *
     * @param location
     *            the location of the goal
     */
    public void setGoalLocation(ILocation location)
    {
        end = (Location)location;
    }


    /**
     * This method sets the starting location of the maze
     *
     * @param location
     *            the starting location
     */
    public void setStartLocation(ILocation location)
    {
        start = (Location)location;

    }


    /**
     * This returns the size of the maze
     *
     * @return the size of the maze
     */
    public int size()
    {
        return size;
    }


    /**
     * Path Reset
     */
    public void resetPath()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (maze1[i][j] == MazeCell.CURRENT_PATH
                    || maze1[i][j] == MazeCell.FAILED_PATH)
                    maze1[i][j] = MazeCell.UNEXPLORED;
            }
        }
    }


    /**
     * This is the method that will solve the maze have the computer search
     * down, right, up, then left. if it can do either of those, it goes that
     * direction. it continues to do this and once it hits a dead end it pops
     * off the coordinates and continues to try to solve the maze.
     *
     * @return finalSolution the solution to the maze in reverse
     */
    public String solve()
    {
        resetPath();
        Stack<ILocation> solution = new Stack<ILocation>();
        solution.push(start);

        // this.setCell(position, maze[position.x()][position.y()]);

        while (!solution.isEmpty())
        {
            // Stack the solution
            ILocation position = solution.peek();

            this.setCell(position, MazeCell.CURRENT_PATH);
            if (position.equals(end))
            {
                String finalSolution = new String();
                while (!solution.empty())
                {
                    finalSolution = solution.pop().toString() + finalSolution;

                }
                return finalSolution;
            }

            if (this.getCell(position.south()) == MazeCell.UNEXPLORED)
            {
                solution.push(position.south());

            }
            else if (this.getCell(position.west()) == MazeCell.UNEXPLORED)
            {
                solution.push(position.west());

            }
            else if (this.getCell(position.north()) == MazeCell.UNEXPLORED)
            {
                solution.push(position.north());

            }
            else if (this.getCell(position.east()) == MazeCell.UNEXPLORED)
            {
                solution.push(position.east());

            }
            else
            {
                setCell(position, MazeCell.FAILED_PATH);
                solution.pop();
            }

        }

        return null;
    }

}
