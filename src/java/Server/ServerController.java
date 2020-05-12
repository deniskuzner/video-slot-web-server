/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import SO.CreateGameSO;
import SO.GetSymbolsSO;
import Transfer.WebServerTransferObject;
import VideoSlotLogic.VideoSlotLogic;
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

    public WebServerTransferObject randomizeMathValues(WebServerTransferObject transferObject) {
        new VideoSlotLogic(transferObject).randomizeMatValues();
        return transferObject;
    }

    public WebServerTransferObject createGame(WebServerTransferObject transferObject) {
        new CreateGameSO().createGameSO(transferObject);
        return transferObject;
    }
    
    public WebServerTransferObject executeSpin(WebServerTransferObject transferObject) {
        new VideoSlotLogic(transferObject).executeSpin();
        return transferObject;
    }
    
}
