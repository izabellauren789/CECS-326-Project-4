
/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling..
 */

import java.util.*;

public class RR implements Algorithm {
    private List<Task> queue;
    // declare more here

    public RR(List<Task> queue) {
        this.queue = queue;
        // not finished
    }

    public void schedule() {
        // implement run CPU here with RR logic
    }

    public Task pickNexTask() {
        Task temp;
        Task next = null;
        int max = 0;
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            temp = queue.get(i);
            if (temp.getPriority() > max) {
                max = temp.getPriority();
                next = temp;
            }
        }
        queue.remove(next);
        return next;
    }
}
/*
 * just implement queue data structure, with a time constarint of max time
 * quantum as the value
 */