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
public class Game implements GeneralEntity {

    private int id;
    private int userId;

    public Game() {
    }

    public Game(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + userId;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", userId=" + userId;
    }

    @Override
    public String getClassName() {
        return "game";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "userId"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Game(rs.getInt("id"), rs.getInt("userId"));
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