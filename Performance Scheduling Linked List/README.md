
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