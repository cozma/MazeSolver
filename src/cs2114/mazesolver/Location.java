package cs2114.mazesolver;

// -------------------------------------------------------------------------
/**
 * This is the Location class. It will implement the ILocation interface to give
 * positions of things in the maze.
 *
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 20, 2013
 */
public class Location
    implements ILocation
{

    private int x;
    private int y;


    // ----------------------------------------------------------
    /**
     * Constructor to make a location for an object
     *
     * @param x
     *            the east west directional path of the object
     * @param y
     *            the north south directional path of the object
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     * overwritten version of equals method
     *
     * @param thing
     *            the object to compare
     * @return true if the object passed to it is the same location with the
     *         same x- and y- coordinates
     */
    public boolean equals(Object thing)
    {
        // boolean input = super.equals(thing);
        if (thing.equals(this.x()) && thing.equals(this.y()))
        {
            return true;
        }
        return false;
    }


    /**
     * overwritten toString method
     *
     * @return returns the x and y coordinates
     */
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }


    /**
     * This is how the maze solution will turn east
     *
     * @return east the new location to the east of the given location
     */
    public ILocation east()
    {
        Location east = new Location(x + 1, y);
        return east;
    }


    /**
     * This is how the maze solution will turn north
     *
     * @return north the new location to the north of the given location
     */
    public ILocation north()
    {
        Location north = new Location(x, y - 1);
        return north;
    }


    /**
     * This is how the maze solution will turn south
     *
     * @return south the new location to the south of the given location
     */
    public ILocation south()
    {
        Location south = new Location(x, y + 1);
        return south;
    }


    /**
     * This is how the maze solution will turn west
     *
     * @return west the new location to the west of the given location
     */
    public ILocation west()
    {
        Location west = new Location(x - 1, y);
        return west;
    }


    /**
     * This method returns the x value of the location
     *
     * @return x as the horizontal location
     */
    public int x()
    {
        return x;
    }


    /**
     * This method return the y value of the location
     *
     * @return y as the vertical location
     */
    public int y()
    {
        return y;
    }

}
