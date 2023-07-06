package application;

import java.sql.Connection;

import DB.DB;
import model.dao.UsuarioDao;
import model.dao.impl.UsuarioDaoJDBC;
import model.entities.Usuario;

public class Main {
    public static void main(String[] args) {
        
        Connection conn = DB.getConnection();

        UsuarioDao userTest = new UsuarioDaoJDBC(conn);
        
        Usuario user = new Usuario("Matthew", 25, 414);
        Usuario user1 = new Usuario("Maria", 39, 515);


        
        System.out.println("--- teste 1 INSERT ---");
        //userTest.insert(user1);
        System.out.println("teste ok!\n\n");

        System.out.println("--- teste 2 UPDATE ---");
        //user.setName("Manfredi");
        //userTest.updateById(user);
        System.out.println("teste ok!\n\n");

        System.out.println("--- teste 3 DELETE ---");
        //userTest.deleteById(user1);
        System.out.println("teste ok!\n\n");


        System.out.println("--- teste 4 FINDBYID ---");
        System.out.println(userTest.findUserById(231));

    }
}