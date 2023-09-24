package org.example.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show()

    {
        Queue<String> queue = new ArrayDeque<String>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        //queue.offer("d");
        var front = queue.remove(); //poll null, remove exception if empty
        System.out.println(queue);
        front = queue.peek(); //null if empty element will throw exception


    }
    }
