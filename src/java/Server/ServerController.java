/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import SO.GetPositionsSO;
import SO.GetSymbolsSO;
import SO.SaveSPositionsSO;
import Transfer.WebServerTransferObject;
import javax.jws.WebService;

/**
 *
 * @author User
 */
@WebService(serviceName = "ServerController")
public class ServerController {

    public WebServerTransferObject getSymbols(WebServerTransferObject transferObject) {
        new GetSymbolsSO().getSymbolsSO(transferObject);
        return transferObject;
    }
    
    public WebServerTransferObject getPositions(WebServerTransferObject transferObject) {
        new GetPositionsSO().getPositionsSO(transferObject);
        return transferObject;
    }
    
    public WebServerTransferObject saveSPositions(WebServerTransferObject transferObject) {
        new SaveSPositionsSO().saveSPositionsSO(transferObject);
        return transferObject;
    }
    
}
