//Colton Owen
//Chpt 5 PA

// Define a Node class to represent each element in the queue
class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a Queue class to represent the queue implemented as a linked list 
class Queue {
    Node front;
    Node rear;

    // Constructor to initialize an empty queue
    public Queue() {
        front = null;
        rear = null;
    }
	
	// Enqueue operation: adds an item to the end of the queue, pseudocode found in PA 5.5.1
    public void enqueue(int item) {
        // Allocate new node and assign data
        // newNode.next is automatically set to null in the Node constructor
		Node newNode = new Node(item);
        
        if (front == null) {
            // If the queue is empty, set front to the new node
            front = newNode;
        } else {
            // Otherwise, link the new node at the end of the queue
            rear.next = newNode;
        }
        // Update the rear pointer to the new node
        rear = newNode;
    }
    
    // Dequeue operation: removes and returns the item from the front of the queue, pseudocode found in PA 5.5.1
    public int dequeue() {
        if (front == null) {
            return 0;
        }
        // Save the data from the front node
        int dequeuedItem = front.data;
        // Move the front pointer to the next node
        front = front.next;
        // If the queue becomes empty, update the rear pointer to null
        if (front == null) {
            rear = null;
        }
        return dequeuedItem;
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty() {
        Node curNode = front;
        if (curNode != null) {
            // List not empty if another node exists after head
            System.out.println("The queue is not empty.");
            return true;
        } else {
            // List empty if no node exists after head
            System.out.println("The queue is empty.");
            return false;
        }
    }
    
    // Method to peek at the front item without removing it
    public int peek() {
       Node curNode = front;
       if (curNode != null) {
            // Shows item in front of head if available
            return front.data;
        } else {
            // Returns 0 if the list is empty
            return 0;
        }
    }

    // Method to get the length of the queue
    public int getLength() {
		Node curNode = front;  
        int len = 0;
        while (curNode != null) {
			// Increments length variable
            len++;
			// Traverses to next node in the list
            curNode = curNode.next;
        }
        return len;
    }	
	
    // Method to traverse and print the list, pseudocode found in PA 4.8.1
    public void displayQueue() {
		Node curNode = front;  
        while (curNode != null) {
			// Prints the node's data
            System.out.print(curNode.data + " -> ");
			// Traverses to next node in the list
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }
    
}

// Main class to demonstrate the queue operations
public class QueueAsLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
		
		queue.displayQueue();   // Shows NULL
        queue.isEmpty();    // Shows that queue is empty
        
        if(queue.peek() == 0) {
            System.out.println("The queue is empty.");  // Shows initial queue peek, should be empty
        } else {
            System.out.println("The top item on the queue is: " + queue.peek());
        }
        
        System.out.println("The queue's length is: " + queue.getLength());  // Shows queue length of 0
        queue.enqueue(1);   // Adds 1 to front of queue
        queue.enqueue(2);   // Adds 2 to front of queue
        System.out.println("The top item on the queue is: " + queue.peek());    // Shows 1 at top of queue
        queue.enqueue(3);   // Adds 3 to front of queue
        System.out.println("The queue's length is: " + queue.getLength());  // Shows length of 3
        System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // Removes 1 from queue
        System.out.println("The top item on the queue is: " + queue.peek());    //Shows 2 at top of queue
        queue.enqueue(4);   // Adds 4 to front of queue
        queue.displayQueue();   // Shows 2, 3, and 4 in queue
        queue.enqueue(5);   // Adds 5 to front of queue
        System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // Removes 2 from queue
        queue.enqueue(6);   // Adds 6 to front of queue
        System.out.println("The queue's length is: " + queue.getLength());  //Shows length of 4
        queue.displayQueue();   // Shows 3, 4, 5, and 6 in queue
        System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // Removes 3 from queue
        queue.isEmpty();    // Shows that the list is not empty
        System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // Removes 4 from queue
        System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // Removes 5 from queue
        System.out.println("The queue's length is: " + queue.getLength());  // Shows length of 1 
        System.out.println("Item " + queue.dequeue() + " was removed from the queue."); // Removes 6 from queue
        if(queue.dequeue() == 0) {
            System.out.println("An item was not dequeued.");    // Shows that nothing remains in queue
        } else {
            System.out.println("Item " + queue.dequeue() + " was removed from the queue.");
        }
        queue.isEmpty();    //Shows empty queue

  }
}
