
/**
 * Non-preemptive priority scheduling algorithm. IZA
 */

import java.util.*;

public class Priority implements Algorithm {

    private List<Task> queue;
    private Task current;

    public Priority(List<Task> queue) {
        this.queue = queue;
    }

    public void schedule() {
        while (!queue.isEmpty()) {
            current = pickNextTask();

            CPU.run(current, current.getBurst());
        }

    }

    public Task pickNextTask() {
        Task temp;
        Task next = null;
        int max = 0;

        for (int i = 0; i < queue.size(); i++) {
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
 * just implement queue data structure, using priortiy as a check with if or
 * case or something else
 */