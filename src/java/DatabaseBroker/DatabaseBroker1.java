/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseBroker;

import Domain.GeneralEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DatabaseBroker1 extends DatabaseBroker {

    Connection connection = null;

    @Override
    public boolean makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/video_slot";
            connection = DriverManager.getConnection(url, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean insertRecord(GeneralEntity generalEntity) {
        String query = "INSERT INTO " + generalEntity.getClassName() + " VALUES (" + generalEntity.getAtrValue() + ")";
        return executeUpdate(query);
    }

    @Override
    public boolean insertCompositeRecord(GeneralEntity generalEntity) {
        String query = "INSERT INTO " + generalEntity.getClassName() + " VALUES (" + generalEntity.getAtrValue() + ")";

        Statement st = null;
        boolean signal = false;
        try {
            st = connection.prepareStatement(query);
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKeys = st.getGeneratedKeys();
            int id = 0;
            if (rsKeys.next()) {
                id = rsKeys.getInt(1);
                generalEntity.setPrimaryKey(id);
                signal = true;
            }
            
            List<GeneralEntity> entities = generalEntity.getEntities();
            for (GeneralEntity entity : entities) {
                entity.setPrimaryKey(id);
                query = "INSERT INTO " + entity.getClassName() + " VALUES (" + entity.getAtrValue() + ")";
                    if(!executeUpdate(query))
                        signal = false;
            }

            List<List<GeneralEntity>> lists = generalEntity.getLists();
            for (List<GeneralEntity> list : lists) {
                for (GeneralEntity ge : list) {
                    ge.setPrimaryKey(id);
                    query = "INSERT INTO " + ge.getClassName() + " VALUES (" + ge.getAtrValue() + ")";
                    if(!executeUpdate(query))
                        signal = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

    @Override
    public boolean updateRecord(GeneralEntity generalEntity, GeneralEntity generalEntityId) {
        String query = "UPDATE " + generalEntity.getClassName() + " SET " + generalEntity.setAtrValue() + " WHERE " + generalEntityId.getWhereCondition();
        return executeUpdate(query);
    }

    @Override
    public boolean updateRecord(GeneralEntity generalEntity) {
        String query = "UPDATE " + generalEntity.getClassName() + " SET " + generalEntity.setAtrValue() + " WHERE " + generalEntity.getWhereCondition();
        return executeUpdate(query);
    }

    @Override
    public boolean deleteRecord(GeneralEntity generalEntity) {
        String query = "DELETE FROM " + generalEntity.getClassName() + " WHERE " + generalEntity.getWhereCondition();
        return executeUpdate(query);
    }

    @Override
    public boolean deleteRecords(GeneralEntity generalEntity, String where) {
        String query = "DELETE FROM " + generalEntity.getClassName() + " " + where;
        return executeUpdate(query);
    }

    @Override
    public GeneralEntity findRecord(GeneralEntity generalEntity) {
        ResultSet rs = null;
        Statement st = null;
        String query = "SELECT * FROM " + generalEntity.getClassName() + " WHERE " + generalEntity.getWhereCondition();
        boolean signal;
        try {
            st = connection.prepareStatement(query);
            rs = st.executeQuery(query);
            signal = rs.next(); // rs.next() vraca true ako ima postoji rezultat upita.
            if (signal == true) {
                generalEntity = generalEntity.getNewRecord(rs);
            } else {
                generalEntity = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return generalEntity;
    }

    @Override
    public List<GeneralEntity> findRecord(GeneralEntity generalEntity, String where) {
        ResultSet rs = null;
        Statement st = null;
        String query = "SELECT * FROM " + generalEntity.getClassName() + " " + where;
        List<GeneralEntity> result = new ArrayList<>();
        try {
            st = connection.prepareStatement(query);
            rs = st.executeQuery(query);
            while (rs.next()) {
                result.add(generalEntity.getNewRecord(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return result;
    }

    @Override
    public boolean commitTransation() {
        try {
            connection.commit();
        } catch (SQLException esql) {
            return false;
        }
        return true;
    }

    @Override
    public boolean rollbackTransation() {
        try {
            connection.rollback();
        } catch (SQLException esql) {
            return false;
        }

        return true;
    }

    @Override
    public void closeConnection() {
        close(connection, null, null);
    }

    @Override
    public boolean getCounter(GeneralEntity generalEntity, AtomicInteger counter) {
        String query = "SELECT Counter FROM Counter WHERE TableName = '" + generalEntity.getClassName() + "'";

        ResultSet rs = null;
        Statement st = null;

        boolean signal = false;
        try {
            st = connection.prepareStatement(query);
            rs = st.executeQuery(query);
            signal = rs.next();
            counter.set(rs.getInt("Counter") + 1);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, rs);
        }
        return signal;
    }

    @Override
    public boolean increaseCounter(GeneralEntity generalEntity, AtomicInteger counter) {
        String query = "UPDATE Counter SET Counter =" + counter.get() + " WHERE TableName = '" + generalEntity.getClassName() + "'";
        return executeUpdate(query);
    }

    @Override
    public GeneralEntity getRecord(GeneralEntity generalEntity, int index) {
        ResultSet rs = null;
        Statement st = null;
        String query = "SELECT * FROM " + generalEntity.getClassName()
                + " order by " + generalEntity.getNameByColumn(0) + " ASC LIMIT " + index + ",1";
        boolean signal;
        try {
            st = connection.prepareStatement(query);
            rs = st.executeQuery(query);
            signal = rs.next();
            if (signal == true) {
                generalEntity = generalEntity.getNewRecord(rs);
            } else {
                generalEntity = null;
            }
        } catch (SQLException ex) {
            generalEntity = null;
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return generalEntity;
    }

    @Override
    public int getRecordsNumber(GeneralEntity generalEntity) {
        ResultSet rs = null;
        Statement st = null;
        int recordsNumber = 0;
        String upit = "SELECT * FROM " + generalEntity.getClassName();
        try {
            st = connection.prepareStatement(upit);
            rs = st.executeQuery(upit);
            if (rs.last()) {
                recordsNumber = rs.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(null, st, rs);
        }
        return recordsNumber;
    }

    public boolean executeUpdate(String query) {
        Statement st = null;
        boolean signal = false;
        try {
            st = connection.prepareStatement(query);
            int rowcount = st.executeUpdate(query);
            if (rowcount > 0) {
                signal = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            close(null, st, null);
        }
        return signal;
    }

    public void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseBroker1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
