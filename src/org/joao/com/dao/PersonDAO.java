package org.joao.com.dao;

import org.joao.com.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DAO<Person> {
    public AccountDAO() {
        super("saveProcedure", "updateProcedure", "searchProcedure", "readAllProcedure", "deleteProcedure");
    }

    @Override
    protected void setProcedureParams(PreparedStatement sp, Person person) throws SQLException {
        if (person.getIdPerson() == 0) {
            sp.setString(1, person.getPersonName());
            sp.setString(2, person.getLastName());
            sp.setString(3, person.getNacionality());
            sp.setString(4, person.getNumberDocumentType());
            sp.setString(5, person.getDirection());
            sp.setString(6, person.getUserName());
            sp.setString(7, person.getPassword());
            sp.setString(8, person.getGender());
            sp.setString(9, person.getDateCreation());
            sp.setInt(10, person.getPhone());
            sp.setInt(11, person.get_idDocumentType());
            sp.setInt(12, person.get_idPhoneCompany());
        }
        sp.setInt(1, person.getIdPerson());
        sp.setString(2, person.getPersonName());
        sp.setString(3, person.getLastName());
        sp.setString(4, person.getNacionality());
        sp.setString(5, person.getNumberDocumentType());
        sp.setString(6, person.getDirection());
        sp.setString(7, person.getUserName());
        sp.setString(8, person.getPassword());
        sp.setString(9, person.getGender());
        sp.setString(10, person.getDateCreation());
        sp.setInt(11, person.getPhone());
        sp.setInt(12, person.get_idDocumentType());
        sp.setInt(13, person.get_idPhoneCompany());
    }

    @Override
    public Person resultSetToObject(ResultSet resultSet) throws SQLException {
        int idPerson = resultSet.getInt(1);
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String direction = resultSet.getString(4);
        int phone = resultSet.getInt(5);
        String user = resultSet.getString(6);
        String dateCreation = resultSet.getString(7);
        String password = resultSet.getString(8);
        String gender = resultSet.getString(9);
        String nacionality = resultSet.getString(10);
        String numberDocumentType = resultSet.getString(11);
        int _idDocumentType = resultSet.getInt(12);
        int _idPhoneCompany = resultSet.getInt(13);
        return new Person(idPerson, firstName, lastName, nacionality, numberDocumentType, direction, user, password, gender, dateCreation, phone, _idDocumentType, _idPhoneCompany);
    }
}