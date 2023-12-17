/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.model.Doenca;
import br.com.haras.model.TipoTratamento;
import br.com.haras.model.dao.DoencaDao;
import br.com.haras.model.dao.TipoTratamentoDao;
import br.com.haras.model.dao.TratamentoDao;
import java.util.List;

/**
 *
 * @author alice
 */
public class TratamentoController {
    private TratamentoDao tratamentoDao;
    private TipoTratamentoDao tipoTratamentoDao;
    private DoencaDao doencaDao;
    public TratamentoController(){
        tratamentoDao =new TratamentoDao();
        tipoTratamentoDao = new TipoTratamentoDao();
        doencaDao = new DoencaDao();
    }
    public List<TipoTratamento> listTpTratamento(){
        
        return tipoTratamentoDao.findAll();
    }
    public List<Doenca> listDoenca(){
        
        return doencaDao.findAll();
    }
}
