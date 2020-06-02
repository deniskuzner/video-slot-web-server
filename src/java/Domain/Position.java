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
public class Position implements GeneralEntity {

    private int id;
    private int x;
    private int y;

    public Position() {
    }
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getAtrValue() {
        return id + ", " + x + ", " + y;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", x=" + x + ", y= " + y;
    }

    @Override
    public String getClassName() {
        return "position";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "x", "y"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Position(rs.getInt("id"), rs.getInt("x"), rs.getInt("y"));
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
