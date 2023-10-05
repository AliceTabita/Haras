/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.tables;

import br.com.haras.model.Evento;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class TMEventos extends AbstractTableModel{
    
    private List<Evento> lsEvento;
    private final int ID =0;
    private final int NOME = 1;
    private final int DATA = 2;
    private final int HORA =3;
    private final int STATUS = 4;

    public TMEventos(List<Evento> lsEvento) {
        this.lsEvento = lsEvento;
    }

    
    @Override
    public int getRowCount() {
        return lsEvento.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Evento evento = new Evento();
        if (lsEvento.isEmpty()) {
            return evento;
        } else {
            evento = (Evento) lsEvento.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return evento;
                case ID:
                    return evento.getId();
                case NOME:
                    return evento.getNome();
                case DATA:
                    return evento.getData();
                case HORA:
                    return evento.getHora();
                case STATUS:
                    return evento.getSituacao();
                 default: 
                    break;
            }
        }
        return evento;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case ID:
                return "Id";
            case NOME:
                return "Nome";
            case DATA:
                return "Data";
            case HORA:
                return "Hora"; 
            case STATUS:
                return "Situação";
            default:
                break;
        }

        return "";
    }
}
