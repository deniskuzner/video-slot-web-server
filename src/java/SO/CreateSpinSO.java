/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Spin;
import Transfer.WebServerTransferObject;

/**
 *
 * @author User
 */
public class CreateSpinSO extends AbstractGenericSO {
    
    WebServerTransferObject transferObject;
    
    public boolean createSpinSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        Spin spin = transferObject.vratiSpin();
        if (!databaseBroker.insertCompositeRecord(spin)) {
                transferObject.signal = false;
                return false;
            }
        transferObject.signal = true;
        return true;
    }
    
}
