/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author User
 */
public class User implements GeneralEntity {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private int balance;

    public User() {
    }

    public User(int id, String username, String password, String firstName, String lastName, String gender, Date birthDate, int balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String getAtrValue() {
        return id + ", '" + username + "', '" + password + "', '" + firstName + "', '" + lastName + "', '" + gender + "', '" + birthDate + "', " + balance;
    }

    @Override
    public String setAtrValue() {
        return "id=" + id + ", username='" + username + "', password='" + password
                + "', firstName='" + firstName + "', lastName='" + lastName
                + "', gender='" + gender + "', birthDate='" + birthDate + "', balance=" + balance;
    }

    @Override
    public String getClassName() {
        return "user";
    }

    @Override
    public String getWhereCondition() {
        return "id=" + id;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"id", "username", "password", "firstName", "lastName", "gender", "birthDate", "balance"};
        return names[column];
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"), rs.getDate("birthDate"), rs.getInt("balance"));
    }

}
