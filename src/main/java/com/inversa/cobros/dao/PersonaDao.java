/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.dao;

import com.inversa.cobros.model.TblPersona;
import java.util.List;

/**
 *
 * @author Z420WK
 */
public interface PersonaDao {

    public List<TblPersona> findAll();

    public TblPersona findById(TblPersona obj);

    public TblPersona findByNombre(TblPersona obj);

    public TblPersona findByCedula(TblPersona obj);

    public List<TblPersona> findByUsuarioingreso(TblPersona obj);

    public List<TblPersona> findByFechaingreso(TblPersona obj);

    public List<TblPersona> findByUsuariomodifico(TblPersona obj);

    public List<TblPersona> findByFechamodifico(TblPersona obj);

    public void insert(TblPersona obj);

    public void update(TblPersona obj);

    public void delete(TblPersona obj);
}
