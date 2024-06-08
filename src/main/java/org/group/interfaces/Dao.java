package org.group.interfaces;

import org.group.entity.Student;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface Dao <K,E>{
    public List<E> findAll();
    public E save(E e);
    public boolean delete(K id);
    public Optional<E> findById(K id);
    public boolean Update(E e);
}
