import java.io.*; 
import java.util.*; 

public class UnitTestGraph
{
    public static void main(String [] args)
    {
        DSAGraph graph = new DSAGraph(); 
        int test = 0, pass = 0; 
        
        System.out.println("Testing Graph Class"); 

        try
        {
            test++; 
            System.out.println("Testing Reading in File & Adding in Vertices & Edges"); 
            System.out.println("======================================" ); 
            reader(graph);
            System.out.println("Reading in file: Passed!!"); 
            pass++; 
//--------------------------------------------------------------------------
            test++; 
            System.out.println("Testing the Counts of Edges & Vertices"); 
            System.out.println("======================================" ); 
       
            if((graph.getVertexCount() == 50)&&(graph.getEdgeCount() == 261))
            {
                System.out.println("Count Tester: Passed"); 
                pass++; 
                System.out.println("PASSED");
            }
            else
            {
                throw new IllegalArgumentException("FAILED:COUNT OF EDGE & VERTEX"); 
            }
//--------------------------------------------------------------------------
            test++; 
            System.out.println("==================================");
            System.out.println("Testing display List"); 
            try
            {
                graph.displayList();
                pass++;
                System.out.println("PASSED");
            }
            catch(Exception e)
            {
                System.out.println("FAILED");
            }
//--------------------------------------------------------------------------
            test++; 
            System.out.println("==================================");

            System.out.println("Testing display Matrix"); 

            try
            {
                graph.displayMatrix(); 
                pass++;
                System.out.println("PASSED");
            }
            catch(Exception e)
            {
                System.out.println("FAILED");
            }
//--------------------------------------------------------------------------
                   
        }
        catch(InputMismatchException e)
        {
            System.out.println("Error with File occured: " +e.getMessage()); 
        }
                
    }

//--------------------------------------------------------------------------

        //note: adding of edges and vertices is tested here 
        public static void reader (DSAGraph graph)
        {
            String[] array = new String [11]; 
            String line; 
            double lat1,lat2,long1,long2;
            int time,distance; 
            
            try
            {
                FileInputStream fileStrm = new FileInputStream ("distance.csv");
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

   
}
