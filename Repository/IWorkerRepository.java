package WorkerManagement.Repository;

import java.util.ArrayList;

import WorkerManagement.model.History;
import WorkerManagement.model.Worker;

public interface IWorkerRepository {
    public void addWorker(ArrayList<Worker> workers);

    public void changeSalary(ArrayList<Worker> workers, ArrayList<History> histories, int status);
    public void printListHistory(ArrayList<History> histories);
}
