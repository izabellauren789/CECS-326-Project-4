
/**
 * FCFS scheduling algorithm..
 */

import java.util.*;

public class FCFS implements Algorithm {
    private List<Task> queue;
    private Task current;

    public FCFS(List<Task> queue) {
        this.queue = queue;
        this.current = null;
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            current = pickNextTask();

            CPU.run(current, current.getBurst());
        }
    }

    public Task pickNextTask() {
        Task temp = current;
        queue.add(current);
        return temp;
    }
}
