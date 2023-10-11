package WorkerManagement;

import WorkerManagement.controller.WorkerController;

public class Main {
    public static void main(String[] args) {
        WorkerController workerController = new WorkerController();
        workerController.run();
    }
}
