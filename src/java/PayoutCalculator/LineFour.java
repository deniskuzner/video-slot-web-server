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
public class LineFour extends Line {

    PayoutCalculator payoutCalculator;

    public LineFour(PayoutCalculator payoutCalculator) {
        super(payoutCalculator);
        this.payoutCalculator = payoutCalculator;
    }

    @Override
    public List<SpinLinePayout> getSpinLinePayouts() {
        List<SpinLinePayout> spinLinePayouts = payoutCalculator.getSpinLinePayouts();

        int arrayLength = 0;
        int symbolId = mat[0][0];
        int x = 0;
        for (int y = 0; y < 5; y++) {
            if (symbolId == mat[x][y]) {
                arrayLength++;
            } else {
                break;
            }
            if (y < 2) {
                x++;
            } else {
                x--;
            }
        }
        addSpinLinePayoutToList(spinLinePayouts, arrayLength, symbolId, 4);
        return spinLinePayouts;
    }
    
}
