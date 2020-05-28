/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayoutCalculator;

import Domain.SpinLinePayout;
import Transfer.WebServerTransferObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ConcretePayoutCalculator extends PayoutCalculator {

    public ConcretePayoutCalculator(WebServerTransferObject transferObject) {
        super(transferObject);
    }

    @Override
    public List<SpinLinePayout> getSpinLinePayouts() {
        return new ArrayList<>();
    }

}
