 /**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class is responsible for all the FileIO       *
*          submodules to handle all the files when reading in *
* Date Created: October 6, 2018                               *
* Date Modified: October 19, 2018                             *
***************************************************************/

import java.util.*; 
import java.io.*; 

public class FileIO
{

  /************************************************************
  * SUBMODULE: createLocation                                 *
  * IMPORT: fileName(String), graph (DSAGraph)                *
  * EXPORT:  graph (DSAGraph)                                 *
  * ASSERTION: Reads in a file and creates objects based on   *
  *            the data then returns a graph of Location      *
  *************************************************************/
  public static DSAGraph createLocation (String fileName, DSAGraph graph)
  {
    String[] array = new String [11]; 
    String line; 
    double lat1,lat2,long1,long2;
    int time,distance; 
   
    try
    {
      FileInputStream fileStrm = new FileInputStream (fileName);
      InputStreamReader  rdr = new InputStreamReader (fileStrm);
      BufferedReader  bufRdr = new BufferedReader (rdr);
      //crestates buffered stream 

      line = bufRdr.readLine();
      line = bufRdr.readLine();  
      //reads the second line because the first is a header
   
      while(line != null)
      {
        array = processString(line); 
        if((stringValid(array[0])) && (stringValid(array[1])) && (stringValid(array[4])) && (stringValid(array[5])) && (stringValid(array[10])) )
        {
            //validates strings 
            lat1 =  Double.parseDouble(array[2]);
            long1 = Double.parseDouble(array[3]); //parses all values that arent supposed to be strings 
            lat2 = Double.parseDouble(array[6]); 
            long2 = Double.parseDouble(array[7]); 
            distance = Integer.parseInt(array[8]);
            time = Integer.parseInt(array[9]); //split on : for some of the time 

            LocationV from = new LocationV(array[0],lat1,long2); 
            LocationV to = new LocationV(array[4],lat2,long2); 

            graph.addVertex(array[1],from); 
            //adds vertex with information about longitude latitude and how to get there 
            graph.addVertex(array[5],to); 
            //add vertex 

            graph.addEdge(array[1],array[5],array[10],time,distance); 
            //adds two vertices and extra infor like time & distance 
           
        }     
        line = bufRdr.readLine();
        //read line until its not null 
      }
      fileStrm.close();
      //close stream 
    }

    catch (IOException e)
    {
      System.out.println("Error: Reading File" +e.getMessage());
    }

    return graph; 
  }


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
* SUBMODULE: createCandidate                                *
* IMPORT: fileName(String), list (DSALinkedList)            *
* EXPORT: list (DSALinkedList)                              *
* ASSERTION: Reads in a file and creates objects based on   *
*            the data then returns a  list of Objects       *
*************************************************************/

public static DSALinkedList createCandidate (String fileName, DSALinkedList list)
{
   String[] array = new String[10]; 
   //array of ten values for line that has split data 
   String line; 
   int division; 
   int cand; 
   try
   {
         FileInputStream fileStrm = new FileInputStream (fileName);
         InputStreamReader  rdr = new InputStreamReader (fileStrm);
         BufferedReader  bufRdr = new BufferedReader (rdr);
         //creates a file input stream 
          
         line = bufRdr.readLine(); 
         line = bufRdr.readLine(); 
         line = bufRdr.readLine(); 
         //reads the third line because the first two are headers

         while (line != null)
         {
          
             array = processString(line); 

             if ((stringValid(array[0])) && (stringValid(array[2])) && (stringValid(array[3])) && (stringValid(array[4])) && (stringValid(array[6])) && (stringValid(array[7])))
             {
               division = Integer.parseInt(array[1]); 
               cand = Integer.parseInt(array[5]); //parses values that arent meant to be a string 

               Candidate candidate = new Candidate(array[0], division, array[2], array[3], array[4], cand, array[6], array[7], array[8].charAt(0), array[9].charAt(0));
               list.insertFirst(candidate);
               //inserts into list 


             } 
        

              line = bufRdr.readLine(); //reads new line 
        }
          fileStrm.close(); //closes stream 
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
  // Obtained from Rex Egg, https://www.rexegg.com/regex-quickstart.html
  // (accessed 9 October 2018). 
  for(String word:line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) 
  {
    //split on a comma followed by a non capture group then 0 or more non quote character 
    //then when " is visible ignore everything inside quote then end with a " and continue on until with the non quotes 
    //in the line 
    lineArray[i] = word; 
    //each split of the one line is stored in the field 
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

/*display method of the list used for testing purposes only */ 
public static void display (DSALinkedList list)
{
  Iterator itr = list.iterator(); 
  while(itr.hasNext())
  {
    Candidate word = (Candidate) itr.next(); 
    System.out.println(word.toString()); 
  }
}

/*display method of list using for testing purposes */ 
public static void displayS (DSALinkedList list)
{
  Iterator itr = list.iterator(); 
  while(itr.hasNext())
  {
    State word = (State) itr.next(); 
    System.out.println(word.toString()); 
  }
}
/************************************************************
* SUBMODULE: writeToFile                                    *
* IMPORT: newArray (ARRAY OF String)                        *
* EXPORT: none                                              *
* ASSERTION: writes the array to a .txt file                *
*                                                           *
*                                                           *
*************************************************************/
public static void writeToFile (Candidate[] array, String fileName)
{
  Scanner sc = new Scanner(System.in);
  FileOutputStream fileStrm = null;
  PrintWriter pw;
  

  try {
        fileStrm = new FileOutputStream(fileName);
        pw = new PrintWriter (fileStrm);
      
       //uses for loop to write to file depending on storage 
      for (int i=0; i< array.length; i++)
          {  
            if(array[i] != null)
            {
                  pw.println(array[i].toString());
            }
          } 

    
      pw.close();
    }
    catch (IOException e)
      {
        if (fileStrm != null)
        {
            try
              {
                fileStrm.close();
              }
                catch (IOException ex2)
                {
                  System.out.println("Error: Closing File Stream ");
                }
        }
          System.out.println ("error in writing to file: " +e.getMessage());
      }
  }

  //writes a queue to a file 
  public static void writeToFile (DSAQueue queue, String fileName)
  {
    Scanner sc = new Scanner(System.in);
    FileOutputStream fileStrm = null;
    PrintWriter pw;
    
  
    try {
          fileStrm = new FileOutputStream(fileName);
          pw = new PrintWriter (fileStrm);
        
         //uses for loop to write to file depending on storage 
            while(!(queue.isEmpty()))
            {  
              Candidate candid = (Candidate) queue.dequeue();
              if(candid != null)
              {
                    pw.println(candid.toString());
              }
            } 
  
      
        pw.close();
      }
      catch (IOException e)
        {
          if (fileStrm != null)
          {
              try
                {
                  fileStrm.close();
                }
                  catch (IOException f)
                  {
                    System.out.println("Error: Closing File Stream ");
                  }
          }
            System.out.println ("error in writing to file: " +e.getMessage());
        }
    }

    public static void writeToFile (DSAQueue queue,DSAQueue margin, String fileName)
  {
    Scanner sc = new Scanner(System.in);
    FileOutputStream fileStrm = null;
    PrintWriter pw;
    
  
    try {
          fileStrm = new FileOutputStream(fileName);
          pw = new PrintWriter (fileStrm);
        
         //uses for loop to write to file depending on storage 
            while((!(queue.isEmpty()) &&  !(margin.isEmpty())))
            {  
              String candid = (String) queue.dequeue();
       
              String margins = (String) margin.dequeue(); 
              if((candid != null) && (margins != null))
              {
                  pw.println("Division : " +candid+ " Margin: " +margins);
               }
            }
             
  
      
        pw.close();
      }
      catch (IOException e)
        {
          if (fileStrm != null)
          {
              try
                {
                  fileStrm.close();
                }
                  catch (IOException f)
                  {
                    System.out.println("Error: Closing File Stream ");
                  }
          }
            System.out.println ("error in writing to file: " +e.getMessage());
        }
    }
}