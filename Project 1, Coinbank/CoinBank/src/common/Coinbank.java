package common;  // Don't change the package name.  Gradescope expects this.

/**
 * FILL THIS IN FOR EVERY PROJECT.  Include a class description, name, and date (for version) 
 * @author Pratik Raj
 * @version April 12, 2022.
 * I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */
public class Coinbank {
	
	// Denominations
	public static final int PENNY_VALUE = 1;
	public static final int NICKEL_VALUE = 5;
	public static final int DIME_VALUE = 10;
	public static final int QUARTER_VALUE = 25;
	
	// give meaningful names to holder array indices
	private final int PENNY = 0;
	private final int NICKEL = 1;
	private final int DIME = 2;
	private final int QUARTER = 3;
	
	// how many types of coins does the bank hold?
	private final int COINTYPES = 4;

	private int[] holder;

	
	/**
	 * Default constructor
	 * Making sure the bank originally has no coins.
	 */
	public Coinbank() {
		// Erase and fill me in!
		holder = new int[COINTYPES];
		for (int i = 0; i < COINTYPES; i++){
			holder[i] = 0;
		}

	}

	/**
	 * Checking for valid coin type if the coin type is invalid it does nothing!
	 * @param coinType
	 * @return
	 */
	private boolean isValidCoinType(int coinType) {

		return coinIndex(coinType) != -1;
	}

	/**
	 * takes the coin type and return the index where it is stored in the array.
	 * @param coinType
	 * @return index of the cointype.
	 */
	private int coinIndex(int coinType) {
		int[] denom = new int[]{PENNY_VALUE, NICKEL_VALUE, DIME_VALUE, QUARTER_VALUE};
		int[] indices = new int[]{PENNY, NICKEL, DIME, QUARTER};
		for (int index = 0; index < indices.length; index++) {
			if (denom[index] == coinType) {
				return indices[index];
			}

		}
		return -1;
	}


	/**
	 * getter
	 * @param coinType denomination of coin to get. Valid denominations are 1,5,10,25
	 * @return number of coins that bank is holding of that type, or -1 if denomination not valid
	 */
	public int get(int coinType) {
		if (isValidCoinType(coinType)) {
			return holder[coinIndex(coinType)];
		}
		else {
			return -1;
		}
	}
	
	/**
	 * setter
	 * It makes the bank hold numCoins of type coinType.
	 * coinType must be a valid coin, and numCoins must be non-negative.
	 * @param coinType denomination of coin to set
	 * @param numCoins number of coins
	 * @return
	 */
	private int set(int coinType, int numCoins) {
		// Erase and fill me in!
		holder[coinIndex(coinType)] = numCoins;
        return holder[coinIndex(coinType)];
	}


	
	/**
	 * Return true if given coin can be held by this bank.  Else false.
	 * @param coin penny, nickel, dime, or quarter is bankable.  All others are not.
	 * @return true if bank can hold this coin, else false
	 */
	private boolean isBankable(int coin){
		switch (coin) {
		case PENNY_VALUE: case NICKEL_VALUE: 
		case DIME_VALUE: case QUARTER_VALUE:
			return true;
		default: 
			return false;
		}
	}
	
	/** 
	 * insert valid coin into bank.  Returns true if deposit
	 * successful (i.e. coin was penny, nickel, dime, or quarter).
	 * Returns false if coin not recognized
	 * 
	 * @param coinType either 1, 5, 10, or 25 to be valid
	 * @return true if deposit successful, else false
	 */
	public boolean insert(int coinType){
		if (!isBankable(coinType)) {
			return false;
		}
		else {
			set(coinType, get(coinType)+1);
			return true;
		}
	}
	
	/**
	 * returns the requested number of the requested coin type, if possible.
	 * Does nothing if the coin type is invalid.  If bank holds
	 * fewer coins than is requested, then all the coins of that
	 * type will be returned.
	 * @param coinType either 1, 5, 10, or 25 to be valid
	 * @param requestedCoins number of coins to be removed
	 * @return number of coins that are actually removed
	 */
	public int remove(int coinType, int requestedCoins) {
		if (requestedCoins > 0) {
			if (isValidCoinType(coinType)) {
				if (requestedCoins <= holder[coinIndex(coinType)]) {
					set(coinType, get(coinType) - requestedCoins);
					return requestedCoins;
				}
				else {
					int temp = get(coinType);
					set(coinType, 0);
					return temp;
				}
			}
			return 0;
		}

		return 0;
	}//if return nothing!




	/**
	 * returns number of coins remaining after removing the
	 * requested amount.  Returns zero if requested amount > what we have
	 * @param numWant number of coins to be removed
	 * @param numHave number of coins you have
	 * @return number of coins left after removal
	 */
	private int numLeft(int numWant, int numHave){
		return Math.max(0, numHave-numWant);
	}
	
	/**
	 * Returns bank as a printable string
	 */
	public String toString() {
		double total = (get(PENNY_VALUE) * PENNY_VALUE +
				get(NICKEL_VALUE) * NICKEL_VALUE + 
				get(DIME_VALUE) * DIME_VALUE +
				get(QUARTER_VALUE) * QUARTER_VALUE) / 100.0;
				
		String toReturn = "The bank currently holds $" + total + " consisting of \n";
		toReturn+=get(PENNY_VALUE) + " pennies\n";
		toReturn+=get(NICKEL_VALUE) + " nickels\n";
		toReturn+=get(DIME_VALUE) + " dimes\n";
		toReturn+=get(QUARTER_VALUE) + " quarters\n";
		return toReturn;
	}
}
