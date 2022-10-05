import java.io.*; 
import java.util.*; 

public class UnitTestTree 
{

    public static void main(String [] args) 
    {
        int iNumPassed = 0; 
        int iNumTests = 0; 
        BinarySearchTree tree = new BinarySearchTree();
        
                                       
        //Test with normal condiitons (shouldnt throw exceptions) 
        System.out.println("\n"); 
        System.out.println("Test with Normal Conditions"); 
        System.out.println("==========================="); 
//--------------------------------------------------------------------------------------
        try
        {
            iNumTests++; 
            System.out.println("Testing creation of Tree"); 
            BinarySearchTree tree1 = new BinarySearchTree(); 

            iNumPassed++; 

            System.out.println("PASSED"); 
        }
        catch(Exception e)
        {
            System.out.println("FAILED"); 
        }
//--------------------------------------------------------------------------------------
        try
        {

            iNumTests++;
            System.out.println("Testing insertion of following values and key"); 

            System.out.println("Key: 50, String: cat"); 
            System.out.println("Key: 23, String: dog"); 
            System.out.println("Key: 45, String: llama");
            System.out.println("Key: 16, String: pepito");
            System.out.println("Key: 8, String: crab");
            System.out.println("Key: 29, String: giraffe");
            System.out.println("Key: 80, String: lion");    
            System.out.println("Key: 60, String: tiger");
            System.out.println("Key: 90, String: cow");

            tree.insert(50,"cat");
            tree.insert(23,"dog");
            tree.insert(45,"llama");
            tree.insert(16,"pepito");
            tree.insert(8,"crab");
            tree.insert(29,"giraffe");    
            tree.insert(80,"lion");
            tree.insert(60,"tiger"); 
            tree.insert(90,"cow"); 

            iNumPassed++; 
            
            System.out.println("PASSED"); 
        }
        catch(Exception e)
        {
            System.out.println("FAILED"); 
        }
//--------------------------------------------------------------------------------------
        try
        {

            iNumTests++; 

            System.out.println("Testing find method of Tree..."); 
            System.out.println("Finding key 90"); 
           
            if(tree.find(90) == true)
            {
                System.out.println("Found Key 90!");
                System.out.println("PASSED");
                iNumPassed++;
            }
            else
            {
                throw new IllegalArgumentException("FAILED");
            }

            iNumTests++; 
          
            if(tree.find(29) == true)
            {
                
                System.out.println("Found Key 29!");
                System.out.println("PASSED");
                iNumPassed++;
            }
            else
            {
                throw new IllegalArgumentException("FAILED"); 
            } 
    
        }
        catch(Exception e)
        {
            System.out.println("FAILED"); 
        }

//--------------------------------------------------------------------------------------
        try
        {
            iNumTests++; 
            System.out.println("Testing to delete Node 29"); 
            tree.delete(29); 
            if(tree.find(29) == false)
            {
                System.out.println("PASSED");
                iNumPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            iNumTests++; 
            System.out.println("Testing to delete Node 23"); 
            tree.delete(23);
            if(tree.find(23) == false)
            {
                System.out.println("PASSED");
                iNumPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

           
            
        }
        catch(Exception e)
        {
            System.out.println("FAILED"); 
        }
    
    
//--------------------------------------------------------------------------------------

                       
            // Tests with error conditions (SHOULD throw exceptions)
           // Testing constructor's parameters of ore type and units.
           System.out.println("\n");
   	       System.out.println("Testing Error Conditions - Constructor");
           System.out.println("======================================");
   
        
                 
           iNumTests++; 
           System.out.println("Testing creation of Tree"); 
           BinarySearchTree trees = new BinarySearchTree(); 

           iNumPassed++; 

           System.out.println("PASSED"); 
          
            try
            {        
                iNumTests++;
                System.out.println("Testing insertion of following values and key"); 

                System.out.println("Key: 50, String: cat"); 
                System.out.println("Key: 23, String: dog"); 
                System.out.println("Key: 45, String: llama");
                System.out.println("Key: 16, String: pepito");
                System.out.println("Key: 8, String: crab");
                System.out.println("Key: 29, String: giraffe");
                System.out.println("Key: 80, String: lion");    
                System.out.println("Key: 60, String: tiger");
                System.out.println("Key: 90, String: cow");

                trees.insert(50,"cat");
                trees.insert(23,"dog");
                trees.insert(45,"llama");
                trees.insert(16,"pepito");
                trees.insert(8,"crab");
                trees.insert(29,"giraffe");    
                trees.insert(80,"lion");
                trees.insert(60,"tiger"); 
                trees.insert(90,"cow"); 

                iNumPassed++; 
                
                System.out.println("PASSED"); 
            }
            catch(Exception e)
            {
                System.out.println("FAILED"); 
            }

     
//--------------------------------------------------------------------------------------
             
            try
            {
                iNumTests++; 
                System.out.println("Testing inserting a duplicate node"); 
                trees.insert(50,"cats"); 
                System.out.println("FAILED"); 
            } 
            catch(Exception e)
            {
                iNumPassed++; 
                System.out.println("PASSED"); 
            } 

             
            try
            {
                iNumTests++; 
                System.out.println("Testing deleting a node that does not exist"); 
                trees.delete(75); 
                System.out.println("FAILED"); 
            } 
            catch(Exception e)
            {
                iNumPassed++; 
                System.out.println("PASSED"); 
            } 
//--------------------------------------------------------------------------------------
            try
            {
                iNumTests++; 
                System.out.println("Testing finding a node that does not exist"); 
                
                if(trees.find(75) == true)
                {
                    System.out.println("FAILED"); 
                }
                else
                {
                    System.out.println("PASSED"); 
                }
            } 
            catch(Exception e)
            {
                iNumPassed++; 
                System.out.println("PASSED"); 
            } 
//--------------------------------------------------------------------------------------

              
       }

    } 
