/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface GeneralEntity extends Serializable {

    String getAtrValue();
    String setAtrValue();
    String getClassName();
    String getWhereCondition();
    String getNameByColumn(int column);
    GeneralEntity getNewRecord(ResultSet rs) throws SQLException;
    List<List<GeneralEntity>> getLists();
    void setPrimaryKey(int id);

}
