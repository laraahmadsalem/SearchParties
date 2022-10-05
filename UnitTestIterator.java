import java.util.*;

public class UnitTestIterator
{	
   public static void main(String args[])
   {
      //Variable Declarations 
      int iNumPassed = 0;
      int iNumTests = 0; 
      DSALinkedList list = null; 
       
//----------------------------------------------------------------------------
      // Test with normal conditions (shouldn't throw exceptions)
      System.out.println("\n");
      System.out.println("Testing Normal Conditions - Constructor");
      System.out.println("=======================================");
      try
      {  
 
         iNumTests++;
         System.out.println("Testing creation of Linked List: ");

         list = new DSALinkedList();	

         if(list.isEmpty() == false)
         {
            throw new IllegalArgumentException("The head might be null"); 
         } 
         iNumPassed++;

         System.out.println("PASSED");
       }
       catch(Exception e) 
       {
         System.out.println("FAILED"); 
       } 
//----------------------------------------------------------------------------
        try
        {
     
             iNumTests++;
             System.out.println("Testing insertFirst of elements into Linked list: ");  
             System.out.println("=======================================");
             System.out.println("Adding the following real numbers 43.5 , 34.2, 12.3, 56.4, 2.3, 45.2, 56.7, 89.9, 14.5"); 

             Double value1 = 43.5; 
             Double value2 = 34.2; 
             Double value3 = 12.3; 
             Double value4 = 56.4; 
             Double value5 = 2.3; 
             Double value6 = 45.2; 
             Double value7 = 56.7; 
             Double value8 = 89.9; 
             Double value9 = 14.5;  
             //creates and inserts values 

             list.insertFirst(value1); 
             list.insertFirst(value2);
             list.insertFirst(value3);
             list.insertFirst(value4);
             list.insertFirst(value5);
             list.insertFirst(value6);
             list.insertFirst(value7);
             list.insertFirst(value8);
             list.insertFirst(value9);

             iNumPassed++;
             System.out.println("PASSED");
        }
        catch(Exception e)
        {
             System.out.println("FAILED"); 
        }
//-----------------------------------------------------------------------------
        try
        {

             iNumTests++;

             System.out.println("Testing the Iterator to display contents of Array List: ");
             System.out.println("=======================================");
             System.out.println("Original contents of the List"); 
             //tests the iterator prints out correct values 

             Iterator itr = list.iterator(); 
             
             System.out.println("Elements are:"); 

             while(itr.hasNext())
             {
                Object values = itr.next(); 
                System.out.print( values + " "); 
             }
             System.out.println(); 
             iNumPassed++;
             System.out.println("PASSED");
         }                    
        catch (IllegalArgumentException e)
        {
            System.out.println("Illegal Argument:" + e.getMessage()); 
        }       
        catch (Exception e)
        {
            System.out.println("FAILED");
        }
  } // End of main
} // End of Class

