package br.com.haras;
import br.com.haras.model.Cliente;
import br.com.haras.model.Raca;
import br.com.haras.model.dao.ClienteDao;
import br.com.haras.model.dao.RacaDao;
import br.com.haras.view.Login;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Main
{
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Alice", "alicetabita26@gmail.com", "4153453453", "feminino", "19542980728");
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.save(cliente); 
       List<String> nomesRacas = Arrays.asList(
                "Arábico",
                "Appaloosa",
                "Puro Sangue Inglês",
                "Quarto de Milha",
                "Belga",
                "Frisão",
                "Andaluz",
                "Puro Sangue Lusitano",
                "Clydesdale"
                
        );

        RacaDao racaDao = new RacaDao();
        Random random = new Random();
        for (String nomeRaca : nomesRacas) {
            Raca raca = new Raca();
            raca.setNome(nomeRaca);
            raca.setDescricao("Descrição breve da raça " + nomeRaca);
            raca.setVlBaseRaca(new BigDecimal(random.nextDouble() * 10) );
            racaDao.save(raca);
        } 
        
        Login login = new Login();
        login.setVisible(true);

    }
}