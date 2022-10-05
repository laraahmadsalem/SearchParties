/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the sorts Objects using         *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: August 12, 2018                               *
* Date Modified: October 8, 2018                              *
***************************************************************/
import java.util.*;
import java.io.*; 
/*
* NOTE: PART OF THIS CODE WAS PREVIOUSLY SUBMITTED FOR PRAC 2 
*       OF THE DSA PRACTCICALS. Retrieved: October 5 2018
*/
public class Sorts
{

    /************************************************************
    * SUBMODULE: mergeSortAll                                   *
    * IMPORT: Candidate[] A                                     * 
    * EXPORT: NONE                                              *
    * Assertion: sorts data by merging using every single option* 
    *************************************************************/
    public static void mergeSortAll(Candidate[] A)
    {
      mergeSort(A,4); //This function sorts everything through merging 
      mergeSort(A,3); //from the four different categories 
      mergeSort(A,2); //with surname being a priority which is  why 
      mergeSort(A,1); //its sorted the last 
    }
    /************************************************************
    * SUBMODULE: mergeSort                                      *
    * IMPORT:Candidate[] A,int choice1,int choice2,int choice3  * 
    * EXPORT: NONE                                              *
    * Assertion: calls the merge sort function according to     * 
    *            three different options                        * 
    *************************************************************/
    public static void mergeSort(Candidate[] A, int choice1, int choice2, int choice3)
    {
       if ((choice1 == 1) && (choice2 == 2) && (choice3 == 3)) //takes into account all the different options that can arise
       {
          mergeSort(A,3); //based on three choices 
          mergeSort(A,2);
          mergeSort(A,1);
       }
       else if ((choice1 == 1) && (choice2 == 3) && (choice3 == 2)) 
       {
          mergeSort(A,2); //according to every choice that is selected first 
          mergeSort(A,1);
          mergeSort(A,3);
       }
       else if ((choice1 == 2) && (choice2 == 1) && (choice3 == 3)) 
       {
          mergeSort(A,3); //So choice1 will always be a priority which is why its always going to be sorted last 
          mergeSort(A,1);
          mergeSort(A,2);
       }
       else if ((choice1 == 2) && (choice2 == 3) && (choice3 == 1)) 
       {
          mergeSort(A,1);
          mergeSort(A,3);
          mergeSort(A,2);
       }
       else if ((choice1 == 3) && (choice2 == 1) && (choice3 == 2))
       {
          mergeSort(A,2); //it may seem like a tedious process but i wanted to take into account every different possibility 
          mergeSort(A,1);//that could arise 
          mergeSort(A,3);
       }
       else if ((choice1 == 3) && (choice2 == 2) && (choice3 == 1)) 
       {
          mergeSort(A,1);
          mergeSort(A,2);
          mergeSort(A,3);
       }
       else if ((choice1 == 1) && (choice2 == 3) && (choice3 == 4)) 
       {
          mergeSort(A,4);
          mergeSort(A,3);
          mergeSort(A,1);
       }
       else if ((choice1 == 1) && (choice2 == 4) && (choice3 == 3)) 
       {
          mergeSort(A,3);
          mergeSort(A,4);
          mergeSort(A,1);
       }
       else if ((choice1 == 3) && (choice2 == 1) && (choice3 == 4)) 
       {
          mergeSort(A,4);
          mergeSort(A,1);
          mergeSort(A,3);
       }
       else if ((choice1 == 3) && (choice2 == 4) && (choice3 == 1)) 
       {
          mergeSort(A,1);
          mergeSort(A,4);
          mergeSort(A,3);
       }
       else if ((choice1 == 4) && (choice2 == 1) && (choice3 == 3)) 
       {
          mergeSort(A,3);
          mergeSort(A,1);
          mergeSort(A,4);
       }
       else if ((choice1 == 4) && (choice2 == 3) && (choice3 == 1)) 
       {
          mergeSort(A,1);
          mergeSort(A,3);
          mergeSort(A,4);
       }
       else if((choice1 == 1) && (choice2 == 2) && (choice3 == 4))
       {
          mergeSort(A,4);
          mergeSort(A,2);
          mergeSort(A,1);
       }
       else if ((choice1 == 1) && (choice2 == 4) && (choice3 == 2)) 
       {
          mergeSort(A,2);
          mergeSort(A,4);
          mergeSort(A,1);
       }
       else if ((choice1 == 2) && (choice2 == 1) && (choice3 == 4)) 
       {
          mergeSort(A,4);
          mergeSort(A,1);
          mergeSort(A,2);
       }
       else if ((choice1 == 2) && (choice2 == 4) && (choice3 == 1)) 
       {
          mergeSort(A,1);
          mergeSort(A,4);
          mergeSort(A,2);
       }
       else if((choice1 == 4) && (choice2 == 1) && (choice3 == 2)) 
       {
          mergeSort(A,2);
          mergeSort(A,1);
          mergeSort(A,4);
       }
       else if ((choice1 == 4) && (choice2 == 2) && (choice3 == 1)) 
       {
          mergeSort(A,1);
          mergeSort(A,2);
          mergeSort(A,4);
       }
       else if ((choice1 == 2) && (choice2 == 3) && (choice3 == 4)) 
       {
          mergeSort(A,4);
          mergeSort(A,3);
          mergeSort(A,2);
       }
       else if ((choice1 == 2) && (choice2 == 4) && (choice3 == 3)) 
       {
          mergeSort(A,3);
          mergeSort(A,4);
          mergeSort(A,2);
       }
       else if ((choice1 == 3) && (choice2 == 2) && (choice3 == 4)) 
       {
          mergeSort(A,4);
          mergeSort(A,2);
          mergeSort(A,3);
       }
       else if ((choice1 == 3) && (choice2 == 4) && (choice3 == 2)) 
       {
          mergeSort(A,2);
          mergeSort(A,4);
          mergeSort(A,3);
       }
       else if ((choice1 == 4) && (choice2 == 2) && (choice3 == 3)) 
       {
          mergeSort(A,3);
          mergeSort(A,2);
          mergeSort(A,4);
       }
       else if ((choice1 == 4) && (choice2 == 3) && (choice3 == 2)) 
       {
          mergeSort(A,2);
          mergeSort(A,3);
          mergeSort(A,4);
       }

    }

    /************************************************************
    * SUBMODULE: mergeSort                                      *
    * IMPORT:Candidate[] A,int choice1,int choice2              * 
    * EXPORT: NONE                                              *
    * Assertion: calls the merge sort function according to     * 
    *            two different options                          * 
    *************************************************************/
    public static void mergeSort(Candidate[] A,int choice1, int choice2)
    {
      if(((choice1 == 2) && (choice2 == 1))) //state & surname
      {
        mergeSort(A,1);
        mergeSort(A,2); 
      }
      else if(((choice1 == 1) && (choice2 == 2)))//surname & state
      {
        mergeSort(A,2);
        mergeSort(A,1); 
      }
      else if ((choice1 == 3) && (choice2 == 1)) //party & surname
      {
        mergeSort(A,1);
        mergeSort(A,3); 
      }
      else if((choice1 == 1) && (choice2 == 3)) //surname & party
      {
        mergeSort(A,3);
        mergeSort(A,1); 
      }
      else if((choice1 == 1) && (choice2 == 4)) //surname & division
      {
        mergeSort(A,4);
        mergeSort(A,1); 
      }
      else if((choice1 == 4) && (choice2 == 1)) //division & surname
      {
        mergeSort(A,1);
        mergeSort(A,4); 
      }
      else if(((choice1 == 2) && (choice2 == 3))) //state & party
      {
        mergeSort(A,3);
        mergeSort(A,2); 
      }
      else if ((choice1 == 3) && (choice2 == 2)) //party & state 
      {
        mergeSort(A,2);
        mergeSort(A,3); 
      }
      else if((choice1 == 4) && (choice2 == 2)) //division & state
      {
        mergeSort(A,2);
        mergeSort(A,4); 
      }
    }

    /************************************************************
    * SUBMODULE: mergeSort                                      *
    * IMPORT:Candidate[] A,int choice1                          * 
    * EXPORT: NONE                                              *
    * Assertion: calls the merge sort function according to     * 
    *            option selected                                * 
    *************************************************************/
    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(Candidate[] A, int choice) //takes in an extra parametre to filter by which sort to use
    { 
      switch(choice)
      {
        case 1: 
        mergeSortRecurseSurname(A, 0, A.length-1);
        break; 

        case 2: 
        mergeSortRecurseState(A, 0, A.length-1);
        break; 

        case 3:
        mergeSortRecurseParty(A, 0, A.length-1);
        break; 

        case 4: 
        mergeSortRecurseDivision(A, 0, A.length-1);
        break; 

      }
      
    }//mergeSort()
    
    //recursively calls the merge sort function for division 
    private static void mergeSortRecurseDivision(Candidate[] A, int leftIdx, int rightIdx)
    {
      if(leftIdx < rightIdx)
      {
        int midIdx = ((leftIdx + rightIdx) / 2 ); 
        mergeSortRecurseDivision(A,leftIdx, midIdx); 
        mergeSortRecurseDivision(A, midIdx+1,rightIdx);

        mergeDivision(A, leftIdx, midIdx, rightIdx);
      }    
    }//mergeSortRecurse()

    //merge sorts everything according to the divison keys in the objects 
    private static void mergeDivision(Candidate[] A, int leftIdx, int midIdx, int rightIdx)
    {
      Candidate[] tempArr = new Candidate[rightIdx - leftIdx + 1]; 
      int ii = leftIdx; 
      int jj = midIdx + 1; 
      int kk = 0; 

      while ((ii <= midIdx) && (jj <= rightIdx)) 
      {
        if (A[ii].getDivID() <= A[jj].getDivID())
        {
          tempArr[kk] = A[ii]; 
          ii = ii+1; 
        }
        else 
        {
          tempArr[kk] = A[jj]; 
          jj = jj + 1; 
        }
        kk = kk + 1; 
      }

     for(ii=ii ; ii <= midIdx; ii++)
     {
       tempArr[kk] = A[ii]; 
       kk = kk +1; 
     }

     for(jj=jj ; jj <= rightIdx; jj++)
     {
       tempArr[kk] = A[jj]; 
       kk = kk + 1; 
     }

     for(kk = leftIdx; kk <= rightIdx; kk++)
     {
       A[kk] = tempArr[(kk-leftIdx)]; 
     }

    }//merge()    

    //recursively calls the merge sort for party 
    private static void mergeSortRecurseParty(Candidate[] A, int leftIdx, int rightIdx)
    {
      if(leftIdx < rightIdx)
      {
        int midIdx = ((leftIdx + rightIdx) / 2 ); 
        mergeSortRecurseParty(A,leftIdx, midIdx); 
        mergeSortRecurseParty(A, midIdx+1,rightIdx);

        mergeParty(A, leftIdx, midIdx, rightIdx);
      }    
    }//mergeSortRecurse()


    //sorts the array according to comparing by the party name
    private static void mergeParty(Candidate[] A, int leftIdx, int midIdx, int rightIdx)
    {
      Candidate[] tempArr = new Candidate[rightIdx - leftIdx + 1]; 
      int ii = leftIdx; 
      int jj = midIdx + 1; 
      int kk = 0; 

      while ((ii <= midIdx) && (jj <= rightIdx)) 
      {
        if ((A[ii].getParty().compareTo(A[jj].getParty())<0) || (A[ii].getParty().compareTo(A[jj].getParty()) == 0))
        {
          tempArr[kk] = A[ii]; 
          ii = ii+1; 
        }
        else 
        {
          tempArr[kk] = A[jj]; 
          jj = jj + 1; 
        }
        kk = kk + 1; 
      }

     for(ii=ii ; ii <= midIdx; ii++)
     {
       tempArr[kk] = A[ii]; 
       kk = kk +1; 
     }

     for(jj=jj ; jj <= rightIdx; jj++)
     {
       tempArr[kk] = A[jj]; 
       kk = kk + 1; 
     }

     for(kk = leftIdx; kk <= rightIdx; kk++)
     {
       A[kk] = tempArr[(kk-leftIdx)]; 
     }

    }//merge()    

    //recursively calls the merge sort for state 
    private static void mergeSortRecurseState(Candidate[] A, int leftIdx, int rightIdx)
    {
      if(leftIdx < rightIdx)
      {
        int midIdx = ((leftIdx + rightIdx) / 2 ); 
        mergeSortRecurseState(A,leftIdx, midIdx); 
        mergeSortRecurseState(A, midIdx+1,rightIdx);

        mergeState(A, leftIdx, midIdx, rightIdx);
      }    
    }//mergeSortRecurse()


    //compares by state when sorting
    private static void mergeState(Candidate[] A, int leftIdx, int midIdx, int rightIdx)
    {
      Candidate[] tempArr = new Candidate[rightIdx - leftIdx + 1]; 
      int ii = leftIdx; 
      int jj = midIdx + 1; 
      int kk = 0; 

      while ((ii <= midIdx) && (jj <= rightIdx)) 
      {
        if ((A[ii].getState().compareTo(A[jj].getState())<0) || (A[ii].getState().compareTo(A[jj].getState()) == 0))
        {
          tempArr[kk] = A[ii]; 
          ii = ii+1; 
        }
        else 
        {
          tempArr[kk] = A[jj]; 
          jj = jj + 1; 
        }
        kk = kk + 1; 
      }

     for(ii=ii ; ii <= midIdx; ii++)
     {
       tempArr[kk] = A[ii]; 
       kk = kk +1; 
     }

     for(jj=jj ; jj <= rightIdx; jj++)
     {
       tempArr[kk] = A[jj]; 
       kk = kk + 1; 
     }

     for(kk = leftIdx; kk <= rightIdx; kk++)
     {
       A[kk] = tempArr[(kk-leftIdx)]; 
     }

    }//merge()

    //recursively calls merge sort surname
    private static void mergeSortRecurseSurname(Candidate[] A, int leftIdx, int rightIdx)
    {
      if(leftIdx < rightIdx)
      {
        int midIdx = ((leftIdx + rightIdx) / 2 ); 
        mergeSortRecurseSurname(A,leftIdx, midIdx); 
        mergeSortRecurseSurname(A, midIdx+1,rightIdx);

        mergeSurname(A, leftIdx, midIdx, rightIdx);
      }    
    }//mergeSortRecurse()

    //sorts array by alphabetical order using surname 
    private static void mergeSurname(Candidate[] A, int leftIdx, int midIdx, int rightIdx)
    {
      Candidate[] tempArr = new Candidate[rightIdx - leftIdx + 1]; 
      int ii = leftIdx; 
      int jj = midIdx + 1; 
      int kk = 0; 

      while ((ii <= midIdx) && (jj <= rightIdx)) 
      {
        if ((A[ii].getSurname().compareTo(A[jj].getSurname())<0) || (A[ii].getSurname().compareTo(A[jj].getSurname()) == 0))
        {
          tempArr[kk] = A[ii]; 
          ii = ii+1; 
        }
        else 
        {
          tempArr[kk] = A[jj]; 
          jj = jj + 1; 
        }
        kk = kk + 1; 
      }

     for(ii=ii ; ii <= midIdx; ii++)
     {
       tempArr[kk] = A[ii]; 
       kk = kk +1; 
     }

     for(jj=jj ; jj <= rightIdx; jj++)
     {
       tempArr[kk] = A[jj]; 
       kk = kk + 1; 
     }

     for(kk = leftIdx; kk <= rightIdx; kk++)
     {
       A[kk] = tempArr[(kk-leftIdx)]; 
     }

    }//merge()
}