/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class is responsible for all the Searching    *
* Date Created: October 6, 2018                               *
* Date Modified: October 19, 2018                             *
***************************************************************/

import java.util.*;


public class Search
{
    /************************************************************
    * SUBMODULE: searchSubstring                                *
    * IMPORT: DSALinkedList list, String lookfor                * 
    * EXPORT: NONE                                              *
    * Assertion: iterates through the list searching for every  * 
    *            surname in the list that has substring         * 
    *************************************************************/

    public static void searchSubstring(DSALinkedList list, String lookFor)
    {
            int choice; 
            Iterator itr = list.iterator(); 
            Candidate candid; 
            DSAQueue queue = new DSAQueue(); 

            while(itr.hasNext()) //iterates through list looking for all the surnames that start with the specified set of letters 
            {
                candid = (Candidate) itr.next(); 
                if(candid.getSurname().startsWith(lookFor)) //if it meets the condition it adds the object to a queue
                {
                    queue.enqueue(candid);
                }

            }
            filter(queue); 
            //sends it off to the filter function that asks for user input on what categories they want to filter by
            
    }
    
    /************************************************************
    * SUBMODULE: printSubstring                                 *
    * IMPORT: DSAQueue queue                                    * 
    * EXPORT: NONE                                              *
    * Assertion: prints out queue that has been filtered        * 
    *************************************************************/

    public static void printSubstring(DSAQueue queue)
    {
        Candidate cand; 

        while(!(queue.isEmpty()))
        {
            cand = (Candidate) queue.dequeue(); //gets each value until the queue contains nothing 
            System.out.println("Substring of word: " +cand.toString());   //this is where is prints the words that were filtered in by the queue 
        }
    }

    /************************************************************
    * SUBMODULE: filter                                         * 
    * IMPORT: DSAQueue que                                      * 
    * EXPORT: NONE                                              *
    * Assertion: directs the users input and decides which      * 
    *            filter function should be used                 * 
    *************************************************************/

    public static int filter(DSAQueue que)
    {
        int choice; 
        String result,result2; 
        DSAQueue newOrder; 
        String fileName;
        DSAQueue temp = new DSAQueue(); 
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Please input (1) Filter Party (2) Filter State (3) Filter State & Party (4) No Filter"); 
            choice = sc.nextInt(); //based on the choice it will send off to appropriate function 

            switch(choice)
            {
                case 1: 
                result = FilterNominees.whichParty(); 
                //asks which party they want in a function that is situated by try catches and error exceptions 
                newOrder = filterBy(que, result, 'P');
                temp = newOrder; 

                if(UserInput.yesOrNo() == 1)
                {
                    fileName = UserInput.nameOfFile(); 
                    Iterator q = newOrder.iterator();
                    while(q.hasNext())
                    {
                        Candidate candid = (Candidate) q.next(); 
                        temp.enqueue(candid);
                    }
                    FileIO.writeToFile(newOrder,fileName); 
                    printSubstring(temp);
                }
                else //if they dont want to read original queue will be printed 
                {
                    printSubstring(newOrder);
                }
                break; 

                case 2: 
                result = FilterNominees.whichState(); 
                newOrder = filterBy(que, result, 'S'); 
                //uses the result and filters everything by required state
                if(UserInput.yesOrNo() == 1)
                {
                    fileName = UserInput.nameOfFile();
                    Iterator q = newOrder.iterator();
                    while(q.hasNext())
                    {
                        Candidate candid = (Candidate) q.next(); 
                        temp.enqueue(candid); //enqueing objects to print to terminal 
                    }
                    FileIO.writeToFile(newOrder,fileName);
               
                    printSubstring(temp);
                }
                else
                {
                    printSubstring(newOrder);
                }
                break; 

                case 3: 
                result = FilterNominees.whichState(); 
                result2 = FilterNominees.whichParty(); 
                newOrder = filterBy(que,result,result2);
      
                if(UserInput.yesOrNo() == 1) //would they like to write to a file 
                {
                    fileName = UserInput.nameOfFile();
                    Iterator q = newOrder.iterator();
                    while(q.hasNext())
                    {
                        Candidate candid = (Candidate) q.next(); //copying objects to queue to print to terminal 
                        temp.enqueue(candid);
                    }
                    FileIO.writeToFile(newOrder,fileName);
               
                    printSubstring(temp);
                }
                else
                {
                    printSubstring(newOrder);
                }
                //once its done it prints out all results that were filtered 
                break;

                case 4:
                //if no option was selected to filter then just prints everything that is in the queue that has that substring 
                if(UserInput.yesOrNo() == 1)
                {
                    fileName = UserInput.nameOfFile(); 
                
                    Iterator q = que.iterator();
                    while(q.hasNext()) //queue is passed by value so im iterating and copying objects so i can print to terminal
                    {
                        Candidate candid = (Candidate) q.next(); 
                        temp.enqueue(candid); //and save to file 
                    }
                    FileIO.writeToFile(que,fileName);
               
                    printSubstring(temp);
                
                }
                else
                {
                    printSubstring(que);
                }  
                break; 

                default:
                System.out.println("Invalid Option Returning To Main !");
                break;


            }
        }
        catch(InputMismatchException e) 
        {
            System.out.println("Please input a Number");//error handling
            String flush = sc.nextLine();
            System.out.println( "Error you cannot enter letters." );
                           
            choice = sc.nextInt();
        }
        return choice; 
    }

    /************************************************************
    * SUBMODULE: filterBy                                       *
    * IMPORT: DSAQueue que,String state, String party           * 
    * EXPORT: DSAQueue queue                                    *
    * Assertion: filters by both state and party and adds to    *
    *            a queue to be printed out                      * 
    *************************************************************/

    public static DSAQueue filterBy(DSAQueue que,String state, String party) 
    {
        Iterator itr = que.iterator(); 
        Candidate candid; 
        DSAQueue queue = new DSAQueue(); 
   
        //if they want to filter by both state and a party then this function is called 
        while(itr.hasNext())
        {
            candid = (Candidate) itr.next();   //iterates through queue and tests this conditonal statement

            if((state.equalsIgnoreCase(candid.getState())) && ( party.equalsIgnoreCase(candid.getParty())))
            {
                queue.enqueue(candid); //creates a new queue and inserts all the filtered data in there
            }
        }
        return queue; 
    }
    
    /************************************************************
    * SUBMODULE: filterBy                                       *
    * IMPORT: DSAQueue que,String word, String which            * 
    * EXPORT: DSAQueue queue                                    *
    * Assertion: filters by both state or party and adds to    *
    *            a queue to be printed out                      * 
    *************************************************************/

    public static DSAQueue filterBy(DSAQueue que, String word, char which)
    {
        Iterator itr = que.iterator(); 
        Candidate candid; 
        DSAQueue queue = new DSAQueue(); 
        String result; 

        //created a modular function that uses a char to differentiate between what to filter by 
        //The reason for this was to create modularity and avoid code duplication 
        while(itr.hasNext())
        {
            candid = (Candidate) itr.next(); 

            if(which == 'P')
            {
                result = candid.getParty(); //since both party and state are strings 
                //it was easy to just use the char and assign result to whichever 
                //char the variable 'which' is
            }
            else
            {
                result = candid.getState(); 
            }

            if(word.equalsIgnoreCase(result))
            {
                queue.enqueue(candid); //queues anything that matches what user inputs 
            }
        }
        return queue; 
    }
}
