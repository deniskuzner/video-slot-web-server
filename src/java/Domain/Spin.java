/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Spin implements GeneralEntity {

    private int id;
    private int gameId;
    private int bet;
    private Win win;
    private List<SPosition> sPositions;
    private List<SpinLinePayout> spinLinePayouts;

    public Spin() {
    }

    public Spin(int id, int gameId, int bet, Win win, List<SPosition> sPositions, List<SpinLinePayout> spinLinePayouts) {
        this.id = id;
        this.gameId = gameId;
        this.bet = bet;
        this.win = win;
        this.sPositions = sPositions;
        this.spinLinePayouts = spinLinePayouts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public Win getWin() {
        return win;
    }

    public void setWin(Win win) {
        this.win = win;
    }
    
    public List<SPosition> getsPositions() {
        return sPositions;
    }

    public void setsPositions(List<SPosition> sPositions) {
        this.sPositions = sPositions;
    }

    public List<SpinLinePayout> getSpinLinePayouts() {
        return spinLinePayouts;
    }

    public void setSpinLinePayouts(List<SpinLinePayout> spinLinePayouts) {
        this.spinLinePayouts = spinLinePayouts;
    }
    
    @Override
    public String getAtrValue() {
        return id + ", " + gameId + ", " + bet;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", gameId=" + gameId + ", bet=" + bet;
    }

    @Override
    public String getClassName() {
        return "spin";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "gameId", "bet"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Spin(rs.getInt("id"), rs.getInt("gameId"), rs.getInt("bet"), null, null, null);
    }
    
    @Override
    public List<GeneralEntity> getEntities() {
        List<GeneralEntity> result = new ArrayList<>();
        result.add(win);
        return result;
    }

    @Override
    public List<List<GeneralEntity>> getLists() {
        List<List<GeneralEntity>> result = new ArrayList<>();
        result.add(new ArrayList<>(sPositions));
        result.add(new ArrayList<>(spinLinePayouts));
        return result;
    }

    @Override
    public void setPrimaryKey(int id) {
        this.id = id;
    }

}
