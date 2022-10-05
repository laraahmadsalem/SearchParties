public class UnitTestState
{
    public static void main(String[] args)
    {
        State candid = new State("NSW",103,"Banks",31,"Allawah",28951,"GAMBIAN","Chris",1,'N','N',"ALP","Labor",580,2.84); 
        int test=0,pass=0; 
        System.out.println("*********************************");
        System.out.println("     Unit Test for State"); 
        System.out.println("*********************************"); 
//------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Creating State with Alternate Constructor"); 
        //test creation of state 
        try
        {
            test++; 
            State stat = new State("NSW",103,"Banks",31,"Allawah",28951,"GAMBIAN","Chris",1,'N','N',"ALP","Labor",580,2.84); 
            System.out.println("PASSED"); 
            pass++; 
         
        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
            System.out.println(e.getMessage()); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
       
        System.out.println("**********************************"); 
        System.out.println("   Testing Accessors"); 
        System.out.println("**********************************"); 
        //testing all getters 

        test++;
        String state =  candid.getState(); 
        if(!state.equals("NSW"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get State: "); 
            System.out.println("State: " +state); 
            pass++; 
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        int iD =  candid.getDivID(); 
        if(iD != 103)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Division ID: "); 
            System.out.println("Division ID: " +iD); 
            pass++; 
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        String divName =  candid.getDivNm(); 
        if(!divName.equals("Banks"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Division Name: "); 
            System.out.println("Division Name: " +divName); 
            pass++; 
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        int polID =  candid.getPolID(); 
        if(polID != 31)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Polling ID: "); 
            System.out.println("Polling Identification: " +polID); 
            pass++;  
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        String poll =  candid.getPollingPl(); 
        if(!poll.equals("Allawah"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Polling Place: "); 
            System.out.println("Polling Place: " +poll); 
            pass++; 
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        int cID =  candid.getCand(); 
        if(cID != 28951)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Candidate ID: "); 
            System.out.println("Candidate ID: " +cID); 
            pass++; 
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        String surname =  candid.getSurname(); 
        if(!surname.equals("GAMBIAN"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Surname: "); 
            System.out.println("Surname: " +surname); 
            pass++;  
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        String name =  candid.getName(); 
        if(!name.equals("Chris"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Name: "); 
            System.out.println("Name: " +name); 
            pass++;  
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        int bp=  candid.getballotP(); 
        if(bp != 1)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Ballot Position: "); 
            System.out.println("Ballot Position: " +bp); 
            pass++; 
            System.out.println("PASSED"); 
        }

//-------------------------------------------------------------------------------------------------------------------------------------     
        test++;
        String partyAb =  candid.getPartyAb(); 
        if(!partyAb.equals("ALP"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Party Abbreviation: "); 
            System.out.println("Party Abbreviation: " +partyAb); 
            pass++;  
            System.out.println("PASSED"); 
        }

//-------------------------------------------------------------------------------------------------------------------------------------        
        test++;
        String party =  candid.getParty(); 
        if(!party.equals("Labor"))
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Party: "); 
            System.out.println("Party: " +party); 
            pass++;  
            System.out.println("PASSED"); 
        }

//-------------------------------------------------------------------------------------------------------------------------------------        
        test++;
        int votes =  candid.getVotes(); 
        if(votes != 580)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Votes: "); 
            System.out.println("Party Votes: " +votes); 
            pass++;  
            System.out.println("PASSED"); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
        test++;
        double swing =  candid.getSwing(); 
        if(swing != 2.84)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Swing: "); 
            System.out.println("Swing: " +swing); 
            pass++;  
            System.out.println("PASSED"); 
        }
//----------------------------------------------------------------------------------------------
        System.out.println("**********************************"); 
        System.out.println(" Testing toString Method"); 
        System.out.println("**********************************"); 

        test++;
        System.out.println(candid.toString()); 
        if(("STATE: NSW DIVISION ID: 103 DIVISION NAME: Banks POLLING ID: 31 POLLING PLACE: Allawah CANDIDATE ID: 28951 SURNAME: GAMBIAN NAME: Chris BALLOT POSITION: 1 ELECTED: N HISTORY ELECTED: N PARTY: Labor ORDINARY VOTES: 580 SWING: 2.84" ).equals(candid.toString()))
        {
            pass++; 
            System.out.println("PASSED"); 
        }
        else
        {
            throw new IllegalArgumentException("FAILED"); 
        }
//-----------------------------------------------------------------------------------------------------------------
        System.out.println("**********************************"); 
        System.out.println(" Testing Equals Method"); 
        System.out.println("**********************************");

        test++;
        State s2 = new State("NSW",103,"Banks",31,"Allawah",28951,"GAMBIAN","Chris",1,'N','N',"ALP","Labor",580,2.84); 
        if(!candid.equals(s2))
        {
            pass++; 
            System.out.println("PASSED"); 
        }
        else
        {
            throw new IllegalArgumentException("FAILED"); 
        }

        if(test == pass)
        {
            System.out.println("-------------------"); 
            System.out.println("PASSED ALL TESTS !"); 
        }
        else
        {
            int value = test - pass;
            System.out.println("-------------------"); 
            System.out.println("FAILED" +value+ " TESTS !"); 
        }
    }
}