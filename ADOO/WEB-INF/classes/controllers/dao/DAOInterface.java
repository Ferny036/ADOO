package dao;

import java.util.*;
import java.sql.*;

public interface DAOInterface<T>{

  final String url = "jdbc:mysql://localhost:3306/";
  final String dbName = "";

  T read(int id);

  Vector<T> read();

  void create(T t);

  void update(int id, T t);

  void delete(int id);
}
