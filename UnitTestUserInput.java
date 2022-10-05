/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This test harness ensures that the user input works*
*          according to a specific set of user input recieved *
*          from the user which is then piped out to output.txt*
* Date Created: October 16, 2018                              *
* Date Modified: October 17, 2018                             *
***************************************************************/
import java.util.*; 
import java.io.*; 

public class UnitTestUserInput
{
    public static void main(String [] args)
    {
        //VARIABLE DECLARATIONS
        int test = 0; 
        int pass = 0; 
       
//---------------------------------------------------------------------------------------------
        test++; 
        try
        {
            
            System.out.println("Testing the Input of the function whichFile() ");
            System.out.println("==========================================="); 
            int result = UserInput.whichFile(); 
            System.out.println("The number you inputted is: " +result);
            System.out.println("PASSED");
            pass++; 
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }
//-----------------------------------------------------------------------------------------------------------------------------
        test++; 
        try
        {
            System.out.println("Testing the whichCriteria() function ");    
            System.out.println("==========================================="); 
            int choice = UserInput.whichCriteria();
            System.out.println("Output: " +choice);
            System.out.println("PASSED");
            pass++; 
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }
//-----------------------------------------------------------------------------------------------------------------------------
        
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
//-------------------------------------------------------------------------------------------------------
        System.out.println("*****************************************************************");
        System.out.println("Note: Not all functions were tested as they would have led  ");
        System.out.println("      to the calling of other classes that have already been    ");
        System.out.println("      tested in another test harness. To make sure those functions  ");
        System.out.println("      work, test it out in the main program. ");
        System.out.println("********************************************************************");

        System.out.println("For extra error checking purposes the next time you run this test harness compile with ");
        System.out.println("'java UnitTestUserInput > UnitTestUserInput.txt' to compare your input with the output ");
        System.out.println("However note that the output wont be displayed to the terminal");
        

    }
}