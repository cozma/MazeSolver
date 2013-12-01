package cs2114.mazesolver;

import junit.framework.TestCase;

// -------------------------------------------------------------------------
/**
 * This is the test class for the Location class
 *
 * @author Dagmawi Yeshiwas PID: dagmawi
 * @version Feb 25, 2013
 */
public class LocationTest
    extends TestCase
{

    private Location start;


    // -------------------------------------------------------------------------

    /**
     * This methods tests the toString method for the Location class
     */
    public void testToString()
    {
        start = new Location(0, 0);
        assertEquals("(0,0)", start.toString());
    }


    /**
     * This method tests the directional outputs of the Locations class
     */
    public void testDirections()
    {
        start = new Location(0, 0);
        start.east();
        assertEquals("(1,0)", start.east().toString());
        assertEquals("(0,-1)", start.north().toString());
        assertEquals("(0,1)", start.south().toString());
        assertEquals("(-1,0)", start.west().toString());
    }


    /**
     * This methods tests the equals method that was written in the location
     * class
     */
    public void testEquals()
    {
        start = new Location(0, 0);
        Location east = new Location(0, 0);
        assertEquals(start, east);
        east = (Location)start.east();
        assertFalse(start.equals(east));

    }


    /**
     * This method tests for the output of the x and y values of a location
     */
    public void testXYLocation()
    {
        start = new Location(0, 0);
        int x = 0;
        int y = 0;
        assertEquals(x, start.x());
        assertEquals(y, start.y());
    }

}
