import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SILab2Test extends TestCase{

    Time time = new Time(-5, 20, 15);
    Time time1 = new Time(25, 20, 15);
    Time time2 = new Time(10, 65, 15);
    Time time3 = new Time(10, 15, 65);
    Time time4 = new Time(20, 20, 20);
    Time time5 = new Time(24, 59, 59);
    Time time6 = new Time(24, 0, 0);

    private final SILab2 siLab2 = new SILab2();

    private List<Time> createList(Time... elements){
        return new ArrayList<>(Arrays.asList(elements));
    }

    private List<Integer> createlist(int... elements){
        return new ArrayList<Integer>();
    }

    @Test
    public void testEveryStatement(){
        RuntimeException ex = null;

        try{
            siLab2.function(createList(time));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        try{
            siLab2.function(createList(time1));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        try{
            siLab2.function(createList(time2));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        try{
            siLab2.function(createList(time3));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        try{
            siLab2.function(createList(time5));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        assertEquals(createlist(145220), siLab2.function(createList(time4)));
        assertEquals(createlist(86400), siLab2.function(createList(time6)));
    }

    @Test
    public void testEveryPath(){

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 8 -> 9 -> 26
        RuntimeException ex = null;

        try{
            siLab2.function(createList(time));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 8 -> 10 -> 11 -> 26
        try{
            siLab2.function(createList(time1));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 12 -> 13 -> 15 -> 16 -> 18,19 -> 26
        try{
            siLab2.function(createList(time2));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 12 -> 13 -> 15 -> 16 -> 18,19 -> 26
        try{
            siLab2.function(createList(time3));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 12 -> 13 -> 15 -> 16 -> 17 -> 24 -> 3.3 -> 3.2 -> 25 -> 26
        assertEquals(createlist(145220), siLab2.function(createList(time4)));

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 12 -> 20 -> 21 -> 22,23 -> 26
        try{
            siLab2.function(createList(time5));
        }
        catch(RuntimeException e){
            ex = e;
        }

        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        // 1,2 -> 3.1 -> 3.2 -> 4,5,6 -> 7 -> 12 -> 20 -> 21 -> 24 -> 3.3 -> 3.2 -> 25 -> 26
        assertEquals(createlist(86400), siLab2.function(createList(time6)));
    }
}