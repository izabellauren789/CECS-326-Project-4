
/**
 * FCFS scheduling algorithm..
 */

import java.util.*;

public class FCFS implements Algorithm {
    private List<Task> queue;
    private Task scheduler;

    public FCFS(List<Task> queue) {
        this.queue = queue;
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            scheduler = pickNextTask();

            CPU.run(scheduler, scheduler.getBurst());
        }
    }

    public Task pickNextTask() {
        return queue.remove(0);
    }
}
