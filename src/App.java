import main.java.models.Task;
import main.java.enums.TaskStatus;

public class App {
    public static void main(String[] args) throws Exception {
        Task task = new Task(1, "Buy milk", TaskStatus.TODO);

        System.out.println(task.toString());
    }
}
