package model.dao;

/* implementação da interface UsuarioDao com os métodos c.r.u.d */

import model.entities.Usuario;

public interface UsuarioDao {
    
    void insert(Usuario user);
    void updateById(Usuario user);
    void deleteById(Usuario user);
    Usuario findUserById(Integer id);
}
