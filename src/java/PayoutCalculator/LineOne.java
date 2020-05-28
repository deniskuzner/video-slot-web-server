/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayoutCalculator;

import Domain.SpinLinePayout;
import java.util.List;

/**
 *
 * @author User
 */
public class LineOne extends Line {

    PayoutCalculator payoutCalculator;

    public LineOne(PayoutCalculator payoutCalculator) {
        super(payoutCalculator);
        this.payoutCalculator = payoutCalculator;
    }

    @Override
    public List<SpinLinePayout> getSpinLinePayouts() {
        List<SpinLinePayout> spinLinePayouts = payoutCalculator.getSpinLinePayouts();

        int arrayLength = 1;
        int symbolId = mat[0][0];
        for (int y = 1; y < 5; y++) {
            if (symbolId == mat[0][y]) {
                arrayLength++;
            } else {
                break;
            }
        }
        addSpinLinePayoutToList(spinLinePayouts, arrayLength, symbolId, 1);
        return spinLinePayouts;
    }

}
