/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the State Objects using         *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: October 5, 2018                               *
* Date Modified: October 8, 2018                              *
***************************************************************/
import java.util.*;
import java.io.*; 

public class State
{
    //classfields 
    private String stateAb; 
    private int divisionId; 
    private String divisionNm; 
    private int pollingId;
    private String pollingPlace; 
    private int candidateId; 
    private String surname; 
    private String givenNm; 
    private int ballotP;
    private char elected; 
    private char hElected; 
    private String partyAb; 
    private String partyNm; 
    private int ordVotes; 
    private double swing; 

 /***********************************************************
* ALTERNATE CONSTRUCTOR: State                              *
* IMPORT:  inStateAb (String), inDivisionId (int)           *
*          inDivisionNm (String), inPollingId (int)         *
*          inPollingPlace (String), inCandidateID (int),    *
*          inSurname(String), inGivenNm (String),           *
*          inBallotP(int),inElected (char),inHElected(char),*
*          inPartyAb (String), inPartyNm (String),          *
*          inOrdVotes (int), inSwing (double)               *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/
public State (String inStateAb, int inDivisionId, String inDivisionNm, int inPollingId, String inPollingPlace, int inCandidateID, String inSurname, 
              String inGivenNm, int inBallotP, char inElected, char inHElected, String inPartyAb, String inPartyNm, int inOrdVotes, double inSwing)
{
    setState(inStateAb);  //use mutators to validate data 
    setDivisionId(inDivisionId); //to ensure there are no invalid inputs 
    setDivisionNm(inDivisionNm); 
    setPollingId(inPollingId); 
    setPollingPlace(inPollingPlace); 
    setCandID(inCandidateID); 
    setSurname(inSurname); 
    setName(inGivenNm); 
    setBPosition(inBallotP); 
    setElected(inElected); 
    setHElected(inHElected); 
    setPartyAb(inPartyAb); 
    setParty(inPartyNm); 
    setVotes(inOrdVotes); 
    setSwing(inSwing);               
}

//ACCESSORS

public String getState()
{
    return stateAb; 
}

public int getDivID ()
{
    return divisionId; 
}

public String getDivNm()
{
    return divisionNm; 
}

public int getPolID()       //GETTERS
{
    return pollingId; 
}

public String getPollingPl()
{
    return pollingPlace; 
}

public int getCand ()
{
    return candidateId; 
}

public String getSurname()
{
    return surname; 
}

public String getName()
{
    return givenNm; 
}

public int getballotP()
{
    return ballotP; 
}

public char getElected()
{
    return elected; 
}

public char getHElected()
{
    return hElected; 
}

public String getPartyAb()
{
    return partyAb; 
}

public String getParty()
{
    return partyNm; 
}

public int getVotes()
{
    return ordVotes; 
}

public double getSwing()
{
    return swing; 
}

/************************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/
public String toString()
{
 String stateString;
 stateString = new String ("STATE: " +stateAb+ " DIVISION ID: " +divisionId+ " DIVISION NAME: "
                            +divisionNm+ " POLLING ID: " +pollingId+ " POLLING PLACE: " +pollingPlace+
                            " CANDIDATE ID: " +candidateId+ " SURNAME: " +surname+ " NAME: " +givenNm+ 
                            " BALLOT POSITION: " +ballotP+ " ELECTED: " +elected+ " HISTORY ELECTED: " +hElected+
                            " PARTY: " +partyNm+ " ORDINARY VOTES: " +ordVotes+ " SWING: " +swing);  
 return stateString;
}

/*************************************************************
 * SUBMODULE: equals                                         *
 * IMPORT: theObject (Object)                                *
 * EXPORT: isequalto (boolean)                               *
 * ASSERTION: two states are interchangeable                 *
 *            if they have are equal                         *
 *                                                           *
 *************************************************************/
public boolean equals (Object theObject)
{
    boolean isequalto = false; 
    State theState = null; 
    if(theObject instanceof State)
    {
        theState = (State)theObject; 
        if(stateAb.equals(theState.getName()))
         if(divisionId == theState.getDivID())
          if(divisionNm.equals(theState.getDivNm()))
           if(pollingId == theState.getPolID())
            if(pollingPlace.equals(theState.getPollingPl()))
             if(candidateId == theState.getCand())
              if(surname.equals(theState.getSurname()))
               if(givenNm.equals(theState.getName()))
                if(ballotP == theState.getballotP())
                 if(elected == theState.getElected())
                  if(hElected == theState.getHElected())
                   if(partyAb.equals(theState.getPartyAb()))
                    if(partyNm.equals(theState.getParty()))
                     if(ordVotes == theState.getVotes())
                      if(Math.abs((swing - (theState.getSwing()))) < 0.01) 
                      //using tolerance level to compare a double
                            isequalto = true; 
    }
        return isequalto; 
}

//MUTATORS 
public void setState(String inState)
{
    if(validateString(inState))
    {
        stateAb = inState; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid State Abreviation"); 
    }
}

public void setDivisionId(int inDivisionId)
{
    if(inDivisionId>0)
    {
        divisionId = inDivisionId; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Division ID: Less than 0!");
        //throws exception if division is less than 0
    }
}

public void setDivisionNm(String inDivisionNm)
{
    if(validateString(inDivisionNm))
    {
        divisionNm = inDivisionNm; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Division Name");
    }
}

public void setPollingId(int inPollingId)
{
    if(inPollingId>0) 
    {
        pollingId = inPollingId; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Polling ID: Less than 0!"); 
    }
}

public void setPollingPlace(String inPollingPlace)
{
    if(validateString(inPollingPlace))
    {
        pollingPlace = inPollingPlace; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Polling Place"); 
    }
}

public void setCandID(int inCandidateID)
{
    if(inCandidateID>0)
    {
        candidateId = inCandidateID; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Candidate ID: Less than 0");
    }
}

public void setSurname(String inSurname)
{
    if(validateString(inSurname))
    {
        surname = inSurname; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Surname"); 
    }
}

public void setName(String inName)
{
    if(validateString(inName))
    {
        givenNm = inName; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Name"); 
    }
}

public void setBPosition(int inPosition)
{
    if(inPosition >0)
    {
        ballotP = inPosition; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Ballot Position: Less than 0");
    }
}

public void setElected(char inElec)
{
    if((inElec == 'N') || (inElec == 'Y'))
    {
        elected = inElec; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Election Choice"); 
    }
}

public void setHElected(char inElec)
{
    if((inElec == 'N') || (inElec == 'Y'))
    {
        hElected = inElec; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Election Choice of History"); 
    }
}

public void setPartyAb(String inPartyAb)
{
    if(validateString(inPartyAb))
    {
        partyAb = inPartyAb; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Party Abbreviation"); 
    }
}

public void setParty(String inParty)
{
    if(validateString(inParty))
    {
        partyNm = inParty; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Party Name"); 
    }
}

public void setVotes(int inVotes)
{
    if(inVotes>=0)
    {
        ordVotes = inVotes; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Votes"); 
    }
}

public void setSwing(double inSwing)
{
        swing = inSwing; //how do you validate swing??
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