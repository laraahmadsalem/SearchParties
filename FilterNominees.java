/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class is responsible for all the Filtering    *
* Date Created: October 6, 2018                               *
* Date Modified: October 19, 2018                             *
***************************************************************/

import java.util.*; 


public class FilterNominees
{
    /*************************************************************
     * SUBMODULE: selectiveFilter                                *
     * IMPORT: char word1, char word2, DSALinkedList list        *
     * EXPORT: NONE                                              *
     * ASSERTION: uses word1 and word2 to decide what to filter  *
     *            by and directs the input to appropriate search *
     *            function                                       *
     *************************************************************/
    public static void selectiveFilter(char word1, char word2, DSALinkedList list) //2 options to filter by 
    {
        String state,party; 
        int division; 

        if((word1 == 'S') && (word2 == 'P')) //filters by state and party 
        {
            state = whichState(); 
            //sends off to a function that asks what state and party a user wants to filter by 
            party = whichParty(); 
            search(state,party,list); 
            //once the specific party and state are selected then the search function searches for them 
        }
        else if((word1=='P') && (word2 == 'D')) //filters party and division 
        {
            party = whichParty(); 
            division = whichDiv();
            search(party,division,list,'P');  
        }
        else 
        {
            //filters by state and division 
            state = whichState(); 
            division = whichDiv(); 
            search(state,division,list,'S'); 
        }
    }
    /*************************************************************
     * SUBMODULE: selectiveFilter                                *
     * IMPORT: DSALinkedList list, char word                     *
     * EXPORT: NONE                                              *
     * ASSERTION: uses the 'word' to decide what to filter       *
     *            by and directs the input to appropriate search *
     *            function                                       *
     *************************************************************/
    public static void selectiveFilter(DSALinkedList list, char word) 
    {
        String state, party; 
        int div; 

        switch(word)
        {
            case 'S':
            state = whichState(); 
            //cals which state function saves me trouble to rewrite more code 
            System.out.println("Chosen State is:" +state);
            //directs to appropriate search function and searches for all objects with same state
            search(list,state,'S'); 
            break; 

            case 'D':
            div = whichDiv(); 
            //calls which division and uses user input 
            System.out.println("Chosen Division is:" +div);
            //uses variable 'div' to find all objects that match division specified by user 
            search(list, div); 
            break; 

            case 'P':
            party = whichParty(); 
            //calls party function which uses user input
            System.out.println("Chosen Party is:" +party);
            search(list, party,'P'); 
            break; 
        }
    }
     /************************************************************
     * SUBMODULE: search                                         *
     * IMPORT: DSALinkedList list                                *
     * EXPORT: NONE                                              *
     * ASSERTION: this function straight away knows that the user*
     *            wants to filter by every category              *
     *            basically calls all the 'which' functions      *
     *************************************************************/

    public static void search(DSALinkedList list) //filter by all 
    {
        String party,state; 
        int division;  
        Iterator itr = list.iterator(); 
        Candidate candid; 
        DSAQueue queue  = new DSAQueue(); 
        int choice;  
        int howMany; 
        int count=0;
        

        state = whichState();
        //since it knows everything should be filtered it calls every single 'which' methods 
        division = whichDiv(); 
        party = whichParty(); 

     
        while(itr.hasNext())   
        {
            candid = (Candidate) itr.next(); 
            //gets every candidate object and compares by specified state,party and division 
            if((state.equalsIgnoreCase(candid.getState())) && (party.equalsIgnoreCase(candid.getParty())) && (division == candid.getDivID()))
            {
                queue.enqueue(candid); //everything that matches is queued 
            }
            
        }
        count = queue.getCount(); 
        //got the count of the queue to make sure it wasnt empty 
        //was much better than using a linked list because what if the list was empty 
        //how would i know 
        if(count == 0)
        {
            System.out.println("Nothing in queue: Nothing to order"); 
            //if the queue ends up being empty then print an error message & return to menu 
        }
        else
        {
            Candidate[] array = new Candidate[count]; 
            //initialises an array with the number of the count 
            for(int i=0;i<count; i++)
            {
                array[i] = (Candidate) queue.dequeue(); 
                //dequeues the canidate objects that match the criteria 
                //passes them to an array to do some merge sorting 
            }

            howMany = orderMany(); 
            //using the order many i ask how much stuff they want to order by 
            //so i know when i pass the array by which appropriate steps to follow 
            decideOrder(howMany,array); 
            //this function asks them by what they want to order by and the 'howMany' variable directs
            //the switch to ask them the correct number of time by what they want to order by 
            
            for(int ii=0; ii< array.length; ii++)
            {
                System.out.println(array[ii].toString()); 
                //once its ordered it prints the array to the terminal 
            }
            //option to save to a file             

        }

       
    }
     /************************************************************
     * SUBMODULE: decideOrder                                    *
     * IMPORT: int num, Candidate[] array                        *
     * EXPORT: NONE                                              *
     * ASSERTION: this function knows how much to order by       *
     *            and uses that to sort in the sorts class       *
     *************************************************************/
    public static void decideOrder(int num, Candidate[] array)
    {
        int choice1,choice2,choice3;
        String fileName; 
    
        switch(num)
        {
            case 1:
            choice1 = orderBy(); 
            //asks for what they want to order by e.g. surname 
            Sorts.mergeSort(array,choice1);
            //uses choice to execute the appropriate merge 
            if(UserInput.yesOrNo() == 1)
            {
                fileName = UserInput.nameOfFile(); 
                FileIO.writeToFile(array,fileName);
            }
            break; 

            case 2: 
            do
            {
                choice1 = orderBy(); 
                choice2 = orderBy();

            }while(choice1 == choice2);
            //for error checking purposes loops until both options are different 
            Sorts.mergeSort(array,choice1,choice2);
            if(UserInput.yesOrNo() == 1)
            {
                fileName = UserInput.nameOfFile(); 
                FileIO.writeToFile(array,fileName);
            }
            break; 

            case 3:
            do
            {
                choice1 = orderBy(); 
                choice2 = orderBy();
                choice3 = orderBy(); 
            }while((choice1 == choice2) || (choice2 == choice3) || (choice1 == choice3)); 
            //error checking to make sure all choices to order by are different and not duplicated 
            Sorts.mergeSort(array,choice1,choice2,choice3);

            if(UserInput.yesOrNo() == 1)
            {
                fileName = UserInput.nameOfFile(); 
                FileIO.writeToFile(array,fileName);
            }
            break; 

            case 4: 
            Sorts.mergeSortAll(array);
            if(UserInput.yesOrNo() == 1)
            {
                fileName = UserInput.nameOfFile(); 
                FileIO.writeToFile(array,fileName);
            }
            //this case sorts by every single category and doesnt bother asking for what they specifically want to order by 
            break; 
         }

            
    }
     /************************************************************
     * SUBMODULE: orderMany                                      *
     * IMPORT: NONE                                              *
     * EXPORT: int choice                                        *
     * ASSERTION: this function wants to know how much categories*
     *            to order by                                    *
     *************************************************************/
    public static int orderMany()
    {
        Scanner sc = new Scanner(System.in); 
        int choice; 
        try
        {
            do 
            {

                System.out.println("How many Categories do you want to order by (1) Category (2) Categories (3) Categories (4) All Categories"); 
                choice = sc.nextInt();

            }while((choice > 4) || (choice <1)); 
            //keeps looping until the choice is within the range of 1 to 4, anything else is invalid 
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please input a Number");
            //if a letter was inputted then its flushed and the user tries again 
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
                       
            choice = sc.nextInt();
        }
        return choice; 
    }
     /************************************************************
     * SUBMODULE: whichState                                     *
     * IMPORT: NONE                                              *
     * EXPORT: Stirng state                                      *
     * ASSERTION: this function asks user which state they       *
     *            want to filter by                              *
     *************************************************************/
    public static String whichState()
    {
        Scanner sc = new Scanner(System.in); 
        String state = "WA" ; //default is WA

        try
        {
            System.out.println("Which State Would You Like to Filter By?"); 
            System.out.println("Input the name of the State Please in Abbreviations (e.g. WA, NSW, QLD)"); 
            state = sc.nextLine(); 

        }
        catch(InputMismatchException e)
        {
            System.out.println("Expected String: Recieved an Int"); 
            //if an int is inputted thats an error 
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("This State cannot be null:" +e.getMessage()); 
            //if no state was picked it cannot be null 
        }
        return state; 
    }
    /*************************************************************
     * SUBMODULE: whichDiv                                       *
     * IMPORT: NONE                                              *
     * EXPORT: int iD                                            *
     * ASSERTION: this function asks user which division they    *
     *            want to filter by                              *
     *************************************************************/

    public static int whichDiv()
    {
        Scanner sc = new Scanner(System.in); 
        int iD = 254; 

        try
        {
            System.out.println("Which Division Would you like to filter By?");
            System.out.println("Input the Division ID in numbers like (e.g. 193, 254)"); 
            //gives an example to make sure aware of the format 
            iD = sc.nextInt(); 

        }
        catch (InputMismatchException e)
        {
            System.out.println("Please input a Number");
            //if a string is inputted its flushed 
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
                           
            iD = sc.nextInt();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("This Division cannot be null:" +e.getMessage()); 
        }
        return iD; 
    }
    /*************************************************************
     * SUBMODULE: whichParty                                     *
     * IMPORT: NONE                                              *
     * EXPORT: String party                                      *
     * ASSERTION: this function asks user which party they       *
     *            want to filter by                              *
     *************************************************************/
    public static String whichParty()
    {
        Scanner sc = new Scanner(System.in); 
        String party = "Liberal"; 
        //liberal is  default

        try
        {
            System.out.println("Which Party Would you like to filter"); 
            party = sc.nextLine(); 
        }
        catch(InputMismatchException e)
        {
            System.out.println("Expected String: Recieved an Int"); 
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("This Party cannot be null:" +e.getMessage()); 
        }
        return party; 
    }

     /************************************************************
     * SUBMODULE: search                                         *
     * IMPORT: String find,int division,DSALinkedList list       *
     *         char which                                        *
     * EXPORT: NONE                                              *
     * ASSERTION: this function searches through 2 options from  *
     *            either state/party & division                  *
     *************************************************************/ 
    public static void search(String find,int division,DSALinkedList list,char which) 
    {
        Candidate candid; 
        Iterator itr = list.iterator(); 
        DSAQueue queue = new DSAQueue();
        int count,choice; 
        String result; 
        int howMany;

        while(itr.hasNext())
        {
            candid = (Candidate) itr.next(); 
            //tried to make the function as modular as possible because i didnt want to 
            //duplicate code 

            if(which == 'S') //based on the which it gets the appropriate string e.g. state 
            {
                result = candid.getState(); 
                if((division == candid.getDivID()) && (find.equalsIgnoreCase(result)))
                {
                    queue.enqueue(candid); 
                    //if the canidate object matches search criteria its queued 
                }
                
            }
            else if(which == 'P') //if its P for party then party is obtained and compared with division 
            {
                result = candid.getParty(); 
                if((find.equalsIgnoreCase(result)) && (division == candid.getDivID()))
                {
                    queue.enqueue(candid); 
                }
            }


        }

        count = queue.getCount(); 
        //if theres nothing in the queue print an eror message 
        if(count == 0)
        {
            System.out.println("Nothing in queue: Nothing to order"); 
        }
        else
        {
                       
            Candidate[] array = new Candidate[count]; 
            for(int i=0;i<count; i++)
            {
                array[i] = (Candidate) queue.dequeue(); 
                //put in an array for merge sorting 
            }
            
            howMany = orderMany(); 
            //wants to know how many ctaegories to order by 
            decideOrder(howMany,array);  
            //based on that it asks a user what they want to order by 
            //and sends it off to appropriate merge sort function 

            for(int ii=0; ii< array.length; ii++)
            {
                System.out.println(array[ii].toString()); 
                //prints out to the terminal 
            }
            //gives option to save to a file 
        }
    }
     /************************************************************
     * SUBMODULE: search                                         *
     * IMPORT:String state,String party,DSALinkedList list       *
     * EXPORT: NONE                                              *
     * ASSERTION: this function searches through 2 options from  *
     *            either state & party                           *
     *************************************************************/ 
    public static void search(String state,String party,DSALinkedList list) 
    {
        Candidate candid; 
        Iterator itr = list.iterator(); 
        DSAQueue queue = new DSAQueue();
        int count,choice; 
        int howMany; 
     

        while(itr.hasNext())
        {
            candid = (Candidate) itr.next(); 
            //everything that matches state and party criteria is queued 
            if((state.equalsIgnoreCase(candid.getState())) && (party.equalsIgnoreCase(candid.getParty())))
            {
                    queue.enqueue(candid); 
            }         
        }

        count = queue.getCount(); 
        //if count is 0 then dont continue 
        if(count == 0)
        {
            System.out.println("Nothing in queue: Nothing to order"); 
        }
        else
        {
                       
            Candidate[] array = new Candidate[count]; 
            for(int i=0;i<count; i++)
            {
                array[i] = (Candidate) queue.dequeue(); 
                //dequeued to an array for merge sorting 
            }
         
            howMany = orderMany(); 
            decideOrder(howMany,array);  

            for(int ii=0; ii< array.length; ii++)
            {
                System.out.println(array[ii].toString()); 
                //printed out to terminal 
            }
            //give option to save to file 
            
        }
    }
    /*************************************************************
     * SUBMODULE: search                                         *
     * IMPORT:DSALinkedList list, int div                        *
     * EXPORT: NONE                                              *
     * ASSERTION: this function searches through 1 options from  *
     *            a division based on import value               *
     *************************************************************/ 
    public static void search(DSALinkedList list, int div) 
    {
        Iterator itr = list.iterator(); 
        Candidate candid; 
        DSAQueue queue = new DSAQueue(); //dont know how much
        int count,choice; 
        int howMany;

        while(itr.hasNext())
        {
            candid = (Candidate) itr.next(); 
            if(candid.getDivID() == div) //filter by one option for divisions 
            {
                queue.enqueue(candid); //queue anything that matches 
            }
        }
        count = queue.getCount(); 
        if(count == 0)
        {
            System.out.println("Nothing in queue: Nothing to order"); 
        }
        else
        {
            Candidate[] array = new Candidate[count]; 
            for(int i=0;i<count; i++)
            {
                array[i] = (Candidate) queue.dequeue(); 
                //added to an array 
            }
            howMany = orderMany(); 
            decideOrder(howMany,array); 
            
            for(int ii=0; ii< array.length; ii++)
            {
                System.out.println(array[ii].toString()); 
            }
        }

    }
    
    /*************************************************************
     * SUBMODULE: search                                         *
     * IMPORT:DSALinkedList list, String word, char which        *
     * EXPORT: NONE                                              *
     * ASSERTION: this function searches through 1 options from  *
     *            a party/state based on char value which        *
     *************************************************************/ 
    public static void search(DSALinkedList list, String word, char which) 
    {
        Iterator itr = list.iterator(); 
        Candidate candid; 
        DSAQueue queue = new DSAQueue(); //dont know how much
        int count, choice; 
        String result;   
        int howMany;    
        

        while(itr.hasNext())
        {
            candid = (Candidate) itr.next(); 
            //iterate through 1 criteria either party or state 
            if(which == 'P')
            {
                result = candid.getParty(); 
                //dependin on variable which it decides what string to acquire 
            }
            else
            {
                result = candid.getState(); 
            }

            if(word.equalsIgnoreCase(result))
            {
                queue.enqueue(candid); 
                //if it matches queue it 
            }
        }

        count = queue.getCount(); 
        if(count == 0)
        {
            System.out.println("Nothing in queue: Nothing to order"); 
        }
        else
        {
                       
            Candidate[] array = new Candidate[count]; 
            for(int i=0;i<count; i++)
            {
                array[i] = (Candidate) queue.dequeue(); 
                //array for merging 
            }
            howMany = orderMany(); 
            //how many categories to order by 
            decideOrder(howMany,array); 
            
            
            for(int ii=0; ii< array.length; ii++)
            {
                System.out.println(array[ii].toString()); 
            }
            //option to save and write out to a file 
            
        }

    }

  
    /*************************************************************
     * SUBMODULE: orderBy                                        *
     * IMPORT:NONE                                               *
     * EXPORT: int input                                         *
     * ASSERTION: this function asks users by want they want to  *
     *            order by                                       *
     *************************************************************/ 
    public static int orderBy() 
    {
        int input; 
        Scanner sc = new Scanner(System.in); 
       
        try
        {
            do
            {
                System.out.println("Input a number to order by (1)Surname (2)State (3)Party (4)Division"); 
                //selects how merge is going to happen based on which category to order by 
                input = sc.nextInt();
            }while((input>4) && (input<1));
            //while the inout si more than 4 and less than 1 keep looping 
          
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please input a Number");
            //flush any string input 
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
                        
            input = sc.nextInt();
        }
        return input; 
    }
}
