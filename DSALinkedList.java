/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the list which is repsonsible   *
*          for constructors, mutators as well as validation   *
*          submodules to ensure that all inputs are valid     *
* Date Created: August 30, 2018                               *
* Date Modified: October 12, 2018                             *
***************************************************************/
import java.util.*;
import java.io.*; 
//Based on code Retrieved from Practical 4 
//of Data Structures and Algorithms
//used as part of the Assignment 

public class DSALinkedList implements Iterable 
{
    /**
     * private class responsible for iterating through list
     */
    private class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext; 
        /**
         * starts iterating at the head 
         */
        public DSALinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head; 
        }
        /**
         * while iteration has a next node 
         */
        public boolean hasNext()
        {
            return (iterNext != null);  
        }
        /**
         * get Next value 
         */
        public Object next() 
        {
            Object value; 
            if(iterNext == null)
            {
               value = null; 
            }
            else 
            {
               value = iterNext.getValue(); 
               iterNext = iterNext.getNext(); 
            }
            return value; 
        }
        /**
         * throws unsupported exception if user wants to remove node 
         */
        public void remove()
        {
            throw new UnsupportedOperationException("Not Supported"); 
        }

    }
    //variable declarations 
    private DSAListNode head; 
    private DSAListNode tail;
    private int length;  

     /**
     * creates linked list initially 
     */
    public DSALinkedList ()
    {
        head = null;
        tail = null;  
        length = 0; 
    }
    /**
     * inserts at beginning of list
     */
    public void insertFirst (Object newValue) 
    {
        DSAListNode newNd = new DSAListNode(newValue); 
        newNd.setNext(head); 
     
        if(isEmpty()) 
        {
            head = newNd;  
            tail = newNd;
            
        }
        else
        {
            head.setPrev(newNd);   
            newNd.setNext(head); 
            head = newNd; 
           
        }  
        length++; 
                  
    }
     /**
     * inserts at end of list 
     */
    public void insertLast (Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue); 
       
        if(isEmpty())
        {
            head = newNd; 
            tail = newNd; 
        }
        else 
        {

             tail.setNext(newNd); 
             newNd.setPrev(tail);  
             tail = newNd; 
             length++;  
        }
        
    }
     /**
     * peeks at top value which is head 
     */
    public Object peekFirst()
    {
        Object nodeValue; 
        if(isEmpty())
        {
        
            throw new IllegalArgumentException ("Linked List is Empty"); 
        }
        else
        {
            nodeValue = head.getValue(); 
        }
        return nodeValue; 
    }
    /**
     * peeks at last value which is tail 
     */
    public Object peekLast()
    {
        Object nodeValue; 

        if(isEmpty())
        {
            throw new IllegalArgumentException ("Linked List is Empty");    
        }
        else 
        { 
            nodeValue = tail.getValue();   
        }
        return nodeValue; 
    }
    /**
     * removes first value from list 
     */
    public Object removeFirst()
    {
      
        Object nodeValue; 
        DSAListNode temp = head;
        DSAListNode next = head.getNext();  
         
             if(head == null)
             {
                tail = null; 
                throw new IllegalArgumentException("Linked List is Empty"); 
             }
             else
             {   
              
                nodeValue = head.getValue();
                head = next; 
                length--; 
            
             }
      
             return nodeValue; 
          
    }

    /**
     * removes last node from list  
     */
    public Object removeLast()
    {
        Object nodeValue;
        DSAListNode temp = tail;  
        if(isEmpty())
        {   
            throw new IllegalArgumentException("Linked List is Empty");    
        }
        else 
        {
            nodeValue = tail.getValue(); 
            tail = tail.getPrev(); 
            length--; 
           // tail.setNext(null); 
           // tail.setPrev(null); 

        }
        return nodeValue; 
    }

    /**
     * checks whether list is empty 
     */
    public boolean isEmpty()
    {
        boolean empty = false;
        if (head == null)
        {
            empty = true;
        }
        
        return empty;
    }
    /**
     * gets length of list 
     */
    public int length()
    {
        return length; 
    }
    /**
     * iterate through list 
     */
    public Iterator iterator () 
    {
        return new DSALinkedListIterator(this); 
    }

}
