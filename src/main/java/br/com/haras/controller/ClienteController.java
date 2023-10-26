package br.com.haras.controller;

import br.com.haras.model.Cliente;
import br.com.haras.model.Evento;
import br.com.haras.model.dao.ClienteDao;
import br.com.haras.model.tables.TMCliente;
import br.com.haras.model.tables.TMEventos;
import br.com.haras.model.valid.CPFValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClienteController {
    private ClienteDao clienteRepository;
    public ClienteController(){
        clienteRepository = new ClienteDao();
    }
    public Cliente buscaClientePorId(int id ){
        return clienteRepository.find(id);
    }
    public TMCliente atualizarTabela(){
        List<Cliente> lsCliente = clienteRepository.findAll();
        return new TMCliente(lsCliente);
    }
    public void atualizarCliente(Cliente cliente){
        Cliente clienteAnterior = clienteRepository.findByCpf(cliente.getCpf());
        clienteAnterior.copy(cliente);
        clienteRepository.update(cliente);
    }
    public String salvarCliente(Cliente clienteNovo){
        if(!CPFValidator.isValidCPF(clienteNovo.getCpf())){
            return "Cpf inválido";
        }
        Cliente clienteConsulta = clienteRepository.findByCpf(clienteNovo.getCpf());
        if(clienteConsulta==null){
            clienteRepository.save(clienteNovo);
            return "Salvo com sucesso";
        }else {
            this.atualizarCliente(clienteNovo);
            return "Cliente atualizado com sucesso";
        }
    }
    public  void excluirCliente(int id){
        Cliente cliente = clienteRepository.find(id);
        clienteRepository.delete(cliente);
    }
    public TMCliente pesquisarCliente(String parametro){
        if(CPFValidator.isValidCPF(parametro)){
            List<Cliente> lsCliente = new ArrayList<>();
            lsCliente.add(clienteRepository.findByCpf(parametro));
            return new TMCliente(lsCliente);
        }else {
            return new TMCliente(clienteRepository.filterByName(parametro));
        }
    }

}
