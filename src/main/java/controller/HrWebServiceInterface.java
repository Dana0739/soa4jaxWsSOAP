package controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "HrWebService")
public interface HrWebServiceInterface {
//    @WebMethod
//    @WebResult(partName = "return")
//    @Action(input = "http://server.ws.soap.baeldung.com/CountryService/findByNameRequest",
//            output = "http://server.ws.soap.baeldung.com/CountryService/findByNameResponse")
//    Employee getEmployee(@WebParam(name = "arg0", partName = "arg0") String arg0);

    @WebMethod
    public String getMsg(@WebParam(name="name", partName="name") String name);

    @WebMethod
    public String hrHire(@WebParam(name="person-id", partName="person-id") long personId,
                           @WebParam(name="org-id", partName="org-id") long orgId,
                           @WebParam(name="position", partName="position") String position,
                           @WebParam(name="status", partName="status") String status,
                           @WebParam(name="start-date", partName="start-date") String date);

    @WebMethod
    public String hrFire(@WebParam(name="id", partName="id") long id);
}
