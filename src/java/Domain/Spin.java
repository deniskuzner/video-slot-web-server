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
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class Spin implements GeneralEntity {

    private int id;
    private int gameId;
    private int bet;
    private int win;
    private List<SPosition> sPositions;

    public Spin() {
    }

    public Spin(int id, int gameId, int bet, int win, List<SPosition> sPositions) {
        this.id = id;
        this.gameId = gameId;
        this.bet = bet;
        this.win = win;
        this.sPositions = sPositions;
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

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public List<SPosition> getsPositions() {
        return sPositions;
    }

    public void setsPositions(List<SPosition> sPositions) {
        this.sPositions = sPositions;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + gameId + ", " + bet + ", " + win;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", gameId=" + gameId + ", bet=" + bet + ", win=" + win;
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
        String names[] = {"id", "gameId", "bet", "win"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Spin(rs.getInt("id"), rs.getInt("gameId"), rs.getInt("bet"), rs.getInt("win"), null);
    }

    @Override
    public List<List<GeneralEntity>> getLists() {
        List<List<GeneralEntity>> result = new ArrayList<>();
        result.add(sPositions.stream().map(sp -> (GeneralEntity) sp).collect(Collectors.toList()));
        return result;
    }

    @Override
    public void setPrimaryKey(int id) {
        this.id = id;
    }

}
