package service.impl;

import database.ConnectorToDatabase;
import service.StudentService;

import java.sql.Date;
import java.sql.SQLException;

public class StudentImpl implements StudentService {
    private final ConnectorToDatabase connectorToDataBase;
    public StudentImpl(){
        connectorToDataBase=new ConnectorToDatabase();
    }
    @Override
    public void insert(String name, String surname, String date, int idSex) throws SQLException {
        String str = "insert into student(name, surname, birthday, id_sex) values("+"'"
                +name + "'" + ","
                + "'" +surname + "'" +","
                +"'"+Date.valueOf(date) +"'"+ ","
                + idSex  + ")";
        connectorToDataBase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int id) throws SQLException {
        connectorToDataBase.getStatement().executeUpdate("delete from student where id = '" + id +"'");
    }

    @Override
    public void update(int id, String name, String surname, String birthday, int idSex) throws SQLException {
        String q1 = "UPDATE student set name = '" + name + "', surname = '" + surname + "', birthday = '" + Date.valueOf(birthday) + "', id_sex = '" + idSex + "' WHERE id = " + id;
        connectorToDataBase.getStatement().executeUpdate(q1);
    }
}
