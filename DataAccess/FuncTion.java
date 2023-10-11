package WorkerManagement.DataAccess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import WorkerManagement.common.Valid;
import WorkerManagement.model.History;
import WorkerManagement.model.Worker;

public class FuncTion {
    Valid v = new Valid();
     public void addWorker(ArrayList<Worker> workers) {
        System.out.print("Enter code: ");
        String id = v.checkInputString();
        System.out.print("Enter name: ");
        String name = v.checkInputString();
        System.out.print("Enter age: ");
        int age = v.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = v.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = v.checkInputString();
        if (!v.checkWorkerExist(workers, id, name, age, salary, workLocation)) {
            System.err.println("Duplicate.");
        } else {
            workers.add(new Worker(id, name, age, salary, workLocation));
            System.err.println("Add success.");
        }
    }

    
    public void changeSalary(ArrayList<Worker> workers, ArrayList<History> histories, int status) {
        if (workers.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = v.checkInputString();
        Worker worker = getWorkerByCode(workers, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            if (status == 1) {
                System.out.print("Enter salary: ");
                while (true) {     
                    salaryUpdate = v.checkInputSalary();
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                histories.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
                System.out.print("Enter salary: ");
                while (true) {
                    salaryUpdate = v.checkInputSalary();
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                histories.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }

    public void printListHistory(ArrayList<History> histories) {
        if (histories.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(histories);
        for (History history : histories) {
            printHistory(history);
        }
    }

    public Worker getWorkerByCode(ArrayList<Worker> workers, String id) {
        for (Worker worker : workers) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
