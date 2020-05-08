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
public class Symbol implements GeneralEntity {

    private int id;
    private String name;

    public Symbol() {
    }

    public Symbol(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAtrValue() {
        return id + ", '" + name + "'";
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", name='" + name + "'";
    }

    @Override
    public String getClassName() {
        return "symbol";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "name"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Symbol(rs.getInt("id"), rs.getString("name"));
    }

    @Override
    public List<List<GeneralEntity>> getLists() {
        return null;
    }

    @Override
    public void setPrimaryKey(int id) {
        this.id = id;
    }

}
