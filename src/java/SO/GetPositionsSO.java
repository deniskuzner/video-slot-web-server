/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Position;
import Transfer.WebServerTransferObject;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class GetPositionsSO extends AbstractGenericSO {
    
    WebServerTransferObject transferObject;
    
    public boolean getPositionsSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        List<Position> result = databaseBroker.findRecord(new Position(), "").stream().map(g -> (Position) g).collect(Collectors.toList());
        transferObject.positions = result;
        return true;
    }
    
}
