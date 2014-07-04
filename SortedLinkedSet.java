

	// ***********************************************************************
	//
	// SortedSet Class Interface
	//
	// ***********************************************************************
	// Computer Science 102: Data Structures
	// Spring 2014
	// Eric Koskinen
	// New York University
	// ***********************************************************************

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	// %%%%% There are several tasks here, including:
	// %%%%% 1. Implement the copy constructor
	// %%%%% 2. SortedLinkedSet is now generic
	// %%%%% 3. SortedLinkedSet does not allow duplicates 
	// %%%%%    (i.e. it is not a multiset)
	// %%%%% 4. Implement the new Set operations: unionWith, etc.
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public class SortedLinkedSet<T extends Comparable<T>> implements Set<T>, Collection<T> {
	    /**
	     * Private Data
	     */
	    protected SortedLinkedSetNode<T> firstNode;

	    /**
	     * Constructors
	     */
	    public SortedLinkedSet(SortedLinkedSetNode<T> n) { firstNode = n ; }
	    public SortedLinkedSet() { firstNode = null; }

	    /**
	     * Copy Constructor
	     */
	    public SortedLinkedSet(SortedLinkedSet<T> copy) {
		    
	    	//this may be wrong, not necessarily copying the value
	    	while (firstNode.getNext() != null && copy.firstNode.getNext() != null) {
		    	 firstNode = copy.firstNode;
		    	 firstNode = firstNode.getNext();
		    	 copy.firstNode = copy.firstNode.getNext();
		    }
	    	

	    }

	    /**
	     * Getters and Setters
	     */
	    public SortedLinkedSetNode<T> getFirstNode() {
		return firstNode;
	    }
		
	    /**
	     * return the size of the list
	     */
	    public int size() {
		if (firstNode == null) return 0;
		else return firstNode.size();
	    }

	    /**
	     * Find the minimum element of the list
	     */    
	    public T min() throws SortedLinkedSetException {
		if (firstNode == null) throw new SortedLinkedSetException("Empty");
		else return firstNode.min();
	    }

	    /**
	     * Find the maximum element of the list
	     */    
	    public T max() throws SortedLinkedSetException {
		if (firstNode == null) throw new SortedLinkedSetException("Empty");
		else return firstNode.max();
	    }

	    /**
	     * Determine whether the list is empty
	     */    
	    public boolean isEmpty() {
		return ( firstNode == null ? true : false );
	    }

	    /**
	     * Determine whether the list contains element el
	     */    
	    public boolean contains(T el) {
		if (firstNode == null) { return false; }
		else return firstNode.contains(el);
	    }
	    
	    /**
	     * Add element el to the list (maintaining sort order)
	     */    
	    public boolean add(T el) {
		if (firstNode == null || el.compareTo(firstNode.getValue()) > 0 ) {
		    //the new element will become the new first node
		    firstNode = new SortedLinkedSetNode<T>(el, firstNode);
		    return true;
		} else { 
		    return firstNode.add(el);
		}
	    }

	    /**
	     * Remove element el to the list (maintaining sort order)
	     */    
	    public boolean remove(T el) { 
		if (firstNode == null) {
		    return false;
		} else if (firstNode.getValue().equals(el)) { 
		    firstNode = firstNode.getNext();
		    return true;
		} else {
		    return firstNode.remove(el); 
		}
	    }

	    /**
	     * (add comments here)
	     */    
	    public SortedLinkedSet<T> unionWith(SortedLinkedSet<T> other) {
	    	SortedLinkedSet<T> newSet = new SortedLinkedSet<T>();
	    	while (firstNode.getNext() != null) {
	    		if (firstNode.compareTo(other.firstNode) == -1) {
	    			newSet.firstNode = other.firstNode;
	    		
	    			other.firstNode = other.firstNode.getNext();
	    			
	    		}
	    		else if (firstNode.compareTo(other.firstNode) == 0) {
	    			newSet.firstNode = firstNode;
	    			other.firstNode = other.firstNode.getNext();
	    			
	    			firstNode = firstNode.getNext();
	    		}
	    		else {
	    			newSet.firstNode = firstNode;
	    			firstNode = firstNode.getNext();
	    			
	    		}
	    	while (other.firstNode.getNext() != null) {
	    		newSet.firstNode = other.firstNode;
	    		other.firstNode = other.firstNode.getNext();
	    	
	    	}
	    }


	    }

	    /**
	     * (add comments here)
	     */    
	    public SortedLinkedSet<T> intersectWith(SortedLinkedSet<T> other) {
	    	SortedLinkedSet<T> newSet = new SortedLinkedSet<T>();
	    	while (firstNode.getNext() != null) {
	    	
	    		if (firstNode.compareTo(other.firstNode) == 0) {
	    			newSet.firstNode = other.firstNode;
	    		
	    			other.firstNode = other.firstNode.getNext();
	    			newSet.firstNode = newSet.firstNode.getNext();
	    		}
	    		else  {
	    			other.firstNode = other.firstNode.getNext();
	    			newSet.firstNode = newSet.firstNode.getNext();
	    			firstNode = firstNode.getNext();
	    		}
	    		
	    	}

	    }

	    /**
	     * (add comments here)
	     */    
	    public SortedLinkedSet<T> setDifferenceWith(SortedLinkedSet<T> other) {
	    	SortedLinkedSet<T> newSet = new SortedLinkedSet<T>();
	    	while(firstNode.getNext() != null) {
	    		
	    		SortedLinkedSetNode<T> head = other.firstNode;
	    		boolean flag = true; //flag checks if firstNode is in other.
	    		while (other.firstNode.getNext() != null) {
	    			if (firstNode.compareTo(other.firstNode) == 0) {
	    				firstNode = firstNode.getNext();
	    				flag = false;
	    				break;
	    			}
	    			
	    		}
	    		other.firstNode = head;
	    		if(flag){
	    			newSet.firstNode = firstNode;
	    		}
	    		else{
	    			flag = true;
	    		}
	    	}
		

	    }


	    @Override 
	    public String toString() {
		if(firstNode == null) {
		    return "[]";
		} else {
		    return "[" + firstNode.toString() + "]";
		}
	    }

	    // Output operations
	    public void PrettyPrint() {
		System.out.printf(this.toString() + "\n");
	    }
		
	    public int compareTo(T o) {
		return 0;
	    }
	}


