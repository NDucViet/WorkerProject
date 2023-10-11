package WorkerManagement.controller;

import java.util.ArrayList;

import WorkerManagement.Repository.WorkerRepository;
import WorkerManagement.model.History;
import WorkerManagement.model.Worker;
import WorkerManagement.view.Menu;

public class WorkerController extends Menu {

    WorkerRepository workerRepository = new WorkerRepository();
    ArrayList<Worker> workers = new ArrayList<>();
    ArrayList<History> histories = new ArrayList<>();
    static String[] option = { "Add a Worker.",
            "Increase salary for worker.",
            "Decrease for worker.",
            "Show adjusted salary worker information.",
            "Exit" };

    public WorkerController() {
        super("Worker Programming", option);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                workerRepository.addWorker(workers);
                break;
            case 2:
                workerRepository.changeSalary(workers, histories, 1);
                break;
            case 3:
                workerRepository.changeSalary(workers, histories, 2);
                break;
            case 4:
                workerRepository.printListHistory(histories);
                break;
            case 5:
                return;
        }
    }

}
