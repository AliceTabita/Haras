/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.tables;

import br.com.haras.model.Raca;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alice
 */
public class TMRaca extends AbstractTableModel{
    private List<Raca> lsRaca;
    private final int NOME =0;
    private final int DESCRICAO = 1;
    private final int VLBASERACA = 2;

    public TMRaca(List<Raca> lsRaca) {
        this.lsRaca = lsRaca;
    }

    
    @Override
    public int getRowCount() {
        return lsRaca.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raca raca = new Raca();
        if (lsRaca.isEmpty()) {
            return raca;
        } else {
            raca = (Raca) lsRaca.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return raca;
                case NOME:
                    return raca.getNome();
                case DESCRICAO:
                    return raca.getDescricao();
                case VLBASERACA:
                    return raca.getVlBaseRaca();
                 default: 
                    break;
            }
        }
        return raca;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case NOME:
                return "Nome";
            case DESCRICAO:
                return "Descrição";
            case VLBASERACA:
                return "Valor base"; 
            default:
                break;
        }

        return "";
    }
}
