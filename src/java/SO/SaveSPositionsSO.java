/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.SPosition;
import Transfer.WebServerTransferObject;
import java.util.List;

/**
 *
 * @author User
 */
public class SaveSPositionsSO extends AbstractGenericSO {

    WebServerTransferObject transferObject;

    public boolean saveSPositionsSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        List<SPosition> sPositions = transferObject.sPositions;
        for (SPosition sPosition : sPositions) {
            if (!databaseBroker.insertRecord(sPosition)) {
                transferObject.signal = false;
                return false;
            }
        }
        transferObject.signal = true;
        return true;
    }

}
