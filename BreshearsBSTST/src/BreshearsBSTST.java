
interface SymbolTable<Key, Value> {
    // put key-value pair into the table
    void put(Key key, Value val);
    
    //get value paired with key
    Value get(Key key);
    
    //remove key (and its value) from table
    void delete(Key key);
    
    //is there a value paired with key?
    boolean contains(Key key);
    
    //is the table empty?
    boolean isEmpty();
    
    //number of key-value pairs
    int size();
    
    //all keys in the table, in sorted order
    Iterable<Key> keys();
}
interface OrderedSymbolTable<Key, Value> extends SymbolTable<Key, Value> {
    
    //smallest key
    Key min();
    
    //largest key
    Key max();
    
    //largest key less than or equal to key
    Key floor(Key key);
    
    //smallest key greated than or equal to key
    Key ceiling(Key key);
    
    //number of keys less than key
    int rank(Key key);
    
    //key of rank k
    Key select(int k);
    
    //delete smallest key
    void deleteMin();
    
    //delete largest key
    void deleteMax();
    
    //number of keys in [lo..hi]
    void size(Key lo, Key hi);
    
    //keys in [lo..hi] in sorted order
    Iterable<Key> keys(Key lo, Key hi);
}
public class BreshearsBSTST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
	    private Node root;

	    private class Node
	    {
	        private final Key key;
	        private Value val;
	        private Node left, right;
	        private int N;

	        public Node(Key key, Value val, int N) {
	            this.key = key; this.val = val; this.N = N;
	        }
	    }
	    
	    @Override
	    public int size() {
	        return size(root);
	    }
	    
	    private int size(Node x) {
	        if (x == null)
	            return 0;
	        else
	            return x.N;
	    }
	    
	    @Override
	    public Value get(Key key) {
	        return get(root, key);
	    }
	    
	    private Value get(Node x, Key key) {
	        // Return value associated with key in the subtree rooted at x;
	        // return null if key not present in subtree rooted at x.
	        if (x == null) return null;
	        int cmp = key.compareTo(x.key);
	        if (cmp < 0) return get(x.left, key);
	        else if (cmp > 0) return get(x.right, key);
	        else return x.val;
	    }
	    
	    @Override
	    public void put(Key key, Value val) {
	        root = put(root, key, val);
	    }
	    
	    private Node put(Node x, Key key, Value val) {
	        // Change key’s value to val if key in subtree rooted at x.
	        // Otherwise, add new node to subtree associating key with val.
	        if (x == null) return new Node(key, val, 1);
	        int cmp = key.compareTo(x.key);
	        if (cmp < 0) x.left = put(x.left, key, val);
	        else if (cmp > 0) x.right = put(x.right, key, val);
	        else x.val = val;
	        x.N = size(x.left) + size(x.right) + 1;
	        return x;
	    }
	    
	    @Override
	    public Key min() {
	      return min(root).key;
	    }
	    
	    private Node min(Node x) {
	        if (x.left == null)
	            return x;
	        return min(x.left);
	    }
	    
	    @Override
	    public Key max() {
	      return max(root).key;
	    }
	    
	    private Node max(Node x) {
	        if (x.right == null) return x;
	        return min(x.right);
	    }
	    
	    @Override
	    public Key floor(Key key) {
	        Node x = floor(root, key);
	        if (x == null)
	            return null;
	        return x.key;
	    }
	    
	    private Node floor(Node x, Key key) {
	        if (x == null)
	            return null;
	        int cmp = key.compareTo(x.key);
	        if (cmp == 0) return x;
	        if (cmp < 0) return floor(x.left, key);
	        Node t = floor(x.right, key);
	        if (t != null) return t;
	        else return x;
	    }
	    
	    @Override
	    public Key select(int k) {
	        return select(root, k).key;
	    }
	    
	    private Node select(Node x, int k) {
	        if (x == null) return null;
	        int t = size(x.left);
	        if (t > k) return select(x.left, k);
	        else if (t < k) return select(x.right, k-t-1);
	        else return x;
	    }
	    
	    @Override
	    public int rank(Key key) {
	        return rank(key, root);
	    }
	    
	    private int rank(Key key, Node x) {
	        // Return number of keys less than x.key in the subtree rooted at x.
	        if (x == null) return 0;
	        int cmp = key.compareTo(x.key);
	        if (cmp < 0) return rank(key, x.left);
	        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
	        else return size(x.left);
	    }
	    
	    @Override
	    public void deleteMin() {
	        root = deleteMin(root);
	    }
	    
	    private Node deleteMin(Node x) {
	        if (x.left == null) return x.right;
	        x.left = deleteMin(x.left);
	        x.N = size(x.left) + size(x.right) + 1;
	        return x;
	    }
	    
	    @Override
	    public void delete(Key key) {
	        root = delete(root, key);
	    }
	    
	    private Node delete(Node x, Key key) {
	        if (x == null) return null;
	        int cmp = key.compareTo(x.key);
	        if (cmp < 0) x.left = delete(x.left, key);
	        else if (cmp > 0) x.right = delete(x.right, key);
	        else
	        {
	            if (x.right == null) return x.left;
	            if (x.left == null) return x.right;
	            Node t = x;
	            x = min(t.right);
	            x.right = deleteMin(t.right);
	            x.left = t.left;
	        }
	        x.N = size(x.left) + size(x.right) + 1;
	        return x;
	    }

	    @Override
	    public Iterable<Key> keys() {
	        return keys(min(), max());
	    }
	    
	    @Override
	    public Iterable<Key> keys(Key lo, Key hi)
	    {
	        Queue<Key> queue = new LinkedList<>();
	        keys(root, queue, lo, hi);
	        return queue;
	    }
	    
	    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
	    {
	        if (x == null) return;
	        int cmplo = lo.compareTo(x.key);
	        int cmphi = hi.compareTo(x.key);
	        if (cmplo < 0) keys(x.left, queue, lo, hi);
	        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
	        if (cmphi > 0) keys(x.right, queue, lo, hi);
	    }
	    
	    @Override
	    public boolean contains(Key key) {
	    	return true;
	        //throw new UnsupportedOperationException("Not supported yet.");
	    }

	    @Override
	    public boolean isEmpty() {
	    	return false;
	        //throw new UnsupportedOperationException("Not supported yet.");
	    }

	    @Override
	    public Key ceiling(Key key) {
	        return key;
	    }
	    
	    @Override
	    public void deleteMax() {
	        throw new UnsupportedOperationException("Not supported yet.");
	    }

	    @Override
	    public void size(Key lo, Key hi) {
	        throw new UnsupportedOperationException("Not supported yet.");
	    }
	    
	    public void balance() {
	        throw new UnsupportedOperationException("Not supported yet.");
	    }
	    
	    public void printLevel(Key key) {
	        throw new UnsupportedOperationException("Not supported yet.");
	    }

	    /**
	     * entry point for testing.
	     * 
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        BreshearsBSTST<Integer, String> bst = new BreshearsBSTST();
	        
	        bst.put(10, "TEN");
	        bst.put(3, "THREE");
	        bst.put(1, "ONE");
	        bst.put(5, "FIVE");
	        bst.put(2, "TWO");
	        bst.put(7, "SEVEN");
	        
	        bst.contains(10);
	        bst.isEmpty();
	        bst.ceiling(10);
	        bst.deleteMax();
	        bst.size();
	        
	        
	        
	        System.out.println("Before balance:");
	        bst.printLevel(10); //root 
	        
	        System.out.println("After balance:");
	        bst.balance();
	        bst.printLevel(5); //root
	    }
	}

