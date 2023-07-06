package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DB;
import DB.DbException;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection conn;

    public UsuarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Usuario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "INSERT INTO usuarios (id, nome, idade) "
                + "VALUES (?, ?, ?)");
                
            st.setInt(1, obj.getId());
            st.setString(2, obj.getName());
            st.setInt(3, obj.getAge());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void updateById(Usuario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "UPDATE usuarios SET nome = ? WHERE id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Usuario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "DELETE FROM usuarios WHERE id = ?");
            
            st.setInt(1, obj.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Usuario findUserById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                "SELECT id, nome, idade FROM usuarios WHERE id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                return createUsuario(rs);
            }
            else {
                return null;
            }
        } 
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    public Usuario createUsuario(ResultSet rs) {
        try {
            Usuario obj = new Usuario(rs.getString("nome"), rs.getInt("idade"), rs.getInt("id"));
            return obj;
        } 
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
        }
    }
}
