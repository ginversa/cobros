/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.dao;

import com.inversa.cobros.model.TblDireccion;
import java.util.List;

/**
 *
 * @author Z420WK
 */
public interface DireccionDao {

    public List<TblDireccion> findAll();

    public TblDireccion findById(TblDireccion obj);

    public TblDireccion findByDireccion(TblDireccion obj);

    public List<TblDireccion> findByRanking(TblDireccion obj);

    public List<TblDireccion> findByUsuarioingreso(TblDireccion obj);

    public List<TblDireccion> findByFechaingreso(TblDireccion obj);

    public List<TblDireccion> findByUsuariomodifico(TblDireccion obj);

    public List<TblDireccion> findByFechamodifico(TblDireccion obj);

    public void insert(TblDireccion obj);

    public void update(TblDireccion obj);

    public void delete(TblDireccion obj);
    
}
