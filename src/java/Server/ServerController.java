/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import SO.CreateGameSO;
import SO.CreateSpinSO;
import SO.GetLinePayoutsSO;
import SO.GetPositionsSO;
import SO.GetSymbolsSO;
import SO.SaveSPositionsSO;
import SO.UpdateUserSO;
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

    public WebServerTransferObject getPositions(WebServerTransferObject transferObject) {
        new GetPositionsSO().getPositionsSO(transferObject);
        return transferObject;
    }

    public WebServerTransferObject getLinePayouts(WebServerTransferObject transferObject) {
        new GetLinePayoutsSO().getLinePayoutsSO(transferObject);
        return transferObject;
    }

    public WebServerTransferObject randomizeMathValues(WebServerTransferObject transferObject) {
        new VideoSlotLogic(transferObject).randomizeMatValues();
        return transferObject;
    }

    public WebServerTransferObject updateUser(WebServerTransferObject transferObject) {
        new UpdateUserSO().updateUserSO(transferObject);
        return transferObject;
    }

    public WebServerTransferObject createSpin(WebServerTransferObject transferObject) {
        new CreateSpinSO().createSpinSO(transferObject);
        return transferObject;
    }
    
    public WebServerTransferObject createGame(WebServerTransferObject transferObject) {
        new CreateGameSO().createGameSO(transferObject);
        return transferObject;
    }
    
    public WebServerTransferObject createSpinLinePayouts(WebServerTransferObject transferObject) {
        new VideoSlotLogic(transferObject).createSpinLinePayouts();
        return transferObject;
    }
    
}
