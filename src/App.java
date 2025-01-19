import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.Files;

import main.java.models.Task;
import main.java.services.TaskService;

public class App {
    public static void main(String[] args) throws Exception {
        List<Task> tasks = new ArrayList<>();

        if (args.length > 0) {
            if (args[0].equals("add")) {
                if (args.length < 2 || args[1].isEmpty()) {
                    System.out.println("Please provide a description for the task.");

                    return;
                }

                tasks.add(TaskService.createTask(args[1], tasks));
            }

            String jsonPath = System.getProperty("user.dir") + "/src/resources/data/tasks.json";
            Path path = Path.of(jsonPath);
            boolean isExist = Files.exists(path);

            if (!isExist) {
                Files.createFile(path);

                System.out.println("File created: " + path);

                try {
                    Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
                    System.out.println("permissions = " + permissions);
                } catch (UnsupportedOperationException e) {
                    System.err.println("Looks like you're not running on a posix file system");
                }
            }

            System.out.println("Tasks : " + tasks.size());
        } else {
            System.out.println("Usage:");
            System.out.println("java App add <description>");
        }
    }
}
