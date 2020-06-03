/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

import Domain.Game;
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
    public Game game;

    public String message;
    public boolean signal;

    public User getUserObject() {
        return user;
    }

    public void setUserObject(User user) {
        this.user = user;
    }

    public List<Symbol> getSymbolsList() {
        return symbols;
    }

    public void setSymbolsList(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Position> getPositionsList() {
        return positions;
    }

    public void setPositionsList(List<Position> positions) {
        this.positions = positions;
    }

    public Spin getSpinObject() {
        return spin;
    }

    public void setSpinObject(Spin spin) {
        this.spin = spin;
    }

    public Game getGameObject() {
        return game;
    }

    public void setGameObject(Game game) {
        this.game = game;
    }

}
