package model;

import java.sql.Connection;
import java.util.List;
import util.DBConn;

public abstract class DAO<E> {

    static final Connection CONN = DBConn.getconnection();

    abstract public void add(E e);
    
    abstract public void update(E e);
    
    abstract public void delete(String id);
    
    abstract public List<E> getAll();
    
    abstract public E findBy(String id);
    
}
