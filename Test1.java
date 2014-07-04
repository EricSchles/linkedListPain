// ***********************************************************************
//
// Test1 -- Example of a test
//
// ***********************************************************************
// Computer Science 102: Data Structures
// Spring 2014
// Eric Koskinen
// New York University
// ***********************************************************************

public class Test1 extends TestHarness{
	 public Test1(String s) { super(s); }
	 
	 public boolean test(){
		 SortedLinkedSet<Integer> fibs = new SortedLinkedSet<Integer>();
		 SortedLinkedSet<Integer> primes = new SortedLinkedSet<Integer>();
		 
		 // put some fibonacci numbers in fibs
		 fibs.add(1);
		 fibs.add(2);
		 fibs.add(3);
		 fibs.add(5);
		 fibs.add(8);
		 fibs.add(13);
		 fibs.add(21);

		 // put some prime numbers in primt
		 primes.add(1);
		 primes.add(2);
		 primes.add(3);
		 primes.add(5);
		 primes.add(7);
		 primes.add(11);
		 primes.add(13);

		 System.out.println("Primes:");
		 primes.PrettyPrint();
		 System.out.println("Fibs:");
		 fibs.PrettyPrint();

		 // what numbers are either?
		 SortedLinkedSet<Integer> union = primes.unionWith(fibs);
		 System.out.println("These are either prime or a fib:");
		 union.PrettyPrint();
		 if(!union.contains(21) ||
		    !union.contains(1))
		     return false;

		 // what numbers are prime and also fib?
		 SortedLinkedSet<Integer> isect = primes.intersectWith(fibs);
		 System.out.println("These must be both a prime and a fib:");
		 isect.PrettyPrint();
		 if(!isect.contains(13) ||
		    !isect.contains(1))
		     return false;

		 // remove 123 from the union:
		 SortedLinkedSet<Integer> S123 = new SortedLinkedSet<Integer>();
		 S123.add(1); S123.add(2); S123.add(3);
		 SortedLinkedSet<Integer> t = union.setDifferenceWith(S123);
		 System.out.println("This everything seen so far, except 123");
		 t.PrettyPrint();
		 if(!t.contains(21) ||
		    !t.contains(5))
		     return false;

		 // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		 // %%% Your Test should check whether the sets
		 // %%% contain what they should contain and return
		 // %%% false if not
		 // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		 return true;
	 }
}
