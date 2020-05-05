/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.Symbol;
import Transfer.WebServerTransferObject;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class GetSymbolsSO extends AbstractGenericSO {
    
    WebServerTransferObject transferObject;
    
    public boolean getSymbolsSO(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        List<Symbol> result = databaseBroker.findRecord(new Symbol(), "").stream().map(g -> (Symbol) g).collect(Collectors.toList());
        transferObject.symbols = result;
        return true;
    }
    
}
