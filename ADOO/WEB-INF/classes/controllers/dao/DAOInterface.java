package dao;

import java.util.*;
import java.sql.*;

public interface DAOInterface<T>{

  final String url = "jdbc:mysql://localhost:3306/";
  final String dbName = "";
  Connection conex = null;
  Statement statement = null;
  ResultSet rs = null;

  T read(int id);

  Vector<T> read();

  void create();

  void update(int id);

  void delete(int id);
}
