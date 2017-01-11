import java.util.NoSuchElementException;

public class BreshearsPQStack<Item> implements Stack<Item> {

	    //TODO: implement this object.
	    
	    /**
	     * entry point for sample output..
	     * @param args 
	     */
	    public static void main(String[] args) {
	        Stack<Integer> S = new BreshearsPQStack<Integer>();
	        pq pqclass = new pq(); // here is my inner class
	        
	        S.push(new Integer(2));
	        S.push(new Integer(7));
	        Integer W = S.pop();
	        S.push(new Integer(8));
	        S.push(new Integer(5));
	        Integer X = S.pop();
	        Integer Y = S.peek();
	        S.push(new Integer(3));
	        Integer Z = S.pop();
	        
	        System.out.println("Testing: ");
	        System.out.println(W);
	        System.out.println(X);
	        System.out.println(Y);
	        System.out.println(Z);
	    }

		@Override
		public void push(Item item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Item pop() throws NoSuchElementException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Item peek() throws NoSuchElementException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
// here I knew I had to make a class that implements PQ but got stuck
class pq{
	
}
class MaxPQ<Key extends Comparable<Key>> implements PriorityQueue<Key> {
	    private Key[] pq;
	    private int N = 0;
	    
	    public MaxPQ() {
	        this(100);
	    }
	    
	    public MaxPQ(int maxN) {
	        pq = (Key[]) new Comparable[maxN+1];
	    }
	    
	    @Override
	    public boolean isEmpty() {
	        return N == 0;
	    }
	    
	    @Override
	    public int size() {
	        return N;
	    }
	    
	    @Override
	    public void insert(Key v) {
	        pq[++N] = v;
	        swim(N);
	    }
	    
	    @Override
	    public Key max() {
	        return pq[1];
	    }
	    
	    @Override
	    public Key delMax() {
	        Key max = pq[1];
	        exch(1, N--);
	        pq[N+1] = null;
	        sink(1);
	        return max;
	    }
	    
	    private void swim(int k) {
	        while (k > 1 && less(k/2, k)) {
	            exch(k, k/2);
	            k = k/2;
	        }
	    }

	    private void sink(int k) {
	        while (2*k <= N) {
	            int j = 2*k;
	            if (j < N && less(j, j+1)) j++;
	            if (!less(k, j)) break;
	            exch(k, j);
	            k = j;
	        }
	    }
	    
	    private boolean less(int i, int j) {
	        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
	    }

	    private void exch(int i, int j) {
	        Key swap = pq[i];
	        pq[i] = pq[j];
	        pq[j] = swap;
	    }
	    
	    /*
	    public  void sort(Comparable[] a) {
	        
	        int N = a.length;
	        for (int k = N/2; k >= 1; k--)
	            sink(a, k, N);
	        while (N > 1) {
	            exch(a, 1, N--);
	            sink(a, 1, N); 
	        }
	    }
	    */
	}
interface PriorityQueue<Key extends Comparable<Key>> {   
    
    /**
     * Adds an element.
     * 
     * @param value value to insert
     */
    public void insert(Key value);
    
    /**
     * Returns the maximum element.
     * 
     * @return maximum element
     * @throws NoSuchElementException 
     */
    public Key max() throws NoSuchElementException;
    
    /**
     * Returns and removes the maximum element.
     * 
     * @return
     * @throws NoSuchElementException 
     */
    public Key delMax() throws NoSuchElementException;
    
    /**
     * Checks if the PQ is empty.
     * 
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * Number of elements in the PQ.
     * 
     * @return size
     */
    public int size();
}

interface Stack<Item> {
    
    /**
     * Add an item.
     * @param item an item
     */
    public void push(Item item);
    
    /**
     * Remove the most recently added item.
     * @return an item
     */
    public Item pop() throws NoSuchElementException;
    
    /**
     * Return, but do not remove, the most recently added item.
     * @return an item
     */
    public Item peek() throws NoSuchElementException;
    
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