package HashPackage;

public class TwoProbeChainHT<Key, Value> implements SymbolTable{

	    private int N; // number of key-value pairs
	    private int M; // hash table size
	  

	    public TwoProbeChainHT() {
	        this(997);
	    }

	    public TwoProbeChainHT(int M) {
	        this.M = M;

	    
	    private int hash(Key key) {
	        return (key.hashCode() & 0x7fffffff) % M;
	    }

		@Override
		public void put(Object key, Object val) {
			// TODO Auto-generated method stub
			st[hash(key)].put(key, val);

			
		}

		@Override
		public Object get(Object key) {
		
			return (Value) st[hash(key)].get(key);

		}

		@Override
		public void delete(Object key) {
		
		}

		@Override
		public boolean contains(Object key) {
			
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
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Iterable keys() {
			// TODO Auto-generated method stub
			return null;
		}


}
