import java.util.*; 

public class BinarySearchTree
{
    private class DSATreeNode
    {

        private int key; 
        private DSATreeNode leftChild, rightChild; 
        private Object value; 

        public DSATreeNode(int inKey, Object inValue)
        {
      
            if(inKey < 0) 
            {
                throw new IllegalArgumentException("Key cannot be null");   
            }
            value = inValue; 
            key = inKey;  
            rightChild = null; 
            
        }

        public int getKey()
        {
            return key; 
        }

        public Object getValue()
        {
            return value; 
        }

        public DSATreeNode getLeft()
        {
            return leftChild; 
        }

        public DSATreeNode getRight() 
        {
            return rightChild; 
        }

        public void setLeft(DSATreeNode newLeft)
        {
            leftChild = newLeft; 
        }

        public void setRight(DSATreeNode newRight)
        {
           rightChild = newRight;  
        }
    }
    private DSATreeNode root; 
    
    public BinarySearchTree()
    {
        root = null; 
    }
    public boolean find (int key)
    {
       return findRecursive(key, root); 
    }

    private boolean findRecursive(int key, DSATreeNode currNode)
    {
        boolean exist = false;  
           
        if(currNode == null) //base case: not found
        {
            exist = false; 
        }
        else if(key == currNode.getKey()) //base case: found
        {
            exist = true;  
        }
     
        else if(key < currNode.getKey()) //go left recursive
        {
            exist = findRecursive(key, currNode.getLeft());      
        }
        else  //go right recursive
        {
            exist = findRecursive(key,currNode.getRight());  
        }
        return exist; 
    }

    public void insert(int key, Object value)
    {
        root =  insertRecursive(key,value,root);    
    }

    private DSATreeNode insertRecursive(int key,Object value, DSATreeNode curr)
    {
        DSATreeNode updateNode = curr; 
        if(curr == null)
        {
          DSATreeNode newNode = new DSATreeNode(key,value); 
          updateNode = newNode; 
        }   
        else if(key==curr.getKey())
        {
           throw new IllegalArgumentException("No Duplication should occur"); 
        }
        else if(key<curr.getKey())
        {
            curr.setLeft(insertRecursive(key,value,curr.getLeft())); 
        }
        else
        {
            curr.setRight(insertRecursive(key,value,curr.getRight()));     
        }
      return updateNode;       
    }
    public void delete (int key) 
    {
        DSATreeNode nodes = deleteRec(key,root); //check for return 
    }
    private DSATreeNode deleteRec (int key, DSATreeNode curr)
    {
        DSATreeNode updateNode = curr; 
        if(curr == null) //base case not found
        {
            throw new NoSuchElementException("key " + key + "not found");
        }
        else if(key == curr.getKey()) //base case found
        {
            updateNode = deleteNode(key,curr); 
        }
        else if(key < curr.getKey()) 
        {
            curr.setLeft(deleteRec(key,curr.getLeft())); 
        }
        else
        {
            curr.setRight(deleteRec(key, curr.getRight())); 
        }
        return updateNode;
    }

    private DSATreeNode deleteNode(int key, DSATreeNode delNode)
    {
        DSATreeNode updateNode = null; 
        if((delNode.getLeft() == null) && (delNode.getRight() == null))
        {
            updateNode = null; //no children 
        }
        else if((delNode.getLeft() != null) && (delNode.getRight() == null))
        {
            updateNode = delNode.getLeft();  //one child - left 
        }
        else if((delNode.getLeft() == null) && (delNode.getRight() != null))
        {
            updateNode = delNode.getRight(); //one child right 
        }
        else //two children 
        {
            updateNode = promoteSuccessor(delNode.getRight()); 
            if(updateNode != updateNode.getRight()) //no cycles
            {
                updateNode.setRight(delNode.getRight()); //update right
                //check if right idk if syntax 
            }
            updateNode.setLeft(delNode.getLeft()); //update left
        }
        return updateNode; 
    }

    private DSATreeNode promoteSuccessor (DSATreeNode cur)
    {

        //successor will be left most child on right subtree
        DSATreeNode successor = cur; 
        if(cur.getLeft() != null)
        {
            successor = promoteSuccessor(cur.getLeft()); 
        }
        if(successor == cur.getLeft()) //parent of successor needs
        {
            cur.setLeft(successor.getRight()); //to adopt right child 
        }
      return successor; 
    }

   
  
 

 
 


}

   
