
// --== CS400 File Header Information ==--
// Name: Uday Malhotra
// Email: umalhotra@wisc.edu
// Team: LB
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: This class is my customized Linked List style class
//                  to help with key-value retrieval.
//

/**
 * This class designs a customized Linked List style class
 * that aids in storing key value pairs.
 * 
 * It provides getters for keys and values, and also setters
 * to change references to the next and previous key calue pair.
 * 
 */
public class LinkedPair<KeyType, ValueType> {
    private KeyType k;
    private ValueType v;
    private LinkedPair<KeyType, ValueType> next;
    private LinkedPair<KeyType, ValueType> previous;

    /*
    * First constructor to create a Linked Pair object to
    * store a key value pair. Sets next and previous to null.
    *
    * @param k The key to be hashed
    * @param v The value associated with key to be stored.
    */
    public LinkedPair(KeyType k, ValueType v) {
        this.k=k;
        this.v=v;
        this.next=null;
        this.previous=null;
      }

   /*
    * Second constructor to create a Linked Pair object to
    * store a key value pair. 
    *
    * Sets next and previous to manually according to parameters
    * passed.
    *
    * Generally called while chaining.
    *
    * @param k The key to be hashed
    * @param v The value associated with key to be stored.
    * @param next The reference of the next LinkedPair.
    * @param previous The reference of the previous LinkedPair.
    */
      public LinkedPair(KeyType k, ValueType v, LinkedPair<KeyType, ValueType> next,
       LinkedPair<KeyType, ValueType> previous) {
        this.k=k;
        this.v=v;
        this.next=next;
        this.previous=previous;
      }

      /*
      * Getter that returns the key.
      *
      * @return key of key value pair
      */
      public KeyType getKey(){
          return this.k;
      }

     /*
      * Getter that returns the value.
      *
      * @return value stored in key value pair
      */
      public ValueType getValue(){
          return this.v;
      }

     /*
      * Getter that returns the reference of next LinkedPair.
      *
      * @return refernce to next associated LinkedPair
      */
      public LinkedPair<KeyType, ValueType> getNext(){
        return this.next;
    }

     /*
      * Getter that returns the reference of previous LinkedPair.
      *
      * @return refernce to previous associated LinkedPair
      */
      public LinkedPair<KeyType, ValueType> getPrevious(){
        return this.previous;
    }

     /*
      * Setter that sets the reference of next LinkedPair.
      */
    public void setNext(LinkedPair<KeyType, ValueType> pair){
        this.next=pair;
    }
    
     /*
      * Setter that sets the reference of previous LinkedPair.
      */
    public void setPrevious(LinkedPair<KeyType, ValueType> pair){
        this.previous=pair;
    }
   
}

