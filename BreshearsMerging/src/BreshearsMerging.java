import java.util.*;
import java.util.NoSuchElementException;

// I got some errors while trying to do this project in Eclipse 

/**
 * A simple queue implementation. Uses list as internal representation. All 
 * operations are O(1).
 * 
 * @author Acuna
 * @version 1.0
 * @param <Item> item type
 */
class ListQueue<Item> implements Queue<Item> {
    LinearNode<Item> tail; //back
    LinearNode<Item> head; //front
    private int count;

    public ListQueue() {
        tail = null;
        count = 0;
    } 

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void enqueue(Item item) {
     LinearNode newNode = new LinearNode(item);

        if(isEmpty())
            head = newNode;
        else
            tail.setNext(newNode);
        
        tail = newNode;
        count++;
    }

    @Override
    public int dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();

        Item result = head.getElement();
        head = head.getNext();
        count--;
        
        if(isEmpty())
            tail = null;

        return (int) result;
    }

    @Override
    public Item front() {
        if(isEmpty())
            throw new NoSuchElementException();

        return head.getElement();
    }
    
    @Override
    public String toString()
    {
        LinearNode iter = head;
        String result = "";
        
        while(iter != null) {
            result = iter.getElement() + " " + result;
            iter = iter.getNext();
        }
            
        return result + "(front)";
    }

    @Override
    public int size() {
        return count;
    }
}

/**
 * A simple queue interface.
 * 
 * @author Wedgewick and Wayne, Acuna
 * @version 1.0
 */
interface Queue<Item> {
    
    /**
     * Add an item.
     * @param item an item
     */
    public void enqueue(Item item);
    
    /**
     * Remove the least recently added item.
     * @return an item
     */
    public int dequeue() throws NoSuchElementException;
    
    /**
     * Return, but do not remove, the most least added item.
     * @return an item
     */
    public Item front() throws NoSuchElementException;
    
    /**
     * Is the queue empty?
     * @return if empty
     */
    public boolean isEmpty();
    
    /**
     * Number of items in the queue.
     * @return number of items
     */
    public int size();
}


public class BreshearsMerging {
	/**
     * Entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue q1 = new ListQueue<Integer>(); q1.enqueue(1); q1.enqueue(3); q1.enqueue(5); q1.enqueue(7);
        Queue q2 = new ListQueue(); q2.enqueue(2); q2.enqueue(4); q2.enqueue(6); q2.enqueue(8); q2.enqueue(10); q2.enqueue(12);   

        //Q1
        Queue<Integer> merged = mergeQueues(q1, q2); // 
        System.out.println(merged.toString());
        
        //Q2
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
        
        //Q3
        //String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //shuffle(b);
       // show(b);
        
        //shuffle(b);
        //show(b);
    }
    
    public static Queue mergeQueues(Queue q1, Queue q2) {
        //TODO: implement this.
    	Queue qAux = new ListQueue(); // this is where our final sorted queue will be
    	
    	// these will be the temp arrays that we will use to store the sorted queues
    	int [] a1 = new int[q1.size()];
    	int [] a2 = new int[q2.size()];
    	
    	// here we are moving them elemets from the queues to the arrays
    	for (int i = 0; i < a1.length; i++){
    		a1[i] = q1.dequeue();
    	}
    	for (int i = 0; i <a2.length; i++){
    		a2[i] = q2.dequeue();
    	}
    	int i = 0;
    	int j = 0;
    	while (i >= a1.length|| j >=a2.length){
    		if (a1[i]< a2[j]){
    			qAux.enqueue(a1[i++]);
    		}
    		else if (a2[j]< a1[i]){
    			qAux.enqueue(a2[j++]);
    		}
    		else if (i >= a1.length){
    			qAux.enqueue(a2[j++]);
    		}
    		else{
    			qAux.enqueue(a1[i++]);
    		}
    	}//while
    	
    	 return qAux;
    }//mergeQueues
    
    public static void sort(Comparable[] a) {
        //TODO: implement this.
        if (a.length <= 1) {
            System.out.println(a);
        }
        
        // Split the arraies in half
        Comparable[] first = new Comparable[a.length / 2];
        Comparable[] second = new Comparable[a.length - first.length];
        
        // I Googled the array copy method on how to copy items over
        System.arraycopy(a, 0, first, 0, first.length); 
        System.arraycopy(a, first.length, second, 0, second.length);
        
        // Sort each half of the array
        sort(first);
        sort(second);
    }

    public static void shuffle(Object[] a) {
        //TODO: implement this.
    	
    	// I got stuck trying to implement this part
    }

    //sorting helper from text
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //sorting helper from text
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    //sorting helper from text
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }

}
/**
 * Represents a node in a singly linked list.
 * 
 * @author Lewis et al., Acuna
 * @version 4.0
 * @param <Item> contained type
 */
class LinearNode<Item> {
    private LinearNode<Item> next;
    private Item element;
 
    /**
     * Creates a node storing the specified element.
     * @param elem element to be stored
     */
    public LinearNode(Item elem) {
        next = null;
        element = elem;
    }

    /**
     * Returns the node that follows this one.
     * @return reference to next node
     */
    public LinearNode<Item> getNext() {
        return next;
    }
 
    /**
     * Sets the node that follows this one.
     * @param node node to follow this one
     */
    public void setNext(LinearNode<Item> node) {
        next = node;
    }
 
    /**
     * Returns the element stored in this node.
     * @return element stored at the node
     */
    public Item getElement() {
        return element;
    }
 
    /**
     * Sets the element stored in this node.
     * @param elem element to be stored at this node
     */
    public void setElement(Item elem) {
        element = elem;
    }
}



