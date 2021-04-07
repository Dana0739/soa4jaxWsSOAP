package controller;

import model.HRHireFireWorkerDTO;
import model.Position;
import model.Status;

import javax.jws.WebService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebService(endpointInterface = "controller.HrWebServiceInterface", serviceName = "HrWebService")
public class HrWebService implements HrWebServiceInterface {
    @Override
    public String getMsg(String name) {
        return "Welcome   : " + name;
//        return Response.status(200).entity(output).build();
    }

    @Override
    public String hrHire(long personId, long orgId, String position, String status, String date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(date);
            return HrClient.callXmlHrHireFireWorkerDTO(personId,
                    new HRHireFireWorkerDTO(orgId, Position.getByTitle(position),
                            Status.getByTitle(status), startDate));
//        } catch (IllegalArgumentException e) {
//            return Response.status(422).entity(e.getMessage()).build();
//        } catch (ParseException e) {
//            return Response.status(422).entity("Could not parse date format: yyyy-MM-dd").build();
//        } catch (Exception e) {
//            for (int i = 0; i < e.getStackTrace().length; i++) {
//                System.out.println(e.getStackTrace()[i].toString());
//            }
//            return Response.status(500).entity(e.getMessage()).build();
        } catch (Exception e) {
            StringBuilder err = new StringBuilder("Error: \n <br> ");
            err.append(e.getMessage()).append(" \n <br> ");
            for (int i = 0; i < e.getStackTrace().length; i++) {
                err.append(e.getStackTrace()[i].toString());
            }
            return err.toString();
        }
    }

    @Override
    public String hrFire(long id) {
        return HrClient.callXmlHrHireFireWorkerDTO(id, new HRHireFireWorkerDTO());
    }
}
