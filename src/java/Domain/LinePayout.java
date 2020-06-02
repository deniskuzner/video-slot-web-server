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
public class LinePayout implements GeneralEntity {

    private int id;
    private int symbolId;
    private int arrayLength;
    private int amount;

    public LinePayout() {
    }

    public LinePayout(int id, int symbolId, int arrayLength, int amount) {
        this.id = id;
        this.symbolId = symbolId;
        this.arrayLength = arrayLength;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + symbolId + ", " + arrayLength + ", " + amount;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", symbolId=" + symbolId + ", arrayLength=" + arrayLength + ", amount=" + amount;
    }

    @Override
    public String getClassName() {
        return "linepayout";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "symbolId", "arrayLength", "amount"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new LinePayout(rs.getInt("id"), rs.getInt("symbolId"), rs.getInt("arrayLength"), rs.getInt("amount"));
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
        this.id = id;
    }

}
