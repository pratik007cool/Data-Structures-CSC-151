package proj4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convertTest1() {

        Converter c1 = new Converter("/Users/pratikraj/Documents/CSC 151 Data Structure/Data-Structures-CSC-151/Project 4, Stack.Interfaces.Generic.&.Casting/src/proj4/proj4_input.txt");

        String expected = "7+1 --> 71+";
        assertEquals(expected, c1.convert().toString());
    }

    @Test
    public void convertTest2() {

        Converter c2 = new Converter("/Users/pratikraj/Documents/CSC 151 Data Structure/Data-Structures-CSC-151/Project 4, Stack.Interfaces.Generic.&.Casting/src/proj4/proj4_input.txt");

        String expected = "7+1+8 --> 71+8+";
        assertEquals(expected, c2.convert().toString());
    }

    @Test
    public void convertTest3() {

        Converter c3 = new Converter("/Users/pratikraj/Documents/CSC 151 Data Structure/Data-Structures-CSC-151/Project 4, Stack.Interfaces.Generic.&.Casting/src/proj4/proj4_input.txt");

        String expected = "(A+B*(C-D))/E; --> ABCD-*+E/";
        assertEquals(expected, c3.convert().toString());
    }


    @Test
    public void convertTest4() {

        Converter c4 = new Converter("/Users/pratikraj/Documents/CSC 151 Data Structure/Data-Structures-CSC-151/Project 4, Stack.Interfaces.Generic.&.Casting/src/proj4/proj4_input.txt");

        String expected = "(6-2)*8 --> 62-8*";
        assertEquals(expected, c4.convert().toString());
    }

    @Test
    public void convertTest5() {

        Converter c5 = new Converter("/Users/pratikraj/Documents/CSC 151 Data Structure/Data-Structures-CSC-151/Project 4, Stack.Interfaces.Generic.&.Casting/src/proj4/proj4_input.txt");

        String expected = "24/2^3-1 --> 2423^/1-";
        assertEquals(expected, c5.convert().toString());
    }
}
