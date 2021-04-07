package controller;

import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

@WebListener
public class HrWebListener {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:34343/ws/hr", new HrWebService());
    }
}
