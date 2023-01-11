
# PERFORMANCE SCHEDULING LINKED LIST

Planning a music festival is a lot of work and requires a great deal of coordination and organization. Often, a planned schedule needs to be changed over time to accommodate for unforeseen situations. Music performers need to be added or removed from the schedule in response to changing factors. 
The Performance Scheduling Linked List project implements an interface that will store all of the performances in the form of a LinkedList. LinkedList is efficient in these types of situations because the list can be modified without changing the whole structure of the existing list.

**CLASSES**
1. **PerformanceNode** class contains basic information about a performance in a festival. Required information includes the name of the performance, the name of the lead performer, total participants, duration of the performance (in minutes), and the start time of the performance (in minutes for simplicity).

2. **PerformanceList** class contains references to the head and tail of a list of PerformanceNode nodes, as well as a cursor representing the current PerformanceNode node. PerformanceList is sorted according to the starting time of the performances.

3. **PerformanceScheduler** class contains a main method that presents a menu that allows the user to access data from the API, store it in a linked list, and interact with it using the following commands: 

- **A** (Add a new performance to the list)
    
    Prompts the user for information regarding a performance. Creates a new PerformanceNode for this performance, and adds it to the end of the list.
- **I** (Insert a new performance after the current node)
    
    Prompts the user for information regarding a performance. Creates a new PerformanceNode and adds it after the current performance.
    If there is no current node, inserts the new node at the end of the list.

- **R** (Remove the current node from the list)


    If there is a current node, it is removed from the list and the current node is moved to the next appropriate current node. If there is no current node, informs the user of the situation with an appropriate error message.

- **C** (Display the current node)

    Displays the contents of the current node. If there is no current node, displays an appropriate error message to the user.

- **D** (Display all nodes)

    Displays the contents of all nodes, in order. If there are no nodes, displays an appropriate error message to the user.  

- **F** (Move cursor forward)

    Moves the reference of the current node forward by one position if there is another node in the list. If the current slide is the last in the list, simply displays an appropriate message to the user and does nothing.

- **B** (Move cursor backwards)

    Moves the reference of the current node backwards by one position if there is a previous node in the list. If the current node is the first in the list, simply displays an appropriate message to the user and does nothing.

- **J** (Jump to a given position)
    
    Prompts the user for a position number and moves the current node to that number node, if it exists. If it does not exist, simply displays an error message to the user and does nothing.

- **Q** (Exit the program)

## Sample Input/Output
```
Operation 1: A is picked by the user (add to end). To add a new performance to 
the list, the user needs to specify the performance name, lead performer name, 
total number of participants, and duration of the performance in minutes. 

A) Add to end
B) Move current node backward
C) Display current node
D) Display all nodes
F) Move current node forward
I) Insert after current node
J) Jump to position
R) Remove current node
Q) Exit
 
Choose an operation: A

Enter name of performance: Symphony Orchestra
Enter name of lead performer: Jennifer Aylmer
Enter the total participants: 50
Enter the duration of the performance: 30

New performance Symphony Orchestra is added to the end of the list.

```
```
Operation 2: A is picked by the user, so the user will add another 
performance to the list.

Choose an operation: A

Enter name of performance: Wind Ensemble
Enter name of lead performer: Bruce Engel
Enter the total participants: 30
Enter the duration of the performance: 40

New performance Wind Ensemble is added to the end of the list.
```
```
Operation 3: D is picked by the user, so all the performance nodes 
will be displayed.

Choose an operation: D

Schedule:


Current No. Performance Name          Lead Performer Name       Participants Duration Start Time
------------------------------------------------------------------------------------------------
          1 Symphony Orchestra        Jennifer Aylmer                     50       30          0
      *   2 Wind Ensemble             Bruce Engel                         30       40         30

// The current node the cursor is pointing to on the list is represented by the asterisk (*)

```

