/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class SPosition implements GeneralEntity {

    private int id;
    private int gameId;
    private int spinId;
    private Position position;
    private Symbol symbol;

    public SPosition() {
    }

    public SPosition(int id, int gameId, int spinId, Position position, Symbol symbol) {
        this.id = id;
        this.gameId = gameId;
        this.spinId = spinId;
        this.position = position;
        this.symbol = symbol;
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

    public int getSpinId() {
        return spinId;
    }

    public void setSpinId(int spinId) {
        this.spinId = spinId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + gameId + ", " + spinId + ", " + position.getId() + ", " + symbol.getId();
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", gameId=" + gameId + ", spinId=" + spinId + ", positionId=" + position.getId() + ", symbolId=" + symbol.getId();
    }

    @Override
    public String getClassName() {
        return "sposition";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "gameId", "spinId", "positionId", "symbolId"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new SPosition(rs.getInt("id"), rs.getInt("gameId"), rs.getInt("spinId"), new Position(rs.getInt("positionId"), 0, 0), new Symbol(rs.getInt("symbolId"), ""));
    }

    @Override
    public List<List<GeneralEntity>> getLists() {
        return null;
    }

    @Override
    public void setPrimaryKey(int id) {
        this.spinId = id;
    }

}
