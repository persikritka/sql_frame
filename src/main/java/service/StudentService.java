package service;

import java.sql.Date;
import java.sql.SQLException;

public interface StudentService {
    public void insert(String name, String surname, String date, int idSex) throws SQLException;
    public void delete(int id) throws SQLException;
    public void update(int id, String name, String surname, String birthday, int idSex) throws SQLException;
}