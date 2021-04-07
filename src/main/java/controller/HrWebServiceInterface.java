package controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "HrWebService")
public interface HrWebServiceInterface {

    @WebMethod
    public String getMsg(@WebParam(name="name", partName="name") String name);

    @WebMethod
    public String hrHire(@WebParam(name="personId", partName="personId") long personId,
                           @WebParam(name="orgId", partName="orgId") long orgId,
                           @WebParam(name="position", partName="position") String position,
                           @WebParam(name="status", partName="status") String status,
                           @WebParam(name="startDate", partName="startDate") String date);

    @WebMethod
    public String hrFire(@WebParam(name="id", partName="id") long id);
}
