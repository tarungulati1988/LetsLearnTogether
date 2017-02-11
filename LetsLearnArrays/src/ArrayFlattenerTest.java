import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by tgulati on 1/18/17.
 */
public class ArrayFlattenerTest {

    int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    ArrayFlattener arrayFlattener = new ArrayFlattener();


    @Test
    public void testNestedArray() throws IllegalArgumentException {
        assertEquals(expectedArray, arrayFlattener.flattenedIntegerArray(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, new Object[]{10}}));
    }

    @Test
    public void testNullInput() throws IllegalArgumentException {
        assertNull(arrayFlattener.flattenedIntegerArray(null));
    }

    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        assertNull(arrayFlattener.flattenedIntegerArray(null));
    }

    @Test
    public void testSingleArray() throws IllegalArgumentException {
        assertEquals(expectedArray, arrayFlattener.flattenedIntegerArray(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void testMultipleNestedArrays() throws IllegalArgumentException {
        assertEquals(expectedArray, arrayFlattener.flattenedIntegerArray(new Object[]{1, new Object[]{2, 3, new Object[]{4, 5, new Object[]{6}}, 7}, 8, 9, 10}));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForNullInput() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{null});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForNullInNestedInputArray() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{1, new Object[]{2, null}});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForObjectInNestedInputArray() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{1, new Object[]{new Object()}});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForObjectInInputArray() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{new Object()});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForLongInInputArray() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{1L});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForLongInNestedInputArray() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{1, new Object[]{2L}});
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowsExceptionForStringInNestedInputArray() throws IllegalArgumentException {
        arrayFlattener.flattenedIntegerArray(new Object[]{1, new Object[]{"abcdef"}});
    }

}
