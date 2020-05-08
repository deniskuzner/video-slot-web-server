/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server_client.ServerController;
import Server_client.WebServerTransferObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("servercontrollerport")
public class ServerControllerPort {

    private ServerController port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServerControllerPort
     */
    public ServerControllerPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method getSymbols
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("getsymbols/")
    public JAXBElement<WebServerTransferObject> postGetSymbols(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.getSymbols(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getLinePayouts
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("getlinepayouts/")
    public JAXBElement<WebServerTransferObject> postGetLinePayouts(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.getLinePayouts(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method saveSPositions
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("savespositions/")
    public JAXBElement<WebServerTransferObject> postSaveSPositions(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.saveSPositions(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method createSpin
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("createspin/")
    public JAXBElement<WebServerTransferObject> postCreateSpin(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.createSpin(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method randomizeMathValues
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("randomizemathvalues/")
    public JAXBElement<WebServerTransferObject> postRandomizeMathValues(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.randomizeMathValues(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getPositions
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("getpositions/")
    public JAXBElement<WebServerTransferObject> postGetPositions(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.getPositions(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method updateUser
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.WebServerTransferObject>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("updateuser/")
    public JAXBElement<WebServerTransferObject> postUpdateUser(JAXBElement<WebServerTransferObject> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.WebServerTransferObject result = port.updateUser(arg0.getValue());
                return new JAXBElement<Server_client.WebServerTransferObject>(new QName("http//Server_client/", "webservertransferobject"), Server_client.WebServerTransferObject.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private ServerController getPort() {
        try {
            // Call Web Service Operation
            Server_client.ServerController_Service service = new Server_client.ServerController_Service();
            Server_client.ServerController p = service.getServerControllerPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
