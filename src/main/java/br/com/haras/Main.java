package br.com.haras;
import br.com.haras.model.Cliente;
import br.com.haras.model.dao.ClienteDao;
import br.com.haras.view.ClienteGUI;
import br.com.haras.view.FrMenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main
{
    public static void main(String[] args) {
        new FrMenu();
        

    }
}