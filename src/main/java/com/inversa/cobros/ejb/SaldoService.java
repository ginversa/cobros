/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.ejb;

import com.inversa.cobros.model.TblSaldo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Z420WK
 */
@Local
public interface SaldoService {

    public List<TblSaldo> findAll();

    public TblSaldo findByIdSaldo(TblSaldo obj);

    public void insert(TblSaldo obj);

    public void update(TblSaldo obj);

    public void delete(TblSaldo obj);

}
