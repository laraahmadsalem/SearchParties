************************************************************************
* Author: Lara Ahmad Salem                                             *
* Student ID: 19491787                                                 *
* Date Created: 25 October 2018                                        *
* Date Modified: 29 October 2018                                       *
************************************************************************
Table of Contents:

1) What this Program Does
2) File Created and Dependencies 
3) References
4) How to Use the Program  

********************************************************************************************************
What this Program Does? 
-----------------------
This program was constructed to ensure that the campaign management team recieve
the overall information related to the Australian ELections. It reads in source
data which can be downloaded from https://results.aec.gov.au/20499/HouseDownloadsMenu-20499-Csv.html
which will enable anyone who uses this program to list all the nominees participating 
in the Australian federal elections during 2016 as well as actually searching through nominees 
with the data provided. Furthermore, A list of the states may also enable this program to gain more
functionality to calculate the marginal seats for a specific Party. It also calculates the shortest path 
for every marginal seat that should be visited provided that the marginal seats have been calculated.


Files Created & Dependencies
----------------------------

Main.java
=========
This class is the backbone of the entire program and is repsonsible for permitting 
the flow of the other classes in a cascading effect depending on the selection of 
the option from the menu. 

Class Dependencies:
*******************
1) FileIO.java 
2) UserInput.java
3) Search.java
4) Margin.java

FileIO.java
============
This Class is repsonsible for ensuring that the data recieved form csv files is 
read in properly and that the appropriate objects are created.

Class Dependencies:
*******************
1) LocationV.java
2) Candidate.java
3) State.java

UserInput.java
==============
The sole purpose of this class is to ensure that all data recieved from the UserInput
is encapsulated with the correct try-catches and all errors are handled elegantly.

Class Dependencies:
*******************
1) FilterNominees.java

FilterNominees.java
===================
This class is repsonsible for filtering the required criteria and searching through the 
linked list trying to find any Object that matches the criteria the user is looking for. Once
All Candidate objects that match are found then reordered by a specific category chosen by the user.

Class Dependencies:
*******************
1) Sorts.java
2) DSAQueue.java

Sorts.java
==========
This class is used to manage the sorting of the data based on four categories and those are 
State, surname, party and division. The ordering is usually done in alpahbetical order for Strings
and by ascending order in terms of division numbers. In this class exists alot of case statements 
and data duplication however I found this was inevitable if i wanted to give my suers the ability 
to order by four different categories. 

Class Dependencies:
*******************
N/A

Margin.java
=====================
This class is responsible for calculating the marginal seats for a given party within a specific 
threshold. If no threshold is given then the default value of 6 is provided. After the marginal 
seats for the party have been calculated a queue is returned to signify the locations that the 
itinerary must include. 

Class Dependencies
******************
1) BinarySearchTree.java
2) DSAQueue.java

Search.java
===========
This class is responsible for filtering a set of candidates in a queue that inlcude a specific 
substring provided to the method by the user. Once the candidates that match are queued they 
are filtered again according to a particular state, party or both. 

Class Dependencies
******************
1) DSAQueue.java
2) FilterNominees.java

DSALinkedList.java
==================
This class is based on the data structure and has been used to store Candidate, state and even Location objects. 
The various functions have enabled me store an infinite amount of objects due to no restrictions. 

Class Dependencies
******************
N/A

DSAQueue.java
=============
This class is reposnsible for adding objects based of the FIFO concept. It has been based on a linked List 
that behaves exactly like a queue. Its various methods have enabled me to enqueue data where its necessary and 
dequeue data in a first in first out concept. 

Class Dependencies
******************
1) DSALinkedList.java

LocationV.java
==============
This is a container class that is responsible for storing all the data related to latitude, longitude and states
for every location that is being added in to the vertex. Instead of creating extra clasfields in my vertex class I 
decided it would be more applicable to just create an object to encapsulate the data. 

Class Dependdencies 
*******************
N/A

Candidate.java
==============
This is the main container class that stores all the nomineees related to the first two functions in 
my main menu. It consists of the constructors, mutators and accessors that enable me to access the data 
when i need to compare it in cases liek filtering nominees or or ordering and searching. 

Class Dependencies
******************
N/A

State.java
==========
This class is reposnsible for storing all the data obtained from the states csv files so that the marginal seats 
can be calculated and used to obtain an itinerary. 

Class Dependencies 
******************
N/A

DSAGraph.java
=============
This Class is used to obtain all the location and make them into vertices contained by edges. With this class i am able
to obtain the shortest path for each node using the Dijkstra Algorithm. 

Class Dependencies
******************
1) DSAGraphVertex.java
2) DSAGraphEdge.java
3) PriorityQueue.java
 

References
----------
1) DSAQueue.java: based on code from DSA Practical 3 (Date: 12/10/2018) 
   UnitTestDSAQueue.java: Based on code from DSA Practical 3
2) BinarySearchTree.java: Based on code from DSA Practical 5 (Date: 12/10/2018)
   UnitTestTree.java: Based on code from DSA Practical 5
3) DSAGraph.java: Retrieved from DSA Practical 6 (Date: 21/10/2018)
   UnitTestDSAGraph.java: Based on Code from Practical 6 (Date: 23/10/2018)
4) DSALinkedList.java: Retrieved from DSA Practical 4 (Date: 18/09/2018)
   UnitTestLinkedList.java Retrieved From Practical 4
5) Function: processString (String line) -> Retrieved Regex Commands from: 
   https://www.rexegg.com/regex-quickstart.html (Accessed: 10/10/2018)
6) PriorityQueue.java: Private Class Based on code from UCP Practical 3 & Robert Lafore TextBook: Data Structures & Agorithm
   (Accessed: 27/10/2018) 
7) Function: Dijkstra(String source): Retrieved from: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
   (Accessed: 20/10/2018)

How to Use the Program
----------------------
1) To compile everything you first have to type to into the terminal javac *.java
2) After everything has compiled you are now ready to run the program by typing 'java Main' this will 
   execute that main menu and provide the user with several options.
3) Once starting the program you are restricted from being able to excecute any functions that require 
   data. So, you must press option '5' in the beginning to read in a list of nominees, or a state file. 
4) Finally manoeuvre through the program based on the main menu once you have ensured that you have read in 
   the corect files to execute the options you prefer.
5) Once you have finished with the program press option '6' in the main menu to gracefully leave the program.
