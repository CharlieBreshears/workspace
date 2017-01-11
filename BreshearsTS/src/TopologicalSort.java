
public interface TopologicalSort {
	 /**
     * Returns an iterable object containing a topological sort.
     * @return a topological sort.
     */
    public Iterable<Integer> order();
    
    /**
     * Returns true if the graph being sorted is a DAG, false otherwise.
     * @return is graph a DAG
     */
    public boolean isDAG();

}
