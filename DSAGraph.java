import java.util.*; 
import java.io.*; 

public class DSAGraph 
{
  
    public class PriorityQueue /*check README.txt for reference */ 
    {
  
      private Object queue []; 
      private int count; 
      private static final int DEFAULT_CAPACITY = 1000; 
  
      public PriorityQueue() //constructor 
      {
          count = 0; 
          queue = new Object [DEFAULT_CAPACITY]; 
      }
  
    
      public int getCount() //gets length of queue
      {
          return count; 
      }
  
      public boolean isEmpty() //checks whether the graph class is empty or not 
      {
          boolean empty;
          empty = true;
          if (count != 0)
          {
              empty=false;
          }
          return empty;
      }
  
      public boolean isFull() //if its full elements wont be added to queue
      {
          boolean full= false;
  
          if (count == queue.length)
           {
             full = true;
           }
           return full;
      }
  
      public Object peek() //checks top value with the minimum distance 
      {
        return queue[count-1];  
      }
      public void enqueue (DSAGraphVertex value) ///adds values to the queue anything greater than min will be placed after it 
      {
          int i;  
          if(isFull())
          {
              throw new IllegalArgumentException("The Array is too full"); 
          }
          else if(count == 0) 
          {
              queue[count++] = value;  
          }
          else
          {
              for(i=count-1;i>=0;i--)
              {
                  DSAGraphVertex compare = (DSAGraphVertex) queue[i];  
                  if(value.getTime()> compare.getTime())
                  {
                      queue[i+1] = queue[i];    
                  }
                  else
                  {
                      i=0;            
                  }
              }
              queue[i+1] = value;
              count++; 
          }
      }
  
      public Object dequeue() //removes values from the queue
      {
          Object frontVal; 
        
          if(isEmpty())
          {
              throw new IllegalArgumentException("Array is Empty"); 
          }
          else
          {
              frontVal = queue[count--];
          } 
          return frontVal; 
      }
    }  

  private class DSAGraphEdge
  {
    private String label; 
    private DSAGraphVertex adjacent1; 
    private DSAGraphVertex adjacent2; 
    private boolean visited; 
    private int distance; 
    private int duration; 


    public DSAGraphEdge (String transport, DSAGraphVertex inAdj1,DSAGraphVertex inAdj2,int inDuration,int inDistance)
    {
        label = transport; 
        adjacent1 = inAdj1; 
        adjacent2 = inAdj2;
        visited = false;  
        duration = inDuration; 
        distance = inDistance; 

    }

    public String getLabel() //gets name of the edge 
    {
        return label; 
    }    

    public boolean getVisited() //deteremines whether its been vistsed or not 
    {
        return visited;
    }

    public DSAGraphVertex getSource() //adjacent vertex 1
    {
        return adjacent1; 
    }

    public DSAGraphVertex getSink()
    {
        return adjacent2; 
    }

    public int getDuration() //how long it takes to get to the sink 
    {
        return duration; 
    }

    public int getDistance()
    {
        return distance; 
    }

    public void setVisited()
    {
        visited = true;
    }

    public String toString()
    {
        String edgy;  
        edgy = ("This edge is " +label+ " with an Adjacent vertex of " +adjacent1.getLabel()+
                 " and another adjacent vertex of " +adjacent2.getLabel()); 
        return edgy; 
    }
    
  }

  private class DSAGraphVertex 
  {
    private String label; 
    private Object value; 
    private DSALinkedList links;
    private DSALinkedList edgeLinks;  
    private boolean visited; 

    private DSAGraphVertex previousNode; //used for dikstra 
    private double time = Double.POSITIVE_INFINITY;

    public DSAGraphVertex (String inLabel,Object inValue)
    {
        label = inLabel; 
        value = inValue; 
        links = new DSALinkedList(); 
        edgeLinks = new DSALinkedList(); 
        visited = false; 
    }

    public String getLabel()
    {
        return label; 
    }

    public double getTime()
    {
        return time; 
    }

    public DSAGraphVertex getPrev()
    {
        return previousNode; //gets previous node for dijkstra 
    }

    public Object getValue()
    {
        return value; 
    }

    public DSALinkedList getAdjacent()
    {
        return links; 
    }

    public DSALinkedList getAdjacentEdges()
    {
        return edgeLinks;    
    }

    public void addEdge(DSAGraphEdge inEdge)
    {
        edgeLinks.insertFirst(inEdge); 
    }

    public void addVertex(DSAGraphVertex inVertex)
    {
        links.insertFirst(inVertex); 
    }

    public void setVisited()
    {
        visited = true; 
    }

    public void setTime(double value)
    {
        time = value; 
    }

    public void clearVisited()
    {
        visited = false; 
    }

    public boolean getVisited()
    {
        return visited; 
    }

    public boolean isAdjacent(String vertex) //determines whther the vertex is adjacent to another vertex 
    {
        boolean adjacent = false; 
        Iterator adj = links.iterator();
 
        while(adj.hasNext())
        {
            DSAGraphVertex adjz = (DSAGraphVertex) adj.next(); 
            if(adjz.getLabel().equals(vertex))
            {
                adjacent = true; 
            }
        }
        return adjacent; 
    }

 
    public String toString()
    {
      String temp; 
      temp =  label; 
      return temp; 
    }
    
  }
    //this is the actual public graph 
    private DSALinkedList edges; 
    private int edgeCount;
    private DSALinkedList vertices; 
    private int vertexCount; 
    
    
    public DSAGraph()
    {
        vertices = new DSALinkedList();
        edges = new DSALinkedList();  
        edgeCount = 0; 
        vertexCount = 0; 
    }

    public void addVertex (String division, LocationV value) //adds the vertex 
    {
        if(getVertex(division) == null) //only adds if it doesnt exist
        {   
            
            DSAGraphVertex inV = new DSAGraphVertex(division,value); //creates the node 
            vertices.insertFirst(inV); //adds it to the list 
            vertexCount++; 
        }  
    } 
    

    public void addEdge (String vertex1,String vertex2, String transport, int duration, int distance)
    {

        DSAGraphVertex vOne = null; 
        DSAGraphVertex vTwo = null; 
        DSAGraphEdge temp = null; 

        if(vertex1.equals(vertex2))
        {
            throw new IllegalArgumentException("Vertices are the same no edge created"); 
        }
        else if(vertices.isEmpty())
        {
            throw new IllegalArgumentException("No vertices are in this list"); 
        }
        else
        {
            Iterator itr = vertices.iterator(); 
            while(itr.hasNext())
            {
                DSAGraphVertex current = (DSAGraphVertex)itr.next(); 
                if(vertex1.equals(current.getLabel())) //if it exists then its set as current vertex 
                {
                    vOne = current; 
                }
                else if(vertex2.equals(current.getLabel())) //if it equated to the second vertex then vTwo is set to that
                {
                    vTwo = current; 
                }
            }
            if((vTwo == null) || (vOne == null)) //if its null its considered invalid 
            {
                throw new IllegalArgumentException("Invalid vertices, Edges not Added"); 
            }
            else
            {                
                temp = new DSAGraphEdge(transport,vOne,vTwo,duration,distance); //edge is created with vertex 
                edges.insertFirst(temp); //inserted to list to be kept track off
                edgeCount++;
                vOne.addVertex(vTwo);  //adjacent vertex added to each other 
                vTwo.addVertex(vOne); 
                vOne.addEdge(temp); //inserted to linked list of vertex 
                vTwo.addEdge(temp); 
            }
            
        }
         
    }

    public int getVertexCount() 
    {
        return vertexCount; 
    }

    public int getEdgeCount()
    {
        return edgeCount; 
    }

    //find method sees if a node already exists 
    public DSAGraphVertex getVertex (String label)
    {
        boolean isIt = false; 
        DSAGraphVertex theOne = null; 
        Iterator itr = vertices.iterator(); 

      
        while(itr.hasNext() && isIt == false)
        {
            DSAGraphVertex curr = (DSAGraphVertex)itr.next();
     
            if(label.equals(curr.getLabel())) 
            {
                isIt = true; 
                theOne = curr;         
            }

        }
        
        return theOne; //find method 
    }

    public DSALinkedList getAdjacent (String theLabel) //gets adjacent linked list 
    {
        DSAGraphVertex theVertex = getVertex(theLabel); 
        DSALinkedList adjacentOnes = theVertex.getAdjacent(); 
        return adjacentOnes; 
    }


    public boolean isAdjacent(String vertex1, String vertex2)
    {
        boolean  adjacent = false;

        DSAGraphVertex v1 = getVertex(vertex1); 
        adjacent = v1.isAdjacent(vertex2); 
        return adjacent;      
    
    } //vertex 

    public void displayList() //displays the list 
    {
        DSAGraphVertex currOne = null; 
        DSAGraphVertex adjV = null; 
        Iterator vx = null;
        Iterator ad = null;  
        DSALinkedList adj = null; 

        if(vertices.isEmpty())
        {
            throw new IllegalArgumentException("No vertices were located"); 
        }
        else
        {
            vx = vertices.iterator(); 
            while(vx.hasNext())
            {
                currOne = (DSAGraphVertex)vx.next(); 
                adj = currOne.getAdjacent(); 
                System.out.print(currOne.getLabel() + " | "); 
                
                ad = adj.iterator();
                while(ad.hasNext())
                {
                    adjV = (DSAGraphVertex) ad.next(); 
                    System.out.print(adjV.getLabel() + ", "); 
                }
                System.out.println(); 
            }
        
        }

    }

    public void displayMatrix() //displays graph in vertex form 
    {
        Iterator iter = null; 
        Iterator itr2 = null; 
        DSAGraphVertex curr; 
        DSAGraphVertex adj; 

        for(itr2 = vertices.iterator();itr2.hasNext();)
        {
            adj = (DSAGraphVertex) itr2.next();
            System.out.print(adj.toString()+" "); 
            
            for(iter = vertices.iterator(); iter.hasNext();)
            {
                curr = (DSAGraphVertex) iter.next(); 
                if(isAdjacent(adj.getLabel(),curr.getLabel()))
                {
                    System.out.print("1 "); 
                }
                else
                {
                    System.out.print("0 "); 
                }
             
            }
            System.out.println();
        }
           
       
    }
   
    //makes sure string is valid 
    private boolean validateString (String word)
    {
        boolean valid = false; 
        if (word != null)
        {
            valid = true; 
        }
        return valid; 
   
    }

    //this was a test method i created by myself to understand how shortest path works 
    public void shortestPath (String source)
    {
      
        DSAGraphVertex v1 = getVertex(source); //gets vertex we are starting from 
 
        DSAGraphEdge ed = null; //shortest edge

        DSAQueue vertx = new DSAQueue(); //storing shortest path in this queue
        DSAQueue edgz = new DSAQueue(); //storing shortest edge in this queue

        for(Iterator itr3 = vertices.iterator();itr3.hasNext();)
        {
            DSAGraphVertex v2 = (DSAGraphVertex) itr3.next();  //setting them to false so i can visit all vertices 
            v2.clearVisited(); 
        }

       
       while(getVertex(v1)  == false)
       {
        //      setVertex(v1); 
               DSALinkedList edge = v1.getAdjacentEdges(); //gets the edges adjacent to the source vertex 

               Iterator itr = edge.iterator(); 
               ed = (DSAGraphEdge) itr.next();
    
                while((getEdge(ed) == true))  //if edge visited then get the next edge 
                {
                    
                    if(itr.hasNext())    
                    {
                        ed = (DSAGraphEdge) itr.next();    
                        //if sink has been visited and source hasnt get next edge 
                        if((getVertex(ed.getSink()) == true) && (getVertex(ed.getSource())== false))
                        {       
                            ed = (DSAGraphEdge) itr.next(); 
                       
                        }
                    }
                }
             
                while(itr.hasNext())
                {
                    DSAGraphEdge curr = (DSAGraphEdge) itr.next(); 
                    if((ed.getDistance() > curr.getDistance())) //compare the distances to get shortest path 
                    {
                        if(getEdge(curr) == false)
                        {   
                            ed = curr;    //if it has not been visited then make that shortest 
                        }                     
                       
                    }       
                }
                setVertex(v1);  //sets vertex to visited 
                setEdge(ed);    //sets edge to visited 
                vertx.enqueue(v1); //queues it to print later on 
                edgz.enqueue(ed); 
            
                v1 = ed.getSink(); //new vertex is now sink 
           
                ed = null; 
        }       
       
        printpath(vertx,edgz); 
    }
    
    //used this method for my shortest path to return a vertex from the list 
    public boolean getVertex (DSAGraphVertex ed)
    {
        boolean result = false; 
        Iterator itr = vertices.iterator();
 
        while(itr.hasNext())
        {
            DSAGraphVertex curr = (DSAGraphVertex) itr.next(); 
            if((ed.getLabel()).equals((curr.getLabel())))
            {
               result = curr.getVisited(); 
            }
        }
        return result; 
    }
    //this method is for my shortest path it sets the vertex to visited 
    public void setVertex (DSAGraphVertex ed) 
    {      
        Iterator itr = vertices.iterator(); 
        while(itr.hasNext())
        {
            DSAGraphVertex curr = (DSAGraphVertex) itr.next(); 
            if((ed.getLabel()).equals(curr.getLabel())) //create an equals method (this is temp) 
            {
                curr.setVisited();      
            }
        }

    }

  //3rd method for my shortest path i used to get edges from linked list 
   public boolean getEdge (DSAGraphEdge ed)
    {
        boolean result = false; 
        Iterator itr = edges.iterator(); 
        DSAGraphEdge curr;
        while(itr.hasNext()  && !result)
        {
            curr = (DSAGraphEdge) itr.next(); 
            if(ed.getLabel().equals(curr.getLabel()))
            {
               result = curr.getVisited(); 
            }
        }
        return result; 
    }

    //used this to set any edges to visited in my shortest path 
    public void setEdge (DSAGraphEdge ed) 
    {
      
        Iterator itr = edges.iterator(); 
        while(itr.hasNext())
        {
            DSAGraphEdge curr = (DSAGraphEdge) itr.next(); 
            if((ed.getLabel().equals(curr.getLabel()))) //create an equals method (this is temp) 
            {
                curr.setVisited();      
            }
        }

    }
    //Obtained from concepts of Dijkstra ALgorithm Refer to read me.txt 
    //for the references
    public void  dijkstra (String source)
    {
       PriorityQueue queue = new PriorityQueue (); 
       boolean finished = false; 
       DSAGraphEdge edge = null;  
       DSAGraphVertex v1 = getVertex(source);
  
       //gets vertex we are starting from 
       
       v1.setTime(0.0); 
       queue.enqueue(v1); 

       for(Iterator itr3 = vertices.iterator();itr3.hasNext();)
       {     
            DSAGraphVertex v2 = (DSAGraphVertex) itr3.next();  
            if(!(v2.getLabel().equals(v1.getLabel())))
            {
                //setting them to false so i can visit all vertices 
                v2.clearVisited(); 
                v2.setTime(Double.MAX_VALUE); 

                queue.enqueue(v2);
            }
            v2.clearVisited(); 
       }

       while(!(queue.isEmpty())) 
       {
         DSAGraphVertex u = (DSAGraphVertex) queue.dequeue(); 
 
         DSALinkedList e =  u.getAdjacentEdges(); 
         
         for(Iterator edgz = e.iterator();edgz.hasNext();)
         {
            edge = (DSAGraphEdge) edgz.next(); 
            DSAGraphVertex v  = edge.getSink(); 
            double distance = edge.getDistance();    

            double distancefromU = u.getTime() + distance; 

            if(distancefromU < v.getTime())
            {
                DSAGraphVertex removed = (DSAGraphVertex) queue.dequeue(); 
                v.setTime(distancefromU); 
                v.previousNode = u;      
                queue.enqueue(v); 
            } 
         }
       }
            
    }

    //prints path that my vertex follows 
    public void printpath(DSAQueue v1,DSAQueue ed)
    {
        while(!(v1.isEmpty()))
        {
            DSAGraphVertex hi = (DSAGraphVertex) v1.dequeue();            
            System.out.println("Vertex is: " +hi.getLabel()); 
            DSAGraphEdge  bye = (DSAGraphEdge) ed.dequeue(); 
            System.out.println("Shortest Path is: " +bye.getLabel());
        }

    }
}
