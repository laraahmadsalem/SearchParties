/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class is responsible for all the User Input   *
*          submodules to handle all the inputs                *
* Date Created: October 6, 2018                               *
* Date Modified: October 19, 2018                             *
***************************************************************/

import java.util.*;


public class UserInput
{

    /************************************************************
    * SUBMODULE: whichMargin                                    *
    * IMPORT:NONE                                               * 
    * EXPORT: double choice                                     *
    * Assertion: handles user input with which margin they want * 
    *            if they dont want a specific margin, default is* 
    *            set                                            * 
    *************************************************************/
    public static double whichMargin()
    {
        int choice;
        double threshold=6; //if no option selected then default of 6 is used
        Scanner sc = new Scanner(System.in); 

        try
        {
            System.out.println("Please enter (1) Default Threshold +/-6 (2) Custom Threshold");
            choice = sc.nextInt(); //choice is inputted here

            if(choice == 1)
            {
                threshold = 6; 
            }
            else if(choice == 2)
            {
                System.out.println("Please Input a custom threshold"); 
                threshold = sc.nextDouble(); 
            }
            else
            {
                System.out.println("Invalid choice: Going to use Default Threshold of 6"); 
            }
    
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please input a Number"); //error handling if a user inputs a wrong choice
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );                   
            choice = sc.nextInt();
        }
        return threshold; 
    }

    /************************************************************
    * SUBMODULE: whichFile                                      *
    * IMPORT:NONE                                               * 
    * EXPORT:int option                                         *
    * Assertion: handles user input with which file they want   * 
    *            to read in so no issues occur with creating    * 
    *            wrong or invalid object                        * 
    *************************************************************/
    
    public static int whichFile()
    {
        Scanner sc = new Scanner(System.in); 
        int option; 

        try
        {
            System.out.println("Please Input (1)Reading in Nominees (2) Reading in States (3) Read Locations for Graph "); 
            //choose between nominees for part 1 & 2 
            //states for part 3 & 4
            option = sc.nextInt(); 
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please input a Number");
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
            option = sc.nextInt();
            
        }
        return option; 
        //returns option to execute appropriate command
    
    }

    /************************************************************
    * SUBMODULE: direct                                         *
    * IMPORT:int choice,DSALinkedList list                      * 
    * EXPORT: NONE                                              *
    * Assertion: directs the appropriate commands to implement  * 
    *            the correct filtering based on the choice that * 
    *            has been passed on from a previous function    * 
    *************************************************************/

    public static void direct(int choice, DSALinkedList list)
    {
        int one; 
        int option1,option2; 
        switch(choice)
        {
            case 1:
            one = whichCriteria(); 
            //use criteria function to sort by chosen category
            oneChoice(one, list);
            //sends it off to actually filter by one category 
            //based on the vakue of the variable 'one'
            break; 

            case 2: 
            do
            {
                option1 = whichCriteria(); 
                option2 = whichCriteria(); 
                //calls criteria function twice because two choices 

                if(option1 == option2)
                {
                    System.out.println("Error you cant filter by two categories if they are the same! TRY AGAIN"); 
                    //while options to categorise by are the same print out error message & keep looping
                }

            }while(option1 == option2); 
            //error checking by looping until the user filters by two different categories and not the same thing
            
            twoChoice(option1,option2,list);
            //once it meets the while loop conditions it will be sent off to filter 
            break; 
            
            case 3: 
            FilterNominees.search(list);
            //if they want to filter by everything then no need to call the criteria function 
            break; 

            case 4: 
            System.out.println("Returning to Menu"); 
            //returns to main menu if no filter selection is chosen 
            break; 

            default:
            System.out.println("NOT VALID OPTION ");
            break;
        }
    }

    /************************************************************
    * SUBMODULE: whichCriteria                                  *
    * IMPORT:NONE                                               * 
    * EXPORT: int choice                                        *
    * Assertion: directs the users to which category they want  * 
    *            to filter by                                   * 
    *************************************************************/
    public static int whichCriteria()
    {
        int choice; 
        //created a function to call criteria so i would not duplicate code
        Scanner sc = new Scanner(System.in);  
        try
        {
            System.out.println("Press a number to filter for (1)State (2)Party (3)Division"); 
            //asks for which division to categorise and stores it as a numerical value
            choice = sc.nextInt(); 
            //passed onto other functions for filterng purposes 
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please input a Number");
            //if a string is inputted then its flushed and 
            //a new correct value is required to be inputted 
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
            choice = sc.nextInt(); 
        }
        return choice; 
    }
    public static int yesOrNo ()
    {
        int choice = 1; 
        Scanner sc = new Scanner (System.in);
        try
        {
            System.out.println("Would you like to Write Out to File (1) Yes (2) No ");
            choice = sc.nextInt(); 
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please input a Number");
            //if a string is inputted then its flushed and 
            //a new correct value is required to be inputted 
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
            choice = sc.nextInt(); 
        }
        return choice; 
    }

    public static String nameOfFile()
    {
        String fileName = "test.txt"; 
        Scanner sc = new Scanner(System.in); 
        try
        {
            System.out.println("Please input the name of the file e.g. test.txt");
            fileName = sc.nextLine(); 
        }
        catch(InputMismatchException e)
        {
            System.out.println("Expected String: Recieved an Int"); 
            //if an int is inputted thats an error 
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("This fileName cannot be null:" +e.getMessage()); 
            //if no state was picked it cannot be null 
        }
        return fileName; 
    }
    /************************************************************
    * SUBMODULE: oneChoice                                      *
    * IMPORT:int choice, DSALinkedList list                     * 
    * EXPORT: NONE                                              *
    * Assertion: directs the users to which category they want  * 
    *            based on them selecting only one category      *
    *            to filter by                                   * 
    *************************************************************/
    public static void oneChoice(int choice, DSALinkedList list)
    {
  
        try
        {
            switch(choice) //puts choice in a switch 
            {
                case 1: 
                //if choice is one then selectively filtery by State
                FilterNominees.selectiveFilter(list,'S'); 
                break; 

                case 2: 
                //if two then filter by party 
                FilterNominees.selectiveFilter(list,'P'); 
                break; 

                case 3: 
                //if three then filter by division
                FilterNominees.selectiveFilter(list,'D'); 
                break; 

                default:
                //just for error handling cases if the option is neither any of the above then 
                //print an error message and go back to Main Menu 
                System.out.println("Option is Invalid");  
                break; 
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("ERROR: "  + e.getMessage());
        }
        catch(InputMismatchException exception)
        {
            System.out.println("Invalid Option in Listing Nominees");
        }
    }
    /************************************************************
    * SUBMODULE: twoChoice                                      *
    * IMPORT:int option1,int option2, DSALinkedList list        * 
    * EXPORT: NONE                                              *
    * Assertion: directs the users to which category they want  * 
    *            based on them selecting only two categories    *
    *            to filter by                                   * 
    *************************************************************/
    public static void twoChoice(int option1, int option2, DSALinkedList list)
    {
        if(((option1 == 1) && (option2 == 2)) || ((option2 == 1) && (option1 == 2)))
        {
            FilterNominees.selectiveFilter('S','P',list); 
            //sends off to char values to filter by state and party 
        }
        else if(((option1 == 1) && (option2 == 3)) || ((option2 == 1 ) &&  (option1 == 3)))
        {
            FilterNominees.selectiveFilter('S','D',list);
            //filter by state and division 
        }
        else if(((option1 == 2) && (option2 == 3))|| ((option2 == 2) && (option1 == 3)))
        {
            FilterNominees.selectiveFilter('P','D',list); 
            //filter by party and division
        }
    }

   

}