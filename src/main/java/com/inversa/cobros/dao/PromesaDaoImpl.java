/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.dao;

import com.inversa.cobros.model.TblPromesa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Z420WK
 */
@Stateless
public class PromesaDaoImpl implements PromesaDao {

    @PersistenceContext(unitName = "cobrosPU")
    EntityManager em;

    @Override
    public List<TblPromesa> findAll() {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findAll", TblPromesa.class);
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public TblPromesa findById(TblPromesa obj) {
        return em.find(TblPromesa.class, obj.getIdPromesa());
    }

    @Override
    public List<TblPromesa> findByOperacion(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByOperacion", TblPromesa.class);
        query.setParameter("operacion", obj.getOperacion());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public List<TblPromesa> findByTelefono(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByTelefono", TblPromesa.class);
        query.setParameter("telefono", obj.getTelefono());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public List<TblPromesa> findByFechaPago(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByFechaPago", TblPromesa.class);
        query.setParameter("fechaPago", obj.getFechaPago());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public List<TblPromesa> findByUsuarioingreso(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByUsuarioingreso", TblPromesa.class);
        query.setParameter("usuarioingreso", obj.getUsuarioingreso());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public List<TblPromesa> findByFechaingreso(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByFechaingreso", TblPromesa.class);
        query.setParameter("fechaingreso", obj.getFechaingreso());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public List<TblPromesa> findByUsuariomodifico(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByUsuariomodifico", TblPromesa.class);
        query.setParameter("usuariomodifico", obj.getUsuariomodifico());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public List<TblPromesa> findByFechamodifico(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByFechamodifico", TblPromesa.class);
        query.setParameter("fechamodifico", obj.getFechamodifico());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public void insert(TblPromesa obj) {
        em.persist(obj);
    }

    @Override
    public void update(TblPromesa obj) {
        em.merge(obj);
    }

    @Override
    public void delete(TblPromesa obj) {
        em.merge(obj);
        em.remove(obj);
    }

    @Override
    public List<TblPromesa> findByFechaPagoAndUsuarioIngreso(TblPromesa obj) {
        TypedQuery<TblPromesa> query = em.createNamedQuery("TblPromesa.findByFechaPagoAndUsuarioIngreso", TblPromesa.class);
        query.setParameter("fechaPago", obj.getFechaPago(), TemporalType.DATE);
        query.setParameter("usuarioingreso", obj.getUsuarioingreso());
        List<TblPromesa> results = query.getResultList();
        return results;
    }

    @Override
    public TblPromesa findPromesaUltimoPago(Long idGestion, Long idLlamada) {
        Query query = em.createNativeQuery("select tp.* from tbl_promesa tp where tp.id_gestion = ?1 and tp.id_llamada = ?2 and tp.fecha_pago = (select max(tp.fecha_pago) from tbl_promesa tp where tp.id_gestion = ?3 and tp.id_llamada = ?4)", TblPromesa.class);
        Object obj = query.setParameter(1, idGestion).setParameter(2, idLlamada).setParameter(3, idGestion).setParameter(4, idLlamada).getSingleResult();
        if (obj != null) {
            TblPromesa ultimoPago = (TblPromesa) obj;
            return ultimoPago;
        }
        return null;
    }

    /**
     * 
     * @param idGestion
     * @return 
     */
    public TblPromesa findPromesaUltimoPago(Long idGestion) {
        
        try {
            Query query = em.createNativeQuery("select tp.* from tbl_promesa tp where tp.id_gestion = ?1 and tp.fecha_pago = (select max(tp.fecha_pago) from tbl_promesa tp where tp.id_gestion = ?2)", TblPromesa.class);
            Query sql = query.setParameter(1, idGestion).setParameter(2, idGestion);
            if (sql != null) {
                Object obj = sql.getSingleResult();
                if (obj != null) {
                    TblPromesa ultimoPago = (TblPromesa) obj;
                    return ultimoPago;
                }
            }
        } catch (NoResultException e) {
            return null;
        }

        return null;
    }

}
