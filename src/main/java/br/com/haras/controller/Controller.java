
import java.util.List;
import org.hibernate.SessionFactory;

public class Controller {

    private final HistoricoDAO historicoDAO;

    public Controller(SessionFactory sessionFactory) {
        this.historicoDAO = new HistoricoDAO(sessionFactory);
    }

    Controller() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void cadastrarHistorico(String nome, String dataConsulta, String proprietario, String veterinario, String tratamento) {
        HistoricoMedicoEquino historico = new HistoricoMedicoEquino();
        historico.setNome(nome);
        historico.setDataConsulta(dataConsulta);
        historico.setProprietario(proprietario);
        historico.setVeterinario(veterinario);
        historico.setTratamento(tratamento);

        historicoDAO.salvar(historico);
    }

    public List<HistoricoMedicoEquino> listarHistoricos() {
        return historicoDAO.listarTodos();
    }

    // ... Importações e declarações de variáveis ...
    public class SuaClasseGUI extends javax.swing.JFrame {

        public SuaClasseGUI() {
            initComponents();
            new Controller(HistoricoDAO.getSessionFactory());
        }
        // Outros métodos gerados automaticamente...

        private void initComponents() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

}
