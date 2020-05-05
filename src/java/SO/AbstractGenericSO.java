/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import DatabaseBroker.DatabaseBroker;
import DatabaseBroker.DatabaseBroker1;

/**
 *
 * @author User
 */
public abstract class AbstractGenericSO {

    public DatabaseBroker databaseBroker = new DatabaseBroker1();

    public boolean templateExecuteSO() {
        databaseBroker.makeConnection();
        boolean signal = executeSO();
        if (signal == true) {
            databaseBroker.commitTransation();
        } else {
            databaseBroker.rollbackTransation();
        }
        databaseBroker.closeConnection();
        return signal;
    }

    abstract public boolean executeSO();

}
