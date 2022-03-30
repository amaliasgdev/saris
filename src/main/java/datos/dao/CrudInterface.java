package datos.dao;

import java.util.List;

public interface CrudInterface<T> {
    
    public List<T> select(String texto);

    public boolean insert(T object);

    public boolean update(T object);

    public boolean delete(T object);
    
    public T selectById(int id);
    
}
