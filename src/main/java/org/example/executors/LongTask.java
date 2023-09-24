package org.example.executors;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.ThreadLocalRandom;

public class LongTask {
    public static void simulate() {
        simulate(ThreadLocalRandom.current().nextInt(2000, 5000));
    }

    public static void simulate(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
