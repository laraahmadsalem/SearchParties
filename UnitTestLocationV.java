public class UnitTestLocationV
{
    public static void main(String[] args)
    {
        LocationV location = new LocationV("NSW",31.9505,115.8605); 
        int test=0,pass=0; 
        System.out.println("*********************************");
        System.out.println("     Unit Test for LocationV     "); 
        System.out.println("*********************************"); 
//------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Creating LocationV with Alternate Constructor"); 
        //test with normal conditions of alternate constructor 
        try
        {
            test++;     
            LocationV location2 = new LocationV("NSW",31.9505,115.8605); 
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
        //testing getters for all classfields

        test++;
        String state =  location.getState(); 
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

        test++;
        double lat =  location.getLatitude(); 
        if(lat != 31.9505)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Latitude: "); 
            System.out.println("Latitude: " +lat);
            pass++; 
            System.out.println("PASSED"); 
        }  

        test++;
        double longitude =  location.getLongitude(); 
        if(longitude != 115.8605)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Get Longitude: "); 
            System.out.println("Longitude: " +longitude); 
            pass++; 
            System.out.println("PASSED"); 
        }

    

//----------------------------------------------------------------------------------------------
        System.out.println("**********************************"); 
        System.out.println(" Testing toString Method"); 
        System.out.println("**********************************"); 
        //test string matches 

        test++;
        if(("STATE: NSW LATITUDE: 31.9505 LONGITUDE: 115.8605" ).equals(location.toString()))
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
        //test equals 

        test++;
        LocationV location3 = new LocationV("WA",78.4567,120.5678); 
        if(!location.equals(location3))
        {
            pass++; 
            System.out.println("PASSED"); 
        }
        else
        {
            throw new IllegalArgumentException("FAILED"); 
        }
//----------------------------------------------------------------------------------------------------------------------
        //if number of tests matches pass then class works!
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
