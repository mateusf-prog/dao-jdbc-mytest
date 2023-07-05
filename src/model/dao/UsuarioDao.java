package model.dao;

/* implementação da interface UsuarioDao com os métodos c.r.u.d */

import model.entities.Usuario;

public interface UsuarioDao {
    
    void insert(Usuario user);
    void update(Usuario user);
    void delete(Usuario user);
    void findUserById(Integer id);
}
