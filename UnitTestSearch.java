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

public class UnitTestSearch
{
    public static void main(String [] args)
    {
        //VARIABLE DECLARATIONS
        int test = 0; 
        int pass = 0;
        DSALinkedList list = new DSALinkedList();
       
        test++;
        try
        {

            System.out.println("Testing Creation of Candidates"); 
            System.out.println("============================================="); 
            
            list = createCandidate(list); 
            pass++; 
            System.out.println("PASS"); 
        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
        }

        test++; 
        try
        {
            System.out.println("*******************************************************");
            System.out.println("Note: Because this class Requires user input expect to");
            System.out.println("      follow the exact commands this test harness tells");
            System.out.println("      you to ensure you recieve the exact results and ");
            System.out.println("      expected output.");
            System.out.println("*******************************************************");


            System.out.println("Testing Search by Substring with the substring 'ABB'");
            System.out.println("==========================================================");

            System.out.println("This class has been tested thoroughly with test input data");
            System.out.println("STEP 1: WHEN ASKED TO FILTER PRESS TO FILTER BY 3 ");
            System.out.println("(SO YOU CAN TEST FOR FUNCTIONALITY OF BOTH STATE & PARTY");
            System.out.println(" AND SO YOU CAN VERIFY AND TEST THE INPUT WITH EXPECTED OUTPUT)");
            System.out.println("STEP 2: FOR PARTY TYPE 'Liberal' & FOR STATE 'NSW' ");

            System.out.println("===========================================================");

            
            Search.searchSubstring(list,"ABB");
            System.out.println("==========================================================");
            System.out.println("EXPECTED OUTPUT: ");
            System.out.println("Substring of word: STATE: NSW DIVISION ID: 151 DIVISION NAME: Warringah CANDIDATE ID: 28624 SURNAME: ABBOTT NAME: Tony ELECTED: Y HISTORY ELECTED: Y PARTY: Liberal");
            System.out.println("==========================================================");

        


        }
        catch(Exception e)
        {
            System.out.println("FAILED");
        }
    }
        
//----------------------------------------------------------------------------

     /************************************************************
      * SUBMODULE: createCandidate                                *
      * IMPORT: fileName(String), list (DSALinkedList)            *
      * EXPORT: list (DSALinkedList)                              *
      * ASSERTION: Reads in a file and creates objects based on   *
      *            the data then returns a  list of Objects       *
      *************************************************************/

        public static DSALinkedList createCandidate (DSALinkedList list)
        {
            String[] array = new String[10]; 
            String line; 
            int division; 
            int cand; 
    
        
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
                        list.insertLast(candidate);


                    }         

                    line = bufRdr.readLine();
                }
                fileStrm.close();
        }
            
        catch (IOException e)
        {
            System.out.println("error reading file !!");
        }

        return list; 
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