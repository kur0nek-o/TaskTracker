import java.util.ArrayList;
import java.util.List;

import main.java.models.Task;
import main.java.services.TaskService;

public class App {
    public static void main(String[] args) throws Exception {
        List<Task> tasks = new ArrayList<>();

        if (args.length > 0) {
            if (args[0].equals("add")) {
                tasks.add(TaskService.createTask(args[1], tasks));
            }

            System.out.println("Tasks:");

            for (Task task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("Usage:");
            System.out.println("java App add <description>");
        }
    }
}
