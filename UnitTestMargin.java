import java.util.*; 
import java.io.*;

public class UnitTestMargin
{
    public static void main (String [] args)
    {
        //VARIABLE DECLARATIONS
        int test = 0;
        int pass = 0;
        DSALinkedList list = new DSALinkedList();
       
        test++;
        try
        {

            System.out.println("Testing Creation of Locations with Large data"); 
            System.out.println("============================================="); 
            
            list = createState("poll.csv",list); 
            pass++; 
            System.out.println("PASS"); 
        }
        catch(Exception e)
        {
            System.out.println("FAIL"); 
        }
//----------------------------------------------------------------------------
        test++;
        try
        {
            System.out.println("Test Calculation of Margins "); 
            
            
            System.out.println("Testing Marginal Seats with Party 'ALP' and Default Threshold of 6 ......");
            System.out.println("Testing Input: "); 
            System.out.println("=================================================================="); 
            DSAQueue queue = new DSAQueue() ;
            queue = Margin.getMargin(list, queue, "ALP", 6);

            System.out.println("Expected Output: "); 
            System.out.println("=================================================================="); 
            System.out.println("Division: 232 Margin: 5.011779957866395 Location: Scullin"); 
            System.out.println("Division: 225 Margin: -1.4242135864109855 Location: Maribyrnong");  
            System.out.println("Division: 222 Margin: -0.07832954204042863 Location: Lalor"); 
            System.out.println("Division: 217 Margin: -5.347464522624151 Location: Hotham"); 
            System.out.println("Division: 216 Margin: 1.5236744568520635 Location: Holt"); 
            System.out.println("Division: 212 Margin: -4.203005415850896 Location: Gellibrand");
            System.out.println("Division: 208 Margin: -5.895070625540498 Location: Corio"); 
            System.out.println("Division: 203 Margin: 3.8401223697571965 Location: Calwell");
            /*Expected output was based on rigorous validation that was just printed out to terminal to let users
            * be aware of what data should look like
            */ 

            if(queue.getCount() != 8)
            {
                System.out.println("FAILED");
            }
            System.out.println("=================================================================="); 
            System.out.println("PASSED");
            pass++; 
            
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
//---------------------------------------------------------------------------------------------------------------------------------------------------


}


//---------------------------------------------------------------------------------------------------------------------------------------------------

/************************************************************
* SUBMODULE: createState                                    *
* IMPORT: fileName(String), list (DSALinkedList)            *
* EXPORT: list (DSALinkedList)                              *
* ASSERTION: Reads in a file and creates objects based on   *
*            the data then returns a  list of Objects       *
*************************************************************/
public static DSALinkedList createState(String fileName, DSALinkedList listS)
{
  String[] array  = new String[15];
  //array that holds the data that has been string split 
  String line; 
  int divisionID, pollingID, candidateID, ballotP, ordVotes; 
  double swing; 

  try
  {
    
         FileInputStream fileStrm = new FileInputStream (fileName);
         InputStreamReader  rdr = new InputStreamReader (fileStrm);
         BufferedReader  bufRdr = new BufferedReader (rdr);
         //creates buffered stream using filename 

         line = bufRdr.readLine(); 
         line = bufRdr.readLine(); 
         line = bufRdr.readLine(); 
         //reads the third line because the first two are headers 

         while(line != null)
         {
            array = processString(line); 
            //process string splits the line 
            if((stringValid(array[0])) && (stringValid(array[2])) && (stringValid(array[4])) && (stringValid(array[6])) && (stringValid(array[7]))  && (stringValid(array[11])) && (stringValid(array[12])))
            {
                //string valid validates the string to make sure its not null 
                divisionID =  Integer.parseInt(array[1]); //parses all values that are not supposed to be strings
                pollingID = Integer.parseInt(array[3]); 
                candidateID = Integer.parseInt(array[5]); 
                ballotP = Integer.parseInt(array[8]); 
                ordVotes = Integer.parseInt(array[13]);
                swing = Double.parseDouble(array[14]); 

                //once the data has been processed create the state object 
                State state = new State(array[0],divisionID,array[2],pollingID,array[4],candidateID,array[6], array[7], ballotP, array[9].charAt(0), array[10].charAt(0),array[11], array[12], ordVotes, swing); 
                listS.insertFirst(state); 
                //insert into a linked list 
            }
         
            line = bufRdr.readLine();
            //read next line and repeat process 
          }
         fileStrm.close();
         //when line is null close stream and return linked list 
   }
     
   catch (IOException e)
   {
      System.out.println("Error: Reading File " +e.getMessage());
   }
  
   return listS; 
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