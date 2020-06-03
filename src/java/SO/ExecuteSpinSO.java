/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Spin;
import Domain.SpinLinePayout;
import Domain.User;
import Domain.Win;
import Transfer.WebServerTransferObject;
import java.util.List;

/**
 *
 * @author User
 */
public class ExecuteSpinSO extends AbstractGenericSO {

    WebServerTransferObject transferObject;

    public boolean executeSpinSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        User user = (User) databaseBroker.findRecord(transferObject.user);
        if (user == null) {
            transferObject.signal = false;
            return false;
        } else {
            user.setBalance(transferObject.user.getBalance());
            if (!databaseBroker.updateRecord(user)) {
                transferObject.signal = false;
                return false;
            }
        }
        
        Spin spin = transferObject.getSpinObject();
        if (!databaseBroker.insertCompositeRecord(spin)) {
            transferObject.signal = false;
            return false;
        }

        user.setBalance(user.getBalance() + spin.getWin().getAmount());
        if (!databaseBroker.updateRecord(user)) {
            transferObject.signal = false;
            return false;
        }
        transferObject.getUserObject().setBalance(user.getBalance());
        transferObject.signal = true;
        return true;
    }

}
