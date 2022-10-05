/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class facilitates the handling of storing     *
*          of the data related to the graphs edge informati   *
* Date Created: October 10, 2018                              *
* Date Modified: October 27, 2018                             *
***************************************************************/

import java.util.*; 

public class LocationV{

    private String state; //state variable e.g. NSW 
    private double latitude; 
    private double longitude;
    
    /************************************************************
    * SUBMODULE: doCalc                                         *
    * IMPORT:int iD,String party,DSALinkedList list             *
    * EXPORT: double margin                                     *
    * Assertion: calculates margin for each seat                *
    *************************************************************/

    public LocationV (String inState, double inLat, double inLong)
    {
        setState(inState); //using setters to validate data before its actually constructed 
        setLatitude(inLat); 
        setLongitude(inLong);
    }

    //Accessors
    public String getState()
    {
        return state; 
    }

    public double getLatitude ()
    {
        return latitude; 
    }

    public double getLongitude()
    {
        return longitude; 
    }
    /************************************************************
    * SUBMODULE: toString                                       *
    * IMPORT: none                                              *
    * EXPORT: none                                              *
    * ASSERTION:prints out a string representation of object    *
    *************************************************************/
    public String toString()
    {
        String location;
        location = new String("STATE: " +state+ " LATITUDE: " +latitude+ " LONGITUDE: " +longitude);
        return location;
    }
    /*************************************************************
     * SUBMODULE: equals                                         *
     * IMPORT: theObject (Object)                                *
     * EXPORT: isequalto (boolean)                               *
     * ASSERTION: two locations are interchangeable              *
     *            if they have are equal                         *
     *                                                           *
     *************************************************************/
    public boolean equals (Object theObject)
    {
        boolean isequalto = false; 
        LocationV theLocation = null; 
        if(theObject instanceof LocationV)
        {
            theLocation = (LocationV)theObject; 
            if(state.equals(theLocation.getState()))
             if((Math.abs((latitude - (theLocation.getLatitude())))) < 0.01)
              if((Math.abs((longitude - (theLocation.getLongitude())))) < 0.01)
              isequalto = true; 
        }
        return isequalto; 
    }

    //MUTATORS 
    public void setLatitude(double inLatitude)
    {
            if((-90.00<=inLatitude) || (inLatitude >= 90.00)) //if its not within the range print an error message
            {
                latitude = inLatitude; 
            }
            else
            {
                throw new IllegalArgumentException("Invalid Latitude coordinate!"); 
            }
    }

    public void setState(String inState)
    {
        if(validateString(inState))
        {
            state = inState; 
        }
        else
        {
            throw new IllegalArgumentException("Invalid State Name");
        }
    }

    public void setLongitude(double inLongitude)
    {
        if((-180.00<=inLongitude) || (inLongitude >= 180.00)) 
        {
            longitude = inLongitude; 
        }
        else
        {
            throw new IllegalArgumentException("Invalid Longitude coordinate!"); 
        }
    }

    /***********************************************************
    * SUBMODULE: validateString                                *
    * IMPORT: word (String)                                    *
    * EXPORT: valid (boolean)                                  *
    * ASSERTION: validates if the string is not null           *
    ************************************************************/

    private boolean validateString (String word)
    {
        boolean valid = false; 
        if (word != null)
        {
            valid = true; 
        }
        return valid; 
    }


}
