/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the Candidates Objects using    *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: October 5, 2018                               *
* Date Modified: October 8, 2018                              *
***************************************************************/
import java.util.*;
import java.io.*; 

public class Candidate
{
    //classfields
    private String state; 
    private int divisionID; 
    private String divisionNm; 
    private String partyAb; 
    private String party; 
    private int candidateID; 
    private String surname; 
    private String name; 
    private char elected; 
    private char hElected; 

 /***********************************************************
* ALTERNATE CONSTRUCTOR: State                              *
* IMPORT:  inState (String), inDivisionId (int)             *
*          inDivisionNm (String), inParty (String)          *
*          inCandidateID (int),  inPartyAb (String),        *
*          inSurname(String), inGivenNm (String),           *
*          inElected (char),inHElected(char),               *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/
public Candidate (String inState, int inDivisionId, String inDivisionNm, String inPartyAb,
                  String inParty, int inCandidateID, String inSurname, String inGivenNm,
                  char inElected, char inHElected)
{
    setState(inState); 
    setDivisionId(inDivisionId); //to ensure there are no invalid inputs 
    setDivisionNm(inDivisionNm); 
    setPartyAb(inPartyAb);
    setParty(inParty); 
    setCandID(inCandidateID); //use mutators to validate data 
    setSurname(inSurname); 
    setName(inGivenNm);
    setSurname(inSurname); 
    setName(inGivenNm);
    elected = inElected; 
    hElected = inHElected; 

}

//ACCESSORS
public String getState()
{
    return state; 
}

public int getDivID ()
{
    return divisionID; 
}

public String getDivNm()
{
    return divisionNm; 
}

public String getPartyAb()
{
    return partyAb; 
}

public String getParty()
{
    return party; 
}

public int getCand ()
{
    return candidateID; 
}

public String getSurname()
{
    return surname; 
}

public String getName()
{
    return name; 
}

public char getElected()
{
    return elected; 
}

public char getHElected()
{
    return hElected; 
}

/************************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/
public String toString()
{
 String candString;
 candString = new String ("STATE: " +state+ " DIVISION ID: " +divisionID+ " DIVISION NAME: "
                            +divisionNm+ " CANDIDATE ID: " +candidateID+ " SURNAME: " +surname+
                            " NAME: " +name+ " ELECTED: " +elected+ " HISTORY ELECTED: " +hElected+ 
                            " PARTY: " +party);  
 return candString;
}

/*************************************************************
 * SUBMODULE: equals                                         *
 * IMPORT: theObject (Object)                                *
 * EXPORT: isequalto (boolean)                               *
 * ASSERTION: two candidates are interchangeable             *
 *            if they have are equal                         *
 *                                                           *
 *************************************************************/
public boolean equals (Object theObject)
{
    boolean isequalto = false; 
    Candidate theCand = null; 
    if(theObject instanceof Candidate)
    {
        theCand = (Candidate)theObject; 
        if(state.equals(theCand.getState()))
         if(divisionID == theCand.getDivID())
          if(divisionNm.equals(theCand.getDivNm()))
           if(partyAb.equals(theCand.getPartyAb()))
            if(party.equals(theCand.getParty()))
             if(candidateID == theCand.getCand())
              if(surname.equals(theCand.getSurname()))
               if(name.equals(theCand.getName()))
                if(elected == theCand.getElected())
                 if(hElected == theCand.getHElected())
                    isequalto = true; 
    }
        return isequalto; 
}
//MUTATORS 
public void setState(String inState)
{
    if(validateString(inState))
    {
        state = inState; 
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
        divisionID = inDivisionId; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Division ID: Less than 0!");
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
        party = inParty; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Party Name"); 
    }
}

public void setCandID(int inCandidateID)
{
    if(inCandidateID>0)
    {
        candidateID = inCandidateID; 
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
       name = inName; 
    }
    else
    {
        throw new IllegalArgumentException("Invalid Name"); 
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