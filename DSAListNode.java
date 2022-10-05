/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the node which is repsonsible   *
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
public class DSAListNode
{

    /*** 
     * variable declarations 
    */
    private Object value; 
    private DSAListNode next; 
    private DSAListNode prev; 
    /**
     * Constructor that creates a default node
     */

    public DSAListNode ()
    {
        next = null; 
        prev = null; 
        value = null; 
    }
    /*
    *stores the object in node 
    **/ 
    public DSAListNode (Object inValue)
    {
        value = inValue; 
        next = null;
        prev = null;  
    } 
    /**
     * gets value object stored at node
     */
    public Object getValue ()
    {
        return value; 
    } 
    /**
     * sets node from imported object 
     */

    public void setValue (Object inValue) 
    {
        value = inValue; 
    }
    /**
     * memory address of previous node is stored
     */
    public void setPrev (DSAListNode newPrev)
    {
        prev = newPrev; 
    }
    /**
     * gets previous node 
     */
    public DSAListNode getPrev()
    {
        return prev; 
    }    
    /**
    * gets next node 
    **/
    public DSAListNode getNext () 
    { 
        return next; 
    } 
    /**
     * sets next node memory address 
     */
    public void setNext (DSAListNode newNext) 
    {
        next = newNext; 
    }

} 
