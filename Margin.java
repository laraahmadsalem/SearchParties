/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class facilitates the handling of calculating *
*          the margins and listing them accordingly           *
* Date Created: October 5, 2018                               *
* Date Modified: October 15, 2018                              *
***************************************************************/
import java.util.*;
import java.io.*; 

public class Margin
{
    /************************************************************
    * SUBMODULE: getMargin                                      *
    * IMPORT:DSALinkedList list, DSAQueue location,String party *
    *        double threshold                                   * 
    * EXPORT: DSAQueue location                                 *
    * Assertion: calculates margin for desired party using this * 
    *            function and does the calculation of seats in  * 
    *            another                                        * 
    *************************************************************/

    public static DSAQueue getMargin(DSALinkedList list, DSAQueue location,String party,double threshold)
    {
     
        Iterator itr = list.iterator(); //getting iterator
        State state; 
        int iD; 
        double margin; 

        DSAQueue margins = new DSAQueue(); 
        DSAQueue temp = new DSAQueue(); 

        BinarySearchTree tree = new BinarySearchTree(); //create binary tree to add margins only to make sure that a unique division
                                                        //is being added each time and no data duplication occurs  

        System.out.println("LISTING BY MARGIN: ");
        System.out.println("------------------"); 
        System.out.println(); 

        while(itr.hasNext()) // goes through the list while it is not empty 
        {
            state = (State) itr.next(); //gets each state object one by one 
            
            iD = state.getDivID(); //gets the division ID 

            margin = doCalc(iD,party,list); //gets marginal seat using the division ID and party name
   

   
            if((margin <= threshold) && (margin >= -(threshold))) //if its within the threshold then add to the tree
            {
              
                if(tree.find(iD) == false) //uses the trees find function to make sure division being added in is unique 
                {
               
                    tree.insert(iD,state.getDivNm());

                    location.enqueue(state.getDivNm());
                    margins.enqueue(String.valueOf(margin));
                    temp.enqueue(state.getDivNm());

                    
                    System.out.println("Division: " +iD+ " Margin: " +margin+ " Location: " +state.getDivNm()); //prints out division to terminal 
                }

            }
        }
        
        if(UserInput.yesOrNo() == 1) //if they want to write margins to file 
        {
            String fileName = UserInput.nameOfFile();
            FileIO.writeToFile(temp,margins,fileName);
       
        }
        return location; //queue is returned for future use like for the graph 
    }

    /************************************************************
    * SUBMODULE: doCalc                                         *
    * IMPORT:int iD,String party,DSALinkedList list             *
    * EXPORT: double margin                                     *
    * Assertion: calculates margin for each seat                *
    *************************************************************/
    public static double doCalc (int iD,String party,DSALinkedList list)
    {
        double votefor=0,voteagainst=0; //any ordinary vote with same party name is votes for 
        Iterator itr = list.iterator(); 
        State can; 
        double margin; 
        double percent;

        while(itr.hasNext()) //while values exist in the linked list 
        {
            can = (State) itr.next(); 
            if(iD == can.getDivID()) //if the division ID matches the one we are looking for
            {
                if(party.equalsIgnoreCase(can.getPartyAb())) //if party matches then add that as votes for 
                {
                    votefor = votefor + can.getVotes(); //just add onto the same value constantly 
  
                }
                else //anything else with the same division name but different party name is a vote against
                {
                    voteagainst = voteagainst + can.getVotes(); 
              
                }
            }
        }
        percent = (votefor / (votefor+voteagainst))*100; //get percentage level by dividing by total votes
      
        margin = (percent - 50); //subtract by 50 to get margin 
  
        return margin; 
    }
}    
