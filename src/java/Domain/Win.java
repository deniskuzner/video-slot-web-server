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
public class Win implements GeneralEntity {

    private int id;
    private int gameId;
    private int spinId;
    private int amount;

    public Win() {
    }

    public Win(int id, int gameId, int spinId, int amount) {
        this.id = id;
        this.gameId = gameId;
        this.spinId = spinId;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + gameId + ", " + spinId + ", " + amount;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", gameId=" + gameId + ", spinId=" + spinId + ", amount=" + amount;
    }

    @Override
    public String getClassName() {
        return "win";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "gameId", "spinId", "amount"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Win(rs.getInt("id"), rs.getInt("gameId"), rs.getInt("spinId"), rs.getInt("amount"));
    }
    
    @Override
    public List<GeneralEntity> getEntities() {
        return new ArrayList<>();
    }

    @Override
    public List<List<GeneralEntity>> getLists() {
        return new ArrayList<>();
    }

    @Override
    public void setPrimaryKey(int id) {
        this.spinId = id;
    }

}
