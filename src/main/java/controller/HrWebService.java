package controller;

import model.HRHireFireWorkerDTO;
import model.Position;
import model.Status;

import javax.jws.WebService;

@WebService(endpointInterface = "controller.HrWebServiceInterface", serviceName = "HrWebService")
public class HrWebService implements HrWebServiceInterface {
    @Override
    public String getMsg(String name) {
        return "Welcome   : " + name;
    }

    @Override
    public String hrHire(long personId, long orgId, String position, String status, String startDate) {
        try {
            return HrClient.callXmlHrHireFireWorkerDTO(personId,
                    new HRHireFireWorkerDTO(orgId, Position.getByTitle(position),
                            Status.getByTitle(status), startDate));
        } catch (Exception e) {
            StringBuilder err = new StringBuilder("Error: \n <br> ");
            err.append(e.getMessage()).append(" \n <br> ").append(e.getCause()).append(" \n <br> ");
            for (int i = 0; i < e.getStackTrace().length; i++) {
                err.append(e.getStackTrace()[i].toString()).append(" \n <br> ");
            }
            return err.toString();
        }
    }

    @Override
    public String hrFire(long id) {
        return HrClient.callXmlHrHireFireWorkerDTO(id, new HRHireFireWorkerDTO());
    }
}
