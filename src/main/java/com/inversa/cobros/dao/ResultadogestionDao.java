/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.dao;

import com.inversa.cobros.model.TblResultadogestion;
import java.util.List;

/**
 *
 * @author Z420WK
 */
public interface ResultadogestionDao {

    public List<TblResultadogestion> findAll();

    public TblResultadogestion findByIdResultadogestion(TblResultadogestion obj);

    public TblResultadogestion findByDescripcion(TblResultadogestion obj);

    public TblResultadogestion findByCodigo(TblResultadogestion obj);

    public List<TblResultadogestion> findByUsuarioingreso(TblResultadogestion obj);

    public List<TblResultadogestion> findByFechaingreso(TblResultadogestion obj);

    public List<TblResultadogestion> findByUsuariomodifico(TblResultadogestion obj);

    public List<TblResultadogestion> findByFechamodifico(TblResultadogestion obj);

    public void insert(TblResultadogestion obj);

    public void update(TblResultadogestion obj);

    public void delete(TblResultadogestion obj);

}
