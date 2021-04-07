package controller;

import model.HRHireFireWorkerDTO;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HrClient {
    private static Client client;
    private static final String SOA_CRUD_SERV_URL = "https://localhost:34341/lab3springapplication/workers/";

    public static void init() throws KeyManagementException, NoSuchAlgorithmException {
        TrustManager[] noopTrustManager = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };
        SSLContext sc = SSLContext.getInstance("ssl");
        sc.init(null, noopTrustManager, null);
        client = ClientBuilder.newBuilder().sslContext(sc).build();
    }

    public static String callXmlHrHireFireWorkerDTO(long id, HRHireFireWorkerDTO hrHireFireWorkerDTO) {
        try {
            init();
            HttpsURLConnection.setDefaultHostnameVerifier ((hostname, session) -> true);
            String rest_uri = System.getenv("SOA_CRUD_SERV_URL");
            if (rest_uri == null || rest_uri.isEmpty()) rest_uri = SOA_CRUD_SERV_URL;
            return
                    String.valueOf(
                        client.target(rest_uri + id).request(MediaType.APPLICATION_XML)
                        .post(Entity.xml(hrHireFireWorkerDTO.toString())
                    ).getStatus());
        } catch (Exception e) {
//            return Response.status(500).entity(
            return
                "500 " + e.getCause() + " " + e.getMessage() + "\n <br>"
                    + Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString)
                    .collect(Collectors.joining(" "));
//            ).build();
        }
    }
}
