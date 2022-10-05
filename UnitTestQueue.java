import java.util.*; 

public class UnitTestQueue
{

 public static void main(String [] args)
 {
    int iNumPassed = 0; 
    int iNumTests = 0; 
    DSAQueue queue; 
//----------------------------------------------------------------------------------------------------------------------------------------    
    
    // Test with normal conditions (shouldn't throw exceptions)
    System.out.println("\n");
    System.out.println("Testing Normal Conditions - Constructor");
    System.out.println("=======================================");

    try
    {
        iNumTests++;
        System.out.println("Testing creation of queue:"); 
        //test creation of queue 
        
        queue = new DSAQueue(); 
        iNumPassed++; 

        System.out.println("PASSED"); 
//----------------------------------------------------------------------------------------------------------------------------
        iNumTests++; 
        System.out.println("Test adding candidates to the queue");
        //tests enqueue method 
        
        Candidate candid = new Candidate("WA",197,"Balcatta","ALP","Australian Liberal Party",123456,"ABBOT","Tony",'Y','Y');
        Candidate can = new Candidate("NSW",149,"GreenAcre","LP","Labour Party",145987,"JAMES","Morris",'Y','N'); 
        Candidate nominee = new Candidate("ACT",176,"Town Square","G","Greens",109654,"MORRIS","Patty",'N','Y');

        queue.enqueue(candid); 
        queue.enqueue(can); 
        queue.enqueue(nominee);

        iNumPassed++; 
        System.out.println("PASSED"); 

//-----------------------------------------------------------------------------------------------------------------------------------
        iNumTests++;
        System.out.println("Testing Count:"); 
        //test count matches how many objects were enqueued 
        int count =  queue.getCount();
        if(count != 3)
        {
            throw new IllegalArgumentException("FAILED"); 
        }
        else
        {
            System.out.println("Count:" +count); 
            iNumPassed++; 
            System.out.println("PASSED"); 
        }
//--------------------------------------------------------------------------------------------------------------------------------
        iNumTests++; 
        System.out.println("Testing for top value in the queue"); 
        //test FIFO applies 
        Object value = queue.peek(); 
        if(!value.equals(candid))
        {
            throw new IllegalArgumentException("FAILED");
        }
        else
        {
            System.out.println("Top Value is:" +value); 
            iNumPassed++; 
            System.out.println("PASSED"); 
        }
//------------------------------------------------------------------------------------------------------------------------------------
        iNumTests++; 

        System.out.println("Testing dequeue for queue "); 
        Object hey = queue.dequeue(); 
        if(!hey.equals(candid))
        {
            throw new IllegalArgumentException("FAILED");
        }
        else
        {
             System.out.println("Value that has been dequeued is: " +value);;
             iNumPassed++; 
             System.out.println("PASSED"); 
        }
//-----------------------------------------------------------------------------------------------------------------------------------------
        
    }

      catch(IllegalArgumentException e)
      {
         System.out.println("Illegal Argument:" + e.getMessage());
      }
      catch(Exception e)
      {
         System.out.println("FAILED");
      }
//----------------------------------------------------------------------------------------------------------------------------------
// Tests with error conditions (SHOULD throw exceptions)
// Testing constructor's parameters of ore type and units.
    System.out.println("\n");
    System.out.println("Testing Error Conditions - Constructor");
    System.out.println("======================================");
   

    try
    {
        int max = 3; 
        iNumTests++; 
        System.out.println("Testing for a top value with NO object in array");
        queue = new DSAQueue(); 
        Object topVal = queue.peek(); 
        System.out.println("The top value is:" +topVal);
        System.out.println("FAILED"); 
    }
    catch(Exception e)
    {
        iNumPassed++;
        System.out.println("PASSED"); 
    }

//------------------------------------------------------------------------------------------------------------------------------------
    try
    {
    
        iNumTests++; 
        System.out.println("Testing if we can dequeue the top value with NO objects"); 
        queue = new DSAQueue(); 
        Object theVal = queue.dequeue(); 
        System.out.println("The top dequeued value is:" +theVal); 
        System.out.println("FAILED"); 
    }
    catch(Exception e)
    {
        iNumPassed++; 
        System.out.println("PASSED"); 
    }

//-------------------------------------------------------------------------------------------------------------------------------------   
            
  }
}

        
