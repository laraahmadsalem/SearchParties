/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class handles the graphical user interafce    *
*          for users and is where all the invoking of classes *
*          is done                                            *
* Date Created: October 3, 2018                               *
* Date Modified: October 3, 2018                              *
***************************************************************/
import java.util.*;
import java.io.*;
import java.text.NumberFormat;

public class Main 
{ 

    public static void main (String [] args)
    {

        Scanner sc = new Scanner(System.in);
        int theInput, option; //user input variables 
        boolean readIn = false; // for nominees 
        boolean readState = false; //for all states read in and their party
        boolean readLocation = false; //for locations for itinerary 
        boolean margin = false; //only creates itinerary provided that marginal seats have been given 
        DSALinkedList list = new DSALinkedList(); //list for nominees used in first two parts 
        DSALinkedList listS = new DSALinkedList(); //list for states that are used to calculate margins 
        DSAQueue location = new DSAQueue(); //queue that returns margins and their divisions to visit for itinerary
        DSAGraph graph = new DSAGraph(); //graph for the itinerary 

     do
     { 
        try
        {
            //menu for users as part of GUI 
            System.out.println("===================");      
            System.out.println("     MAIN MENU    ");
            System.out.println("==================="); 
            System.out.println("Please select: ");
            System.out.println("1. List Nominees") ; 
            System.out.println("2. Nominee Search");
            System.out.println("3. List By Margin"); 
            System.out.println("4. Itinerary by Margin");
            System.out.println("5. Read in A File");
            System.out.println("6. Exit");
            System.out.println("===================");            

            theInput = sc.nextInt(); 
        }
            
        catch (InputMismatchException e)  
        {

            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." ); //catches any errors 
            System.out.println ("Please try again!");
                
            theInput = sc.nextInt();
        }  

        switch(theInput) //switch that directs users to appropriate submodule from which ever input they choose 
        {
            case 1: 
            if(readIn == true)
            {
                listNominees(list); //passes in linked list with populated nominees to list them 
            }
            else
            {
                System.out.println("Please input a fileName: No Data Available to List"); 
            }
            break; 

            case 2: 
            if(readIn == true)
            {
                search(list); //searches by a substring
            }
            else
            {
                System.out.println("Please input a fileName: No Data Available to Search"); 
            }
            break;

            case 3: 
            if(readState == true)
            {
                location = listMargin(listS,location);  //gets list with states and queue of locations 
                margin = true; 
            }
            else
            {
                System.out.println("Please input a fileName: No Data Available to List By Margin"); 
            }
            break; 


            case 4:
            if((margin == true) && (readLocation == true))
            {    
               itineraryByMargin(location, graph); 
            }
            else
            {
                System.out.println("Please input a fileName: No Data Available to List for Itinerary"); 
            }
            break; 

            case 5: 
            option = UserInput.whichFile(); 
            if(option == 1) //based on option decides what to read in to create appropriate objects 
            {
                fileReader(list); //return a boolean to make sure that it successfully  read in  
                readIn = true;
            }
            else if(option == 2) 
            {
                fileReaderState(listS); 
                readState = true; 
            }
            else if(option == 3)
            { 
                fileReaderLocation(graph); 
                readLocation = true; 
            }
            else
            {
                System.out.println("Invalid choice of which file to create"); 
            }
            break; 

            case 6:
            System.out.println("Program will now exit!"); 
            break; 
        }
  } while((theInput>6) || (theInput != 6)); //keeps looping until 6  is pressed to exit program

}


public static void fileReader (DSALinkedList list)
{
    String fileName; 
    Scanner sc = new Scanner(System.in);
    try
    {
        System.out.println("Please Input the name of the File"); //used to get file for nominees 
        fileName = sc.nextLine();
        
        list =  FileIO.createCandidate(fileName, list); 

    }
    catch(NumberFormatException e)
    {
        System.out.println("File Input Error: " +e.getMessage()); 
    }

}

public static void fileReaderLocation(DSAGraph graph)
{
    String fileName; 
    Scanner sc = new Scanner(System.in); 
    try
    {
        System.out.println("Please input the name of the File"); //used to get file for the graph distances 
        fileName = sc.nextLine();

        graph = FileIO.createLocation(fileName, graph); 
    }
    catch(NumberFormatException e)
    {
        System.out.println("File Input Error: " +e.getMessage()); 
    }

}
public static void fileReaderState(DSALinkedList listS)
{
    String fileName; 
    Scanner sc = new Scanner(System.in); 
    try
    {
        System.out.println("Please Input the name of the file"); //used to get file for the states for margin 
        fileName = sc.nextLine(); 

        listS = FileIO.createState(fileName, listS); //sends file name and linked list so it can be processed via file input / output 
    }
    catch(NumberFormatException e)
    {
        System.out.println("File Input Error: " +e.getMessage()); //is a user inputs a number it catches the exception 
    }

}

public static void listNominees(DSALinkedList list)
{
    int choice; 
    Scanner sc = new Scanner(System.in); 
    try
    {
        do
        {

            System.out.println("Press to filter by (1) Category (2) Category (3) All Categories (4) Main Menu"); 
            //takes into account how many categories to filter by and directs it to a switch for easier functionality in up coming functions
            choice = sc.nextInt(); 
            UserInput.direct(choice, list); 

        } while(choice != 4); 

    }
    catch (InputMismatchException e)
    {
        System.out.println("Please input a Number");
        String flush = sc.nextLine();
        System.out.println( "Error you cannot enter letters." );
                       
        choice = sc.nextInt();
        UserInput.direct(choice, list); //added this
    }


}

public static void search(DSALinkedList list)
{
     String surname; 
     Scanner sc = new Scanner(System.in); 

     try
     { 
            System.out.println("Enter the keyword of the Surname of the nominees you are looking for"); 
            surname = sc.nextLine(); 
            Search.searchSubstring(list, surname);
     }
     catch(NumberFormatException e)
     {
            System.out.println("Trying to convert String surname into a Number: Invalid"); 
     }
     catch(NullPointerException e)
     {
            System.out.println("Trying to use NULL as Surname: Invalid"); 
     }
}

public static void itineraryByMargin(DSAQueue locations, DSAGraph graph)
{
   Iterator itr = locations.iterator(); 
   while(itr.hasNext())
   {
       String label = (String) itr.next(); 
       graph.dijkstra(label); 
   }

}

public static DSAQueue listMargin(DSALinkedList list,DSAQueue location)
{
    String party; 
    double threshold;
    
    Scanner sc = new Scanner(System.in);

    try
    {
        System.out.println("Please enter the name of the party (abbreviation e.g. ALP"); //asks user which party to to list margins for 
        party = sc.nextLine(); 
   
        threshold = UserInput.whichMargin(); //now asks for margin threshold 

        location = Margin.getMargin(list,location,party,threshold);  //once its done it returns the queue with the margins acquired 
        
    }
    catch(NumberFormatException e)
    {
        System.out.println("Trying to convert String party into a Number: Invalid"); 
    } 
    return location; 

}

}

