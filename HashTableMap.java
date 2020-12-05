// --== CS400 File Header Information ==--
// Name: Uday Malhotra
// Email: umalhotra@wisc.edu
// Team: LB
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;
/**
 * This class implements the MapADT to create a working modelf of a 
 * hash table.
 * 
 * The table handles collisions through chaining, and make use of a class
 * called LinkedPair, which is used to store the key value pairs.
 * 
 * The class provides methods to add, remove, and retrieve key value pairs
 * and so on.
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
    int capacity;   // variable to track capacity
    protected LinkedPair<KeyType, ValueType>[] pairs;
    int size;   // variable to track size

    /*
    * Default constructor to create a HashTableMap object to
    * store a key value pairs.
    *
    * Allocates default capacity and creates a LinkedPair array
    *
    * Sets size to 0.
    *
    * @param capacity capacity of table to be created
    */
    public HashTableMap(){
        capacity=10;
        pairs= new LinkedPair[capacity];
        size=0;
    }

    /*
    * Parametereized constructor to create a HashTableMap object to
    * store a key value pairs.
    *
    * Allocates capacity and creates a LinkedPair array
    *
    * Sets size to 0.
    *
    * @param capacity capacity of table to be created
    */
    public HashTableMap(int capacity){
        this.capacity=capacity;
        pairs= new LinkedPair[capacity];
        size=0;

    }

    /*
    * This is a private helper method that grows the
    * array that stores key value pairs when load capacity
    * is met or exceeded.
    *
    * All elements are copied to new array with double the 
    * capacity, and keys are rehashed and stored.
    *
    */
    private void grow(){
        // creating a clone of current array
        LinkedPair<KeyType, ValueType>[] clone= new LinkedPair[capacity]; 
        for(int i=0; i< capacity; i++){
            // copying all key value pairs to clone
            if(pairs[i]!=null)
            clone[i]= pairs[i];
    }   
        // updating capacity to grow array
        capacity= capacity*2;
        // resetting size
        size=0;
        LinkedPair<KeyType, ValueType>[] updated = new LinkedPair[capacity];
        pairs=updated; // changing old array reference to new bigger array
        //looping to rehash and store all pairs
        for(int i=0; i<clone.length; i++){
          if(clone[i]!=null){
            LinkedPair<KeyType, ValueType> temp= clone[i];
            // going through chain to add all pairs
            while(temp!=null){
                // putting pairs in new array
               put(temp.getKey(), temp.getValue());
               temp=temp.getNext();
            }
          }
          // continue to next position if array index is null
          else
          continue; 
        }
    }

    /*
    * This method adds a new key value pair to the array.
    *
    * It checks for collisions and handles them appropriately
    * through chaining.
    *
    * If load capacity is met, calls grow() to grow the array.
    *
    * Only adds pair if key is unique.
    *
    * @param key Key to be hashed
    * @param value Value to bo stored with key
    * @return true if pair is added succesfully.
    *
    */
    @Override
    public boolean put(KeyType key, ValueType value) {
        if(containsKey(key)) // checking if key is unqiue
        return false;
        // calculating position in array to store the pair
        // by hashing the key
        int hashed= Math.abs(key.hashCode())%capacity;
        // if no collision, store pair
        if(pairs[hashed]==null)
        pairs[hashed]=new LinkedPair<KeyType, ValueType>(key, value);
        else{
        // in case of collision, use chaining
        LinkedPair<KeyType, ValueType> temp= pairs[hashed];
        while(temp.getNext()!=null){
        //searching for last pair chained together
        temp= temp.getNext();
        }
        // storing pair, and updating previous and next reference
        temp.setNext(new LinkedPair<KeyType, ValueType>(key, value, null, temp));
    }
        size++; // incrememnting size 
        // checking if load capacity is met/exceeded
        if(size>=(capacity*0.8)){
            grow();
        }
        return true;
    }

    /*
    * This method is used to look up a key value pair.
    *
    * It checks if key value pair is stored in array, and
    * throws a NoSuchElement exception when key is not found.
    *
    * @param key Key to be look up pair
    * @return the value associate with key used for lookup.
    *
    */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        // checking if key is stored
        if(!containsKey(key))
        throw new NoSuchElementException();      
        else{
        // calculating position in array to find the pair
        // by hashing the key
        int hashed= Math.abs(key.hashCode())%capacity;
        // checking if first pair in chain is a match
        if(pairs[hashed].getKey().equals(key)){
        //returning if match found
        return pairs[hashed].getValue();
        }
        else{
            // going through chain to find a match
            LinkedPair<KeyType, ValueType> temp= pairs[hashed].getNext();
            // looping till the last pair
            while(temp!=null){
                //checking each pair for a match
                if(temp.getKey().equals(key))
                //returning if match found
                return temp.getValue();
                else
                temp=temp.getNext();
            }
                }
            } 
            return null;   
    }

    /*
    * This method is used to return the number of 
    * key value pairs stored in the array.
    *
    * @return number of pairs stored in array.
    *
    */
    @Override
    public int size() {
        return size;
    }

    /*
    * This method is used to check if a particular key
    * is already stored in the array.
    *
    * It looks through the array to find a matching key,
    * and goes through each chain if required.
    *
    * @param key Key to be look up 
    * @return true if key is found
    *
    */
    @Override
    public boolean containsKey(KeyType key) {
        // looping through entire array
        for(int i=0; i < capacity; i++){
            // checking if position has a pair stored
            if(pairs[i]!=null){
            // searching for key through chain
            LinkedPair<KeyType, ValueType> temp= pairs[i];
            // looping till the end of chain
            while(temp!=null){
            // if match found, return true
            if(temp.getKey().equals(key))
            return true;
            else
            temp=temp.getNext();
            }
        }
    }
        //no match found
        return false;
    }

    /*
    * This method is used to remove a key-value pair.
    *
    * It checks if key value pair to be removed is stored in array,
    * and returns null if it isn't.
    *
    * Updates size after deleting pair from array.
    * Re structures chain if pair was chained.
    *
    * @param key Key to be removed
    * @return the value associate with key to remove
    *
    */
    @Override
    public ValueType remove(KeyType key) {
        // local variable to store value associated with key to remove
        ValueType toRemove=null;
        // checking if key is stored in array
        if(!containsKey(key))
        return null;
        else{
            // hashing key to to look for position in array
            int hashed= Math.abs(key.hashCode())%capacity;
            // case where just one pair is stored in position
            if(pairs[hashed].getKey().equals(key)&& pairs[hashed].getNext()==null){
                // storing value associsted with key to remove
                toRemove= pairs[hashed].getValue(); 
                pairs[hashed]=null;
            }
            // case where first element in a chain is to be removed
            else if(pairs[hashed].getKey().equals(key)&& pairs[hashed].getNext()!=null){
                toRemove= pairs[hashed].getValue();
                // changing reference to the next pair
                pairs[hashed]=(pairs[hashed].getNext());
            }
            else{
                // case where pair to be removed is not the first pair in chain
                LinkedPair<KeyType, ValueType> temp= pairs[hashed]; 
                // looping till pair is found
            while(temp!=null){
            if(temp.getKey().equals(key)){
                // storing value that is removed
                toRemove=temp.getValue();
                //changing temp reference to previous pair
                temp=temp.getPrevious();
                // changing its next refernce to skip over pair to be removed
                temp.setNext(temp.getNext().getNext());
            }
            else
            temp=temp.getNext();
        }

            }

        }
        // decrementing size after removal
        size--;
        return toRemove;
    }
   
    /*
    * This method is used to clear all pairs from the table
    *
    */
    @Override
    public void clear() {
        // creating a new empty array
        LinkedPair<KeyType, ValueType>[] newPairs= new LinkedPair[capacity]; 
        // changing reference of filled array to empty array
        pairs = newPairs;
        size = 0;
    }

}
