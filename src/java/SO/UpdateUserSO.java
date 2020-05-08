/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.User;
import Transfer.WebServerTransferObject;

/**
 *
 * @author User
 */
public class UpdateUserSO extends AbstractGenericSO {

    WebServerTransferObject transferObject;

    public boolean updateUserSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        User user = (User) databaseBroker.findRecord(transferObject.user);
        if (user != null) {
            user.setBalance(transferObject.user.getBalance());
            if (databaseBroker.updateRecord(user)) {
                transferObject.message = "User update successful!";
                transferObject.signal = true;
                return true;
            }
            transferObject.message = "User update not successful!";
            transferObject.signal = false;
            return false;
        }
        transferObject.message = "User doesn't exist!";
        transferObject.signal = false;
        return false;
    }

}
