package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.queues;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {
LinkedListQueue lq = new LinkedListQueue();
    @Test
    public void enqueue() {
        lq.enqueue(5);
        lq.enqueue(2);
        assertEquals(2,lq.size());
        lq.enqueue("test");
        assertEquals(3,lq.size());
    }

    @Test
    public void dequeue() {
        lq.enqueue(14);
        assertEquals(14,lq.dequeue());
        assertEquals(0,lq.size());
        lq.enqueue("test");
        lq.enqueue('m');
        lq.enqueue(15);
        assertEquals("test",lq.dequeue());
        assertEquals('m',lq.dequeue());
        assertEquals(1,lq.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(true,lq.isEmpty());
        lq.enqueue(4);
        assertEquals(false,lq.isEmpty());
        lq.dequeue();
        assertEquals(true,lq.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0,lq.size());
        lq.enqueue(6);
        lq.enqueue(8);
        assertEquals(2,lq.size());
        lq.dequeue();
        assertEquals(1,lq.size());
    }
    @Test(expected = RuntimeException.class)
    public void Exception() {
        lq.dequeue();
    }
}}