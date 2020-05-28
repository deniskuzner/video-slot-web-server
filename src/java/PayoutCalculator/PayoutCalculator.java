/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayoutCalculator;

import Domain.LinePayout;
import Domain.SPosition;
import Domain.Spin;
import Domain.SpinLinePayout;
import Domain.Symbol;
import Transfer.WebServerTransferObject;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public abstract class PayoutCalculator {

    WebServerTransferObject transferObject;
    List<Symbol> symbols;
    List<SPosition> sPositions;
    List<LinePayout> linePayouts;
    Spin spin;
    int bet;
    int[][] mat;

    public PayoutCalculator(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        this.symbols = transferObject.symbols;
        this.sPositions = transferObject.sPositions;
        this.linePayouts = transferObject.linePayouts;
        this.spin = transferObject.spin;
        this.bet = spin.getBet();
        this.mat = new int[3][5];
        convertSPositionsToMat();
    }

    private void convertSPositionsToMat() {
        for (SPosition sPosition : sPositions) {
            mat[sPosition.getPosition().getX()][sPosition.getPosition().getY()] = sPosition.getSymbol().getId();
        }
    }

    public void addSpinLinePayoutToList(List<SpinLinePayout> spinLinePayouts, int arrayLength, int symbolId, int lineNumber) {
        Optional<LinePayout> result = linePayouts.stream().filter(l -> l.getArrayLength() == arrayLength && l.getSymbolId() == symbolId).findFirst();
        LinePayout lp = result.isPresent() ? result.get() : null;

        if (lp != null) {
            spinLinePayouts.add(new SpinLinePayout(spin.getGameId(), spin.getId(), lp.getId(), lineNumber));
        }
    }
    
    public int calculateWin(List<SpinLinePayout> spinLinePayouts) {
        int win = 0;
        for (SpinLinePayout spinLinePayout : spinLinePayouts) {
            int amount = linePayouts.stream().filter(lp -> lp.getId() == spinLinePayout.getLinePayoutId()).findFirst().get().getAmount();
            win += amount * bet;
        }
        return win;
    }

    public abstract List<SpinLinePayout> getSpinLinePayouts();

}
