package proj5;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IndexTest {

    @Test
    public void insert() {
        Index index = new Index();

        assertEquals("", index.toString());
        assertEquals(false, index.search(new Index.Node("A")));
        assertEquals(false, index.search(new Index.Node("B")));

        index.insert(new Index.Node("A"));

        assertEquals("(  A {0}  )", index.toString());
        assertEquals(true, index.search(new Index.Node("A")));
        assertEquals(false, index.search(new Index.Node("B")));

        index.insert(new Index.Node("B"));

        assertEquals(true, index.search(new Index.Node("B")));
        assertEquals(true, index.search(new Index.Node("A")));

        assertEquals("(  A {0}  (  B {0}  ))", index.toString());
    }


    @Test
    public void index() {
        Index index = new Index();

        assertEquals("", index.toString());

        Index.Node a = new Index.Node("A");
        index.insert(a);

        a.addPage(1);
        assertEquals("(  A {1}  )", index.toString());

        a.addPage(3);
        a.addPage(4);
        assertEquals("(  A {1, 3, 4}  )", index.toString());

        a.addPage(7);
        assertEquals("(  A {1, 3, 4, 7}  )", index.toString());

        a.addPage(8);//no more page will be added
        assertEquals("(  A {1, 3, 4, 7}  )", index.toString());
        
    }


    @Test
    public void indexDashed() {
        Index index = new Index();

        assertEquals("", index.toString());

        Index.Node a = new Index.Node("A");
        index.insert(a);

        a.addPage(1);
        assertEquals("(  A {1}  )", index.toString());

        a.addPage(2);
        a.addPage(3);
        assertEquals("(  A {1-3}  )", index.toString());// page 1, 2, 3 should appear as a 1-3

        a.addPage(7);
        assertEquals("(  A {1-3, 7}  )", index.toString());

    }
    
    


}
