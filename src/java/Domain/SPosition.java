/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class SPosition implements GeneralEntity {

    int id;
    int spinId;
    int positionId;
    int symbolId;

    public SPosition() {
    }

    public SPosition(int id, int spinId, int positionId, int symbolId) {
        this.id = id;
        this.spinId = spinId;
        this.positionId = positionId;
        this.symbolId = symbolId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpinId() {
        return spinId;
    }

    public void setSpinId(int spinId) {
        this.spinId = spinId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + spinId + ", " + positionId + ", " + symbolId;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", spinId=" + spinId + ", positionId=" + positionId + ", symbolId=" + symbolId;
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
        String names[] = {"id", "spinId", "positionId", "symbolId"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new SPosition(rs.getInt("id"), rs.getInt("spinId"), rs.getInt("positionId"), rs.getInt("symbolId"));
    }

}
