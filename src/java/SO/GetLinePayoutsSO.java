/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.LinePayout;
import Transfer.WebServerTransferObject;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class GetLinePayoutsSO extends AbstractGenericSO {
    
    WebServerTransferObject transferObject;
    
    public boolean getLinePayoutsSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        List<LinePayout> result = databaseBroker.findRecord(new LinePayout(), "").stream().map(g -> (LinePayout) g).collect(Collectors.toList());
        transferObject.linePayouts = result;
        return true;
    }
    
}
