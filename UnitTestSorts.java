/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This test harness ensures that the merge sort works*
*          according to a specific State,party,division or    *
*          surname                                            *
* Date Created: October 16, 2018                               *
* Date Modified: October 17, 2018                              *
***************************************************************/
import java.util.*; 
import java.io.*; 

public class UnitTestSorts
{
    public static void main(String [] args)
    {
        //VARIABLE DECLARATIONS
        int test = 0; 
        int pass = 0; 
        Candidate [] candid = new Candidate[15]; 
//---------------------------------------------------------------------------------------------
        try
        {

            System.out.println("Testing Creation of Candidates"); 
            System.out.println("==============================="); 
            test++;
            candid = createCandidate(); 
            pass++; 
            System.out.println("PASS"); 
        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
        }
//----------------------------------------------------------------------------
        try
        {
            System.out.println("Testing Merge of Surname"); 
            System.out.println("========================"); 
            test++;
            
            Sorts.mergeSort(candid,1); 

            for(int i=0;i<candid.length;i++)
            {
                System.out.println(candid[i].toString());
            }
            pass++; 
            System.out.println("PASS"); 

        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
        }
//-----------------------------------------------------------------------------
        try
        {
            System.out.println("Testing Merge of State"); 
            System.out.println("========================"); 
            test++;
            
            Sorts.mergeSort(candid,2); 

            for(int i=0;i<candid.length;i++)
            {
                System.out.println(candid[i].toString());
            }
            pass++; 
            System.out.println("PASS"); 
        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
        }
//-----------------------------------------------------------------------------
try
{
    System.out.println("Testing Merge of Party"); 
    System.out.println("========================"); 
    test++;
    
    Sorts.mergeSort(candid,3); 

    for(int i=0;i<candid.length;i++)
    {
        System.out.println(candid[i].toString());
    }
    pass++; 
    System.out.println("PASS"); 
}
catch(Exception e)
{
    System.out.println("FAIL"); 
}
//-----------------------------------------------------------------------------
try
{
    System.out.println("Testing Merge of Division"); 
    System.out.println("========================"); 
    test++;
    
    Sorts.mergeSort(candid,4); 

    for(int i=0;i<candid.length;i++)
    {
        System.out.println(candid[i].toString());
    }
    pass++; 
    System.out.println("PASS"); 
}
catch(Exception e)
{
    System.out.println("FAIL"); 
}
//-----------------------------------------------------------------------------
    }


/************************************************************
* SUBMODULE: createCandidate                                *
* IMPORT: fileName(String), list (DSALinkedList)            *
* EXPORT: list (DSALinkedList)                              *
* ASSERTION: Reads in a file and creates objects based on   *
*            the data then returns a  list of Objects       *
*************************************************************/

public static Candidate[] createCandidate ()
{
   String[] array = new String[10]; 
   String line; 
   int division; 
   int cand; 
   int ii=0; 
   Candidate[] candid = new Candidate[15]; 
   try
   {
         FileInputStream fileStrm = new FileInputStream ("testSort.csv");
         InputStreamReader  rdr = new InputStreamReader (fileStrm);
         BufferedReader  bufRdr = new BufferedReader (rdr);
          
         line = bufRdr.readLine();

         while (line != null)
         {
          
             array = processString(line); 

             if ((stringValid(array[0])) && (stringValid(array[2])) && (stringValid(array[3])) && (stringValid(array[4])) && (stringValid(array[6])) && (stringValid(array[7])))
             {
               division = Integer.parseInt(array[1]); 
               cand = Integer.parseInt(array[5]); 

               Candidate candidate = new Candidate(array[0], division, array[2], array[3], array[4], cand, array[6], array[7], array[8].charAt(0), array[9].charAt(0));
               candid[ii] = candidate; 
               ii++; 


             } 
        

          line = bufRdr.readLine();
        }
          fileStrm.close();
    }
   
     catch (IOException e)
     {
       System.out.println("error reading file !!");
     }

 return candid; 
 }

                       
 /************************************************************
* SUBMODULE: processString                                  *
* IMPORT: line (String)                                     *
* EXPORT: stringLine (String)                               *
* ASSERTION: splits the line using regex commands           *
*                                                           *
*************************************************************/ 
public static String[] processString(String line)
{
  int i=0; 
  String [] lineArray = new String[15];
  for(String word:line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) //already referenced in fileIO class 
  {
    lineArray[i] = word; 
    i++; 
  }
  return lineArray;
}

/************************************************************
* SUBMODULE: stringValid                                    *
* IMPORT: word (String)                                     * 
* EXPORT: validate (boolean)                                *
* Assertion: makes sure string is not null                  *        
*************************************************************/
public static boolean stringValid(String word)
{
   boolean validate = false; 
     if (word != null)
     {
         validate = true; 
     }
     return validate; 
}
}