package HashPackage;

import java.util.Queue;

public class LinearProbingHT<Key, Value> implements SymbolTable{
	
	private static int capacity = 997;
	private Key[] myKey;
	private Value[] myValue;
	private int n;
	private int m;
	
	public LinearProbingHT(){
		this(capacity);
	}
	private int hash(Object key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

	public LinearProbingHT(int capacity2) {
		m = capacity;
		n = 0;
		myKey = (Key[]) new Object[m];
		myValue = (Value[]) new Object[m];
	}


	public void put(Key key, Value val) {
		// TODO Auto-generated method stub
		int i;
        for (i = hash(key); myKey[i] != null; i = (i + 1) % m) {
            if (myKey[i].equals(key)) {
               myValue[i] = val;
                return;
            }
        }
        myKey[i] = key;
        myValue[i] = val;
        n++;
    }
		
	

	@Override
	public Object get(Object key) {
		for (int i = hash(key); key[i] != null; i = (i + 1) % m)
        if (key[i].equals(key))
            return vals[i];
		return null;
	}

	@Override
	public void delete(Object key) { // this is optional
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size() ==0){
			return true;
		}
		else
			return false;
	}

	@Override
	public int size() {
		
		return n;
	}

	@Override
	public Iterable keys() {
		Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (myKey[i] != null) queue.enqueue(myKey[i]);
        return queue;
	}
	@Override
	public void put(Object key, Object val) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void put(Object key, Object val) {
		// TODO Auto-generated method stub
		
	}
	

}
