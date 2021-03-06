/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.ejb;

import com.inversa.cobros.model.TblCartera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Z420WK
 */
@Local
public interface CarteraService {

    public List<TblCartera> findAll();

    public TblCartera findById(TblCartera obj);

    public List<TblCartera> findByCodigoCartera(TblCartera obj);

    public List<TblCartera> findByCodigoGestor(TblCartera obj);

    public List<TblCartera> findByNumeroClienteCif(TblCartera obj);

    public List<TblCartera> findByIdentificacion(TblCartera obj);

    public TblCartera findByNumeroCuenta(TblCartera obj);
    
    public TblCartera findByNumeroCuentaANDIdentificacion(TblCartera obj);

    public List<TblCartera> findByNumeroTarjeta(TblCartera obj);

    public List<TblCartera> findByTipoProducto(TblCartera obj);

    public List<TblCartera> findByBucket(TblCartera obj);

    public List<TblCartera> findByDiasMora(TblCartera obj);

    public List<TblCartera> findByPlacement(TblCartera obj);

    public List<TblCartera> findByFechaAsignacion(TblCartera obj);

    public List<TblCartera> findByEstado(TblCartera obj);

    public List<TblCartera> findByUsuarioIngreso(TblCartera obj);

    public void insert(TblCartera obj);

    public void update(TblCartera obj);

    public void delete(TblCartera obj);

    public List<TblCartera> findByCarteraGestorIdentificacion(TblCartera objCartera);
    
    public List<TblCartera> findByCodigoGestorANDCodigoCartera(TblCartera objCartera);
    
    public List<TblCartera> findByCarteraGestorIdentificacionNotExistsGestion(TblCartera objCartera);
    
    public List<TblCartera> findByCodigoCarteraAndIdentificacion(TblCartera obj);

}
