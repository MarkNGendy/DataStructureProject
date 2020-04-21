package eg.edu.alexu.csd.datastructure.mailserver.useddatastructures.queues;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTest {
    PriorityQueue pq = new PriorityQueue();

    @org.junit.Test
    public void insert() {
        pq.insert('a', 5);
        pq.insert('c', 9);
        assertEquals(2, pq.size());
        pq.insert(7, 2);
        assertEquals(3, pq.size());
    }

    @Test
    public void invalidKey() {

        pq.insert("test", 0);
        pq.insert("test2", -5);
    }


    @org.junit.Test
    public void removeMin() {
        pq.insert("test", 5);
        pq.insert('m', 10);
        assertEquals("test", pq.removeMin());
        assertEquals('m', pq.removeMin());
    }

    @org.junit.Test
    public void min() {
        pq.insert(7, 3);
        pq.insert(9, 5);
        assertEquals(7, pq.min());
        assertEquals(7, pq.min());
        pq.insert('a', 1);
        assertEquals('a', pq.min());
    }

    @Test
    public void removeFromEmptyQueue() {
        pq.min();
        pq.removeMin();
    }


    @org.junit.Test
    public void isEmpty() {
        assertEquals(true, pq.isEmpty());
        pq.insert('m', 5);
        assertEquals(false, pq.isEmpty());
        pq.removeMin();
        assertEquals(true, pq.isEmpty());
    }

    @org.junit.Test
    public void size() {
        assertEquals(0, pq.size());
        pq.insert('x', 2);
        pq.insert('s', 1);
        assertEquals(2, pq.size());
        pq.removeMin();
        assertEquals(1, pq.size());
    }
}