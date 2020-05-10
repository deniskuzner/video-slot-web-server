/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.SpinLinePayout;
import Transfer.WebServerTransferObject;
import java.util.List;

/**
 *
 * @author User
 */
public class CreateSpinLinePayoutsSO extends AbstractGenericSO {
    
    WebServerTransferObject transferObject;
    
    public boolean createSpinLinePayoutsSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        List<SpinLinePayout> spinLinePayouts = transferObject.spinLinePayouts;
        for (SpinLinePayout spinLinePayout : spinLinePayouts) {
            if (!databaseBroker.insertRecord(spinLinePayout)) {
                transferObject.signal = false;
                return false;
            }
        }
        transferObject.signal = true;
        return true;
    }
    
}
