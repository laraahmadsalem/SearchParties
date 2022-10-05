/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the Queue which is responsible  *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: August 22, 2018                               *
* Date Modified: October 10, 2018                              *
***************************************************************/
import java.util.*;
import java.io.*; 
//Based on code Retrieved from Practical 3 and 4 
//of Data Structures and Algorithms
//used as part of the Assignment 
public class DSAQueue implements Iterable{

    private DSALinkedList list; 
    private int count; 
    

/*************************************************************
 * DEFAULT CONSTRUCTOR: DSAQueue                             *
 * IMPORT: none                                              *
 * EXPORT: none                                              *
 * ASSERTION: creates queue                                  *
 *************************************************************/ 

public DSAQueue()
{
    count = 0; 
    list = new DSALinkedList(); 
}

/** 
 * mutator that returns the count of queue 
 * */
public int getCount()
{
    return count; 
}
/** 
 * checks whether queue is empty 
 * */
public boolean isEmpty()
{
    boolean empty;
    empty = true;
    if (count != 0)
    {
        empty=false;
    }
    return empty;
}
/** 
 * adds elements into the queue  
 * */
public void enqueue (Object value)
{
        list.insertLast(value); 
        count++; 
}
/** 
 * if queue is empty print out message saying it cannot dequeue
 * This function basically returns and removes the top value of the queue 
 * */
public Object dequeue()
{
    Object value;
    if(isEmpty())
    {
        throw new IllegalArgumentException("List is empty"); 
    }
    else
    {
        value = list.removeFirst(); 
        count--;
    }
    return value; 
     
}
/** 
 * 'peeks' at top value but doesnt remove it 
 * */
public Object peek()
{
    Object frontVal; 
    if(isEmpty())
    {
        throw new IllegalArgumentException("List is empty"); 
    }
    else 
    {
        frontVal = list.peekFirst();
    }
   return frontVal; 
}
/** 
 * iterates through the linked list 
 * */
public Iterator iterator() 
{
    return list.iterator(); 
}
    
}
