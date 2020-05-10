/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Game;
import Transfer.WebServerTransferObject;

/**
 *
 * @author User
 */
public class CreateGameSO extends AbstractGenericSO {
    
    WebServerTransferObject transferObject;
    
    public boolean createGameSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        Game game = transferObject.vratiGame();
        if(!databaseBroker.insertCompositeRecord(game)) {
            transferObject.signal = false;
            return false;
        }
        transferObject.signal = true;
        return true;
    }
    
}
