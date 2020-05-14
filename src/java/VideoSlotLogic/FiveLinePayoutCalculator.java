/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VideoSlotLogic;

import Domain.SpinLinePayout;
import Transfer.WebServerTransferObject;
import java.util.List;

/**
 *
 * @author User
 */
public class FiveLinePayoutCalculator extends PayoutCalculator {

    public FiveLinePayoutCalculator(WebServerTransferObject transferObject) {
        super(transferObject);
    }

    @Override
    public List<SpinLinePayout> getSpinLinePayouts() {
        //lines 1,2,3
        for (int x = 0; x < 3; x++) {
            int arrayLength = 1;
            int symbolId = mat[x][0];
            for (int y = 1; y < 5; y++) {
                if (symbolId == mat[x][y]) {
                    arrayLength++;
                } else {
                    break;
                }
            }

            addSpinLinePayoutToList(arrayLength, symbolId, x + 1);
        }

        //line 4
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
        addSpinLinePayoutToList(arrayLength, symbolId, 4);

        //line 5
        arrayLength = 0;
        symbolId = mat[2][0];
        x = 2;
        for (int y = 0; y < 5; y++) {
            if (symbolId == mat[x][y]) {
                arrayLength++;
            } else {
                break;
            }
            if (y < 2) {
                x--;
            } else {
                x++;
            }
        }
        addSpinLinePayoutToList(arrayLength, symbolId, 5);

        return spinLinePayouts;
    }

}
