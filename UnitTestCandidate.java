public class UnitTestCandidate
{
    public static void main(String[] args)
    {
        Candidate candid = new Candidate("WA",197,"Balcatta","ALP","Australian Liberal Party",123456,"ABBOT","Tony",'Y','Y');; 
        int test=0,pass=0; 
        System.out.println("*********************************");
        System.out.println("     Unit Test for Candidate"); 
        System.out.println("*********************************"); 
//------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Creating Candidate with Alternate Constructor"); 
        //test creation of canidate using alternate constructor 
        try
        {
            test++; 
            Candidate can = new Candidate("WA",197,"Balcatta","ALP","Australian Liberal Party",123456,"ABBOT","Tony",'Y','Y');
            System.out.println("PASSED"); 
            pass++; 
         
        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
            System.out.println(e.getMessage()); 
        }
//-------------------------------------------------------------------------------------------------------------------------------------
       //Testing accessors for the class
        System.out.println("**********************************"); 
        System.out.println("   Testing Accessors"); 
        System.out.println("**********************************"); 

        test++;
        String state =  candid.getState(); 
        if(!state.equals("WA"))
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

        test++;
        int iD =  candid.getDivID(); 
        if(iD != 197)
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

        test++;
        String divName =  candid.getDivNm(); 
        if(!divName.equals("Balcatta"))
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

        test++;
        String party =  candid.getParty(); 
        if(!party.equals("Australian Liberal Party"))
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

        test++;
        int cID =  candid.getCand(); 
        if(cID != 123456)
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

        test++;
        String surname =  candid.getSurname(); 
        if(!surname.equals("ABBOT"))
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

        test++;
        String name =  candid.getName(); 
        if(!name.equals("Tony"))
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
//----------------------------------------------------------------------------------------------
        //testing to string method matches 
        System.out.println("**********************************"); 
        System.out.println(" Testing toString Method"); 
        System.out.println("**********************************"); 

        test++;
        if(("STATE: WA DIVISION ID: 197 DIVISION NAME: Balcatta CANDIDATE ID: 123456 SURNAME: ABBOT NAME: Tony ELECTED: Y HISTORY ELECTED: Y PARTY: Australian Liberal Party" ).equals(candid.toString()))
        {
            pass++; 
            System.out.println("PASSED"); 
        }
        else
        {
            throw new IllegalArgumentException("FAILED"); 
        }
//-----------------------------------------------------------------------------------------------------------------
        //testing equals method 
        System.out.println("**********************************"); 
        System.out.println(" Testing Equals Method"); 
        System.out.println("**********************************");

        test++;
        Candidate nominee = new Candidate("WA",197,"Balcatta","LP","Labour Party",123456,"SHORTEN","Bill",'Y','Y'); 
        if(!candid.equals(nominee))
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