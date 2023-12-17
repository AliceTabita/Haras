/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.tables;

import br.com.haras.model.Equino;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alice
 */
public class TMEquino extends AbstractTableModel{
    
    private List<Equino> lsEquino;
    private final int NOME =0;
    private final int PROPRIETARIO = 1;
    private final int RACA = 2;
    private final int DTNASCIMENTO =3;
    private final int PESO = 4;

    public TMEquino(List<Equino> lsEquino) {
        this.lsEquino = lsEquino;
    }

    
    @Override
    public int getRowCount() {
        return lsEquino.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equino equino = new Equino();
        if (lsEquino.isEmpty()) {
            return equino;
        } else {
            equino = (Equino) lsEquino.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return equino;
                case NOME:
                    return equino.getNome();
                case PROPRIETARIO:
                    return equino.getProprietario().getNome();
                case RACA:
                    return equino.getRaca().getNome();
                case DTNASCIMENTO:
                    return equino.getDtNascimento();
                case PESO:
                    return equino.getVlPeso();
                 default: 
                    break;
            }
        }
        return equino;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case NOME:
                return "Nome";
            case PROPRIETARIO:
                return "Proprietário";
            case RACA:
                return "Raça";
            case DTNASCIMENTO:
                return "Data de nascimento"; 
            case PESO:
                return "Peso";
            default:
                break;
        }

        return "";
    }
}
