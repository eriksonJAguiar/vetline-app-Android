package controller;

import Dao.ClienteDao;
import Dao.UsuarioDAO;
import model.Cliente;
import model.Usuario;

/**
 * Created by root on 05/12/16.
 */

public class CCadastrarCliente {

    ClienteDao dao = new ClienteDao();

    public boolean cadastrarCliente(Cliente c){

        boolean gravou = dao.inserir(c);

        return gravou;
    }
}
