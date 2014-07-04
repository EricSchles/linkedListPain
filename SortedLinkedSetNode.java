

// ***********************************************************************
//
// SortedSetNode Class Interface
//
// ***********************************************************************
// Computer Science 102: Data Structures
// Spring 2014
// Eric Koskinen
// New York University
// ***********************************************************************

// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
// %%%%% IMPLEMENT THIS CLASS TO BE GENERIC. MUCH
// %%%%% OF THE WORK HAS ALREADY BEEN DONE FOR YOU
// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

public class SortedLinkedSetNode<T extends Comparable<T>> {


 
    protected T value;
    protected SortedLinkedSetNode<T> next;

    public SortedLinkedSetNode(T v, SortedLinkedSetNode<T> n) {
	value = v; next = n;
    }
    public SortedLinkedSetNode(T v) {
	value = v; next = null;
    }
    public T getValue() {
	return value;
    }
    public SortedLinkedSetNode<T> getNext() {
	return next;		
    }
	
    // Basic operations
    public int size() {
	if (next == null) return 1;
	else return 1 + next.size();
    }
    
    public T min() {
	if (next == null) return value;
	else return next.min();
    }
    public T max() {
	return value;
    }

    public boolean isEmpty() {
	return false;
    }

    public boolean contains(T el) {
	if (value.equals(el)) return true;
	else if (next == null) return false;
	else return next.contains(el);
    }

    public boolean add(T el) {
    	if (value.compareTo(el) == 0) {
     	   return false;
        }
        else if (value.compareTo(el) > 0){
     	    this.next = new SortedLinkedSetNode(el,this.getNext());
     	    return true;
        }
        else if (next == null) {
     	   new SortedLinkedSetNode(el);
     	   return true;
        }
        else {
     	   //in this case compareTo gives us greater than 0
     	   return next.add(el);
        }
    	

    }

    public boolean remove(T element) {
	if (next == null) return false;
	else if (next.getValue().equals(element)) {
	    next = next.getNext();
	    return true;
	} else {
	    return next.remove(element);
	}
    }

    public String toString() {
	if(next == null) return getValue().toString();
	else return getValue().toString() + ", " + next.toString();
    }
	
    public void PrettyPrint() {

    }

    public int compareTo(T o) {
	return getValue().compareTo(o);
    }	
}
