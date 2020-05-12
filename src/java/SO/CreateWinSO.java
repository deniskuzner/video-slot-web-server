/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Win;
import Transfer.WebServerTransferObject;

/**
 *
 * @author User
 */
public class CreateWinSO extends AbstractGenericSO {

    WebServerTransferObject transferObject;

    public boolean createWinSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        Win win = transferObject.getWinObject();
        if (!databaseBroker.insertRecord(win)) {
            transferObject.signal = false;
            return false;
        }
        transferObject.signal = true;
        return true;
    }

}
