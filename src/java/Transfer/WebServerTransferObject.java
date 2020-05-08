/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

import Domain.LinePayout;
import Domain.Position;
import Domain.SPosition;
import Domain.Spin;
import Domain.SpinLinePayout;
import Domain.Symbol;
import Domain.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author User
 */
public class WebServerTransferObject implements Serializable {

    public User user;
    public List<Symbol> symbols;
    public List<Position> positions;
    public List<LinePayout> linePayouts;
    public List<SPosition> sPositions;
    public List<SpinLinePayout> spinLinePayouts;
    
    public Spin spin;
    public int gameId;

    public String message;
    public boolean signal;

    public User vratiUser() {
        return user;
    }

    public void postaviUser(User user) {
        this.user = user;
    }
    
    public void postaviSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> vratiSymbols() {
        return symbols;
    }

    public List<Position> vratiPositions() {
        return positions;
    }

    public void postaviPositions(List<Position> positions) {
        this.positions = positions;
    }
    
    public int vratiGameId() {
        return gameId;
    }

    public void postaviGameId(int gameId) {
        this.gameId = gameId;
    }

    public Spin vratiSpin() {
        return spin;
    }

    public void posatviSpin(Spin spin) {
        this.spin = spin;
    }

}
