package proj2;

/**
 * @author Pratik Raj
 * @version April 20, 2022.
 * I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */

/**
 *  1. The number of elements in the sequence is stored in the instance variable manyItems.
 *
 * 2. For an empty sequence (with no elements), we do not care what is stored in any of data;
 * for a nonempty sequence, the elements of the sequence are stored from the front to the end in data[0]
 * to data[manyItems-1], and we don’t care what is stored in the rest of data.
 *
 * 3. If there is a current element, then it lies in data[currentIndex]; if there is no current element,
 * then currentIndex equals manyItems.
 */


/**
 * Class Description
 *I have built a container called a Sequence. Like an array, a sequence stores objects that are all the same type.
 * sequence will have a current capacity, which is the num- ber of elements the sequence can hold without
 * having to request more memory. The initial capacity will be set by the constructor. The capacity can be
 * increased in several manners, which is specified in the various methods of the new class.
 */
public class Sequence
{

    private String[] container;
    private int manyItems;
    private int currentIndex;

    /**
     * Creates a new sequence with initial capacity 10.
     */

    public Sequence() {
        // capacity is reflected in the length of the
        // internal array
        container = new String[10];
        manyItems = 0;
        currentIndex = 0;
    }


    /**
     * Creates a new sequence.
     *
     * @param initialCapacity the initial capacity of the sequence.
     */
    public Sequence(int initialCapacity){
        // capacity is reflected in the length of the
        // internal array
        container = new String[initialCapacity];
        manyItems = 0;
        currentIndex = 0;
    }


    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value) {
        if (!isCurrent()){
            start();
        }
        if (size() >= getCapacity()) {
            ensureCapacity(2 * getCapacity() + 1);
        }
        shiftRit(currentIndex);
        container[currentIndex] = value;
        manyItems += 1;
    }


    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value) {

        this.advance();
        this.addBefore(value);
    }

    /**
     * Shifts the elements of an array.
     *
     * @param start
     */
    public void shiftRit(int start){
        for(int i = manyItems - 1; i >= start; i-- ){
            container[i+1] = container[i];
        }
    }



    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent()
    {
        return currentIndex != manyItems;
    }


    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
        return container.length;
    }


    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
        if (isCurrent()) {
            return container[currentIndex];
        }
        return null;
    }



    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (getCapacity() < minCapacity){
            String[] newHolder = new String[minCapacity];
            for (int i = 0; i < manyItems; i++){
                newHolder[i] = container[i];
            }
            container = newHolder;
        }


    }


    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make room for
     * all the elements to be added.
     *
     * Post-condition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another)
    {
        int reqSize = another.size() + this.size();


        if (reqSize > size()){

            String[] newHolder = new String[10];
            int count = 0;

            for (int i = 0; i < manyItems; i++){
                newHolder[i] = container[i];
                count++;
            }

            for (int j = count; j < reqSize; j++){

                if(!isCurrent()){
                    currentIndex++;
                }
                newHolder[j] = another.getCurrent();
                another.advance();
                manyItems++;
            }

            container = newHolder;
        }
    }


    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     * @param
     */
    public void advance()
    {
        if(isCurrent()) {
            currentIndex = currentIndex + 1;
        }
    }



    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     *
     * Post-condition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */
    public Sequence clone()
    {
        Sequence newSequence = new Sequence(getCapacity());
        newSequence.addAll(this);

        return newSequence;
    }

    //this is the piece of code I have no fuking idea of:
    // Colby beach is a son of a beach


    /**
     * Remove the current element from this sequence.  The following
     * element, if there was one, becomes the current element.  If
     * there was no following element (current was at the end of the
     * sequence), the sequence now has no current element.
     *
     * If there is no current element, does nothing.
     */
    public void removeCurrent()
    {
        if (isCurrent()){
            for(int i = currentIndex; i < manyItems-1; i++)
                container[i] = container[i +1];
        }
        manyItems--;
    }


    /**
     * @return the number of elements stored in the sequence.
     */
    public int size()
    {
        return manyItems;
    }


    /**
     * Sets the current element to the start of the sequence.  If the
     * sequence is empty, the sequence has no current element.
     * @return
     */
    public boolean start()
    {
            currentIndex = 0;

        return false;
    }


    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {
        String[] newHolder = new String[manyItems];
        for (int i = 0; i < manyItems; i++){
            newHolder[i] = container[i];
        }
        container = newHolder;

    }


    /**
     * Produce a string representation of this sequence.  The current
     * location is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the current element, and the
     * capacity is 5, would print as:
     *
     *    {A, >B} (capacity = 5)
     *
     * The string you create should be formatted like the above example,
     * with a comma following each element, no comma following the
     * last element, and all on a single line.  An empty sequence
     * should give back "{}" followed by its capacity.
     *
     * @return a string representation of this sequence.
     */
    public String toString()
    {
        String seq = "{";

        for (int i = 0; i < size(); i++){
            if(i == currentIndex){
                seq += ">";
            }
            seq +=  container[i];
            if( manyItems > i +1){
                seq += ", ";
            }
        }
        seq += "} ";
        seq += "(capacity = " + getCapacity() + ")";
        return seq;

    }

    /**
     * Checks whether another sequence is equal to this one.  To be
     * considered equal, the other sequence must have the same size
     * as this sequence, have the same elements, in the same
     * order, and with the same element marked
     * current.  The capacity can differ.
     *
     * Post-condition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     *
     * @param other the other Sequence with which to compare
     * @return true iff the other sequence is equal to this one.
     */
    public boolean equals(Sequence other)
    {

        if(this.size() == other.size()){

            for(int x = 0; x < this.size(); x++){

                if(this.getCurrent() == null){
                    if(other.getCurrent() != null) return false;
                }else if(other.getCurrent() == null){
                    if(this.getCurrent() != null) return false;
                }

                else{

                    if(!this.getCurrent().equals(other.getCurrent())) return false;

                }

                this.advance();
                other.advance();
            }
        }else{
            return false;
        }

        return true;
    }


    /**
     *
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }


    /**
     *  empty the sequence.  There should be no current element.
     * @return
     */
    public void clear()
    {
        manyItems = 0;
        currentIndex = manyItems;

    }

}