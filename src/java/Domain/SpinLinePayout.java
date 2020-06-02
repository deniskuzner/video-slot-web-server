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
public class SpinLinePayout implements GeneralEntity {

    private int gameId;
    private int spinId;
    private int linePayoutId;
    private int lineNumber;

    public SpinLinePayout() {
    }

    public SpinLinePayout(int gameId, int spinId, int linePayoutId, int lineNumber) {
        this.gameId = gameId;
        this.spinId = spinId;
        this.linePayoutId = linePayoutId;
        this.lineNumber = lineNumber;
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

    public int getLinePayoutId() {
        return linePayoutId;
    }

    public void setLinePayoutId(int linePayoutId) {
        this.linePayoutId = linePayoutId;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
    
    @Override
    public String getAtrValue() {
        return gameId + ", " + spinId + ", " + linePayoutId + ", " + lineNumber;
    }

    @Override
    public String setAtrValue() {
        return "gameId=" + gameId + ", spinId=" + spinId + ", linePayoutId=" + linePayoutId + ", lineNumber=" + lineNumber;
    }

    @Override
    public String getClassName() {
        return "spinlinepayout";
    }

    @Override
    public String getWhereCondition() {
        return "gameId=" + gameId;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"gameId", "spinId", "linePayoutId", "lineNumber"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new SpinLinePayout(rs.getInt("gameId"), rs.getInt("spinId"), rs.getInt("linePayoutId"), rs.getInt("lineNumber"));
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
