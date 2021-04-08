package controller;

import model.HRHireFireWorkerDTO;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HrClient {
    private static final Client client = ClientBuilder.newBuilder().build();
    private static final String SOA_CRUD_SERV_URL = "http://localhost:34345/workers/";

    public static String callXmlHrHireFireWorkerDTO(long id, HRHireFireWorkerDTO hrHireFireWorkerDTO) {
        try {
            String rest_uri = System.getenv("SOA_CRUD_SERV_URL");
            if (rest_uri == null || rest_uri.isEmpty()) rest_uri = SOA_CRUD_SERV_URL;
            return
                    String.valueOf(
                        client.target(rest_uri + id).request(MediaType.APPLICATION_XML)
                        .post(Entity.xml(hrHireFireWorkerDTO.toString())
                    ).getStatus());
        } catch (Exception e) {
            return "500 " + e.getCause() + " " + e.getMessage() + "\n <br>"
                    + Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString)
                    .collect(Collectors.joining(" </br> \n "));
        }
    }
}
