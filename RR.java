
/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling..
 */

import java.util.*;

public class RR implements Algorithm {
    private List<Task> queue;
    int quantum = 0; // amount time subtracted form burst each task is run

    public RR(List<Task> queue) {
        this.queue = queue;
        // not finished
    }

    public void schedule() {
        // implement run CPU here with RR logic
    }

    public Task pickNextTask() {
        for( int i =0; i < 6; i++){
            queue.get(i).setBurst(queue.get(i).getBurst()-quantum);
        }
    }
}