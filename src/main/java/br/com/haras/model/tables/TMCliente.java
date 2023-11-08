/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.tables;

import br.com.haras.model.Cliente;
import br.com.haras.model.Evento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alice
 */
public class TMCliente extends AbstractTableModel{
    
    private List<Cliente> lsCliente;
    private final int ID =0;
    private final int NOME = 1;
    private final int EMAIL = 2;
    private final int TELEFONE =3;
    private final int SEXO = 4;

    private final int CPF = 5;

    public TMCliente() {
    }

    public TMCliente(List<Cliente> lsCliente) {
        this.lsCliente = lsCliente;
    }

    @Override
    public int getRowCount() {
        return lsCliente.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = new Cliente();
        if (lsCliente.isEmpty()) {
            return cliente;
        } else {
            cliente = (Cliente) lsCliente.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return cliente;
                case ID:
                    return cliente.getIdCliente();
                case NOME:
                    return cliente.getNome();
                case EMAIL:
                    return cliente.getEmail();
                case TELEFONE:
                    return cliente.getTelefone();
                case SEXO:
                    return cliente.getSexo();
                case CPF:
                    return cliente.getCpf();
                default:
                    break;
            }
        }
        return cliente;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case ID:
                return "Id";
            case NOME:
                return "Nome";
            case EMAIL:
                return "Email";
            case TELEFONE:
                return "Telefone";
            case SEXO:
                return "Sexo";
            case CPF:
                return "CPF";
            default:
                break;
        }

        return "";
    }
}

