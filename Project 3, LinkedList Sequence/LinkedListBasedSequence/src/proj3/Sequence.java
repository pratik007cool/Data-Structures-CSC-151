package proj3;

/**
 * @author Pratik Raj
 * @version May 3rd, 2022.
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
 *I have built a container called a proj3.Sequence. A sequence stores objects that are all the same type.
 * sequence will have a current capacity, which is the number of elements the sequence can hold without
 * having to request more memory. The initial capacity will be set by the constructor. The capacity can be
 * increased in several manners, which is specified in the various methods of the new class.
 */

//Sugma Cock Pratik Raj you little cunty bithc fag

public class Sequence
{
    public static final int DEFAULT_CAPACITY = 10;
    private LinkedList contents;
    private int manyItems;
    private int currentIndex;
    private int capacity;
    /**
     * Creates a new sequence with initial capacity 10.
     */
    public Sequence() {
        manyItems = 0;
        currentIndex = 0;
        capacity = DEFAULT_CAPACITY;
        contents = new LinkedList();
    }


    /**
     * Creates a new sequence.
     *
     * @param initialCapacity the initial capacity of the sequence.
     */
    public Sequence(int initialCapacity){
        manyItems = 0;
        currentIndex = 0;
        capacity = initialCapacity;
        contents = new LinkedList();

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
    public void addBefore(String value){
        if (!isCurrent()){
            start();
        }
        if (size() >= getCapacity()) {
            ensureCapacity(2 * getCapacity() + 1);
        }

        contents.insertAtIndex(value, currentIndex);
        manyItems++;
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

        if (!isCurrent()) {
            contents.insertAtTail(value);
            manyItems++;
         }else{
            this.advance();
            if(manyItems == currentIndex){
                contents.insertAtTail(value);
                manyItems++;
            }else{
                this.addBefore(value);
            }
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
        return capacity;
    }


    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {
        if(!isCurrent()) return null;

        return contents.get_ith_item(currentIndex);
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
        if(getCapacity() < minCapacity){
            capacity = minCapacity;
        }
    }


    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make (just enough) room for
     * all of the elements to be added.
     *
     * Postcondition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another)
    {
        this.ensureCapacity(this.size()+ another.size());


        boolean cur = this.isCurrent();
        int tempIndex = this.currentIndex;
        int anotherIndex = another.currentIndex;

        this.currentIndex = this.size() -1;
        another.start();

        while(another.isCurrent()){
            addAfter(another.getCurrent());

            this.advance();
            another.advance();
        }

        if(!cur){
            this.currentIndex = manyItems;
        }else{
            this.currentIndex = tempIndex;
        }
        another.currentIndex = anotherIndex;
    }


    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     */
    public void advance()
    {
        if(isCurrent()) {
            currentIndex++;
        }
    }


    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     *
     * Postcondition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */
    public Sequence clone()
    {
        Sequence newSequence = new Sequence(getCapacity());
        newSequence.addAll(this);
        newSequence.currentIndex = this.currentIndex;

        return newSequence;
    }


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
        if (isCurrent()) {
            contents.remove(currentIndex);
            manyItems--;

            if(currentIndex+1 == manyItems){
                currentIndex = manyItems;
            }
        }

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
     */
    public void start()
    {
        currentIndex = 0;
        //return false;

    }


    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {
        capacity = manyItems;
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
        for (int i = 0; i < this.size(); i++){
            if(i == currentIndex){
                seq += ">";
            }
            seq +=  contents.get_ith_item(i);
            if(manyItems > i +1){
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
     * Postcondition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     *
     * @param other the other proj3.Sequence with which to compare
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
     * @return true if proj3.Sequence empty, else false
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }


    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear()
    {
        manyItems = 0;
        currentIndex = manyItems;
    }

}