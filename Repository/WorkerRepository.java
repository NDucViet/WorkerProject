package WorkerManagement.Repository;

import java.util.ArrayList;

import WorkerManagement.DataAccess.FuncTion;
import WorkerManagement.model.History;
import WorkerManagement.model.Worker;

public class WorkerRepository implements IWorkerRepository {

    FuncTion f = new FuncTion();

    @Override
    public void addWorker(ArrayList<Worker> workers) {
        f.addWorker(workers);
    }

    @Override
    public void changeSalary(ArrayList<Worker> workers, ArrayList<History> histories, int status) {
        f.changeSalary(workers, histories, status);
    }

    @Override
    public void printListHistory(ArrayList<History> histories) {
        f.printListHistory(histories);
    }

    

}
