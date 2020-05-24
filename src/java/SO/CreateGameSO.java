/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Game;
import Transfer.WebServerTransferObject;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Game game = transferObject.getGameObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        game.setCreatedOn(java.sql.Date.valueOf(sdf.format(new Date())));
        if(!databaseBroker.insertCompositeRecord(game)) {
            transferObject.signal = false;
            return false;
        }
        transferObject.signal = true;
        return true;
    }
    
}
