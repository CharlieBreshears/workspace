package homework3;
import java.util.NoSuchElementException;
/**
 * Deque defines the interface to a deque ADT.
 *
 * @author Charles Breshears
 * @version 1.0
 * @param <Item> contained type
 */

public class BaseDeque <Item> implements Deque <Item>{
	

    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        BaseDeque<Integer> deque = new BaseDeque<>();
        int n =0;

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());            
    }

 
	@Override
	public void enqueueFront(Item element) {
		System.out.println(element);
		
	}

	@Override
	public void enqueueBack(Item element) {
		
	}

	@Override
	public Item dequeueFront() throws NoSuchElementException {
		return null;
	}

	@Override
	public Item dequeueBack() throws NoSuchElementException {
		return null;
	}

	@Override
	public Item first() throws NoSuchElementException {
		return null;
	}

	@Override
	public Item last() throws NoSuchElementException {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return n;
	}


}


