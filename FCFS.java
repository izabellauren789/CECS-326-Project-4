
/**
 * FCFS scheduling algorithm..
 */

import java.util.*;

public class FCFS implements Algorithm {
    private List<Task> queue;
    private Task current;

    public FCFS(List<Task> queue) {
        this.queue = queue;
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            current = pickNextTask();

            if (current != null) {
                CPU.run(current, current.getBurst());
            }
        }
    }

    public Task pickNextTask() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }
    }
}
