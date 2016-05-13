package main.requests;

/**
 * Created by Antony on 13.05.2016.
 */
public class RequestCreator {
    public IRequest ConcreteRequestCreator(String type) {
        if (type.equals("SelectProjectsReq")) {
            return new SelectPojectsReq();
        } else if (type.equals("SelectTasksReq")) {
            return new SelectTasksReq();
        } else if (type.equals("SelectEmployeesReq")) {
            return new SelectEmployeesReq();
        } else if (type.equals("SelectTasksByPrjReq")) {
            return new SelectTasksByPrjReq();
        } else {
            return  null;
        }
    }
}
