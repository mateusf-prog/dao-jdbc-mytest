package model.dao;

/* implementação da classe construtura de um objeto UsuarioJDBC */ 

import model.dao.impl.UsuarioDaoJDBC;

public class Daofactory {
    
    public static UsuarioDao createUsuario() {
        return new UsuarioDaoJDBC();
    }
}
