/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VideoSlotLogic;

import Domain.LinePayout;
import Domain.Position;
import Domain.SPosition;
import Domain.Spin;
import Domain.SpinLinePayout;
import Domain.Symbol;
import Domain.User;
import Domain.Win;
import SO.CreateSpinLinePayoutsSO;
import SO.CreateSpinSO;
import SO.CreateWinSO;
import SO.GetLinePayoutsSO;
import SO.GetPositionsSO;
import SO.GetSymbolsSO;
import SO.UpdateUserSO;
import Transfer.WebServerTransferObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author User
 */
public class VideoSlotLogic {

    WebServerTransferObject transferObject;
    int mat[][];
    User user;
    List<Symbol> symbols;
    List<Position> positions;
    List<SPosition> sPositions;
    List<LinePayout> linePayouts;
    Spin spin;
    PayoutCalculator payoutCalculator;
    Win win;

    public VideoSlotLogic(WebServerTransferObject transferObject) {
        this.transferObject = transferObject;
        this.user = transferObject.getUserObject();
        this.spin = transferObject.getSpinObject();
        mat = new int[3][5];
        getSymbols();
        getPositions();
        getLinePayouts();
        this.sPositions = new ArrayList<>();
        this.win = new Win();
    }

    public void executeSpin() {
        randomizeMatValues();
        if (!createSpin()) {
            return;
        }
        if (!reduceUserBalance()) {
            return;
        }
        if (!createSpinLinePayouts()) {
            return;
        }
        
        createWin();
        increaseUserBalance();
    }

    public void randomizeMatValues() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                mat[x][y] = new Random().nextInt(symbols.size());
            }
        }
        handleSPositions();
    }

    private void handleSPositions() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                SPosition sp = new SPosition();
                sp.setSymbol(symbols.get(mat[x][y]));
                sp.setPosition(getPosition(x, y));
                sp.setGameId(transferObject.getGameObject().getId());
                sPositions.add(sp);
            }
        }
        transferObject.sPositions = sPositions;
    }

    private Position getPosition(int x, int y) {
        return positions.stream().filter(p -> p.getX() == x && p.getY() == y).findFirst().get();
    }

    private boolean createSpin() {
        spin.setsPositions(sPositions);
        return new CreateSpinSO().createSpinSO(transferObject);
    }

    private boolean createSpinLinePayouts() {
        payoutCalculator = new FiveLinePayoutCalculator(transferObject);
        List<SpinLinePayout> spinLinePayouts = payoutCalculator.getSpinLinePayouts();
        transferObject.spinLinePayouts = spinLinePayouts;
        return new CreateSpinLinePayoutsSO().createSpinLinePayoutsSO(transferObject);
    }
    
    private boolean createWin() {
        int winAmount = payoutCalculator.calculateWin();
        this.win.setGameId(spin.getGameId());
        this.win.setSpinId(spin.getId());
        this.win.setAmount(winAmount);
        transferObject.setWinObject(win);
        return new CreateWinSO().createWinSO(transferObject);
    }

    private boolean reduceUserBalance() {
        int bet = transferObject.getSpinObject().getBet();
        int newBalance = user.getBalance() - bet;
        if (newBalance < 0) {
            return false;
        }
        user.setBalance(newBalance);
        new UpdateUserSO().updateUserSO(transferObject);

        return transferObject.signal;
    }

    private void increaseUserBalance() {
        if (win.getAmount() > 0) {
            user.setBalance(user.getBalance() + win.getAmount());
            new UpdateUserSO().updateUserSO(transferObject);
        }
    }

    private void getSymbols() {
        new GetSymbolsSO().getSymbolsSO(transferObject);
        symbols = transferObject.symbols;
    }

    private void getPositions() {
        new GetPositionsSO().getPositionsSO(transferObject);
        positions = transferObject.positions;
    }

    private void getLinePayouts() {
        new GetLinePayoutsSO().getLinePayoutsSO(transferObject);
        linePayouts = transferObject.linePayouts;
    }

}
