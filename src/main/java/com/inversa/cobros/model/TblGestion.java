/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inversa.cobros.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Z420WK
 */
@Entity
@Table(name = "tbl_gestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGestion.findAll", query = "SELECT t FROM TblGestion t"),
    @NamedQuery(name = "TblGestion.findByIdGestion", query = "SELECT t FROM TblGestion t WHERE t.idGestion = :idGestion order by t.fechaingreso desc"),
    @NamedQuery(name = "TblGestion.findByCodigoCartera", query = "SELECT t FROM TblGestion t WHERE t.codigoCartera = :codigoCartera"),
    @NamedQuery(name = "TblGestion.findByNombreCliente", query = "SELECT t FROM TblGestion t WHERE t.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "TblGestion.findByIdentificacion", query = "SELECT t FROM TblGestion t WHERE t.identificacion = :identificacion ORDER BY t.idGestion desc"),
    @NamedQuery(name = "TblGestion.findByIdentificacionANDCodigoCartera", query = "SELECT t FROM TblGestion t WHERE t.identificacion = :identificacion AND t.codigoCartera = :codigoCartera ORDER BY t.idGestion desc"),
    @NamedQuery(name = "TblGestion.findByCodigoCarteraANDIdentificacion", query = "SELECT t FROM TblGestion t\n"
            + " WHERE t.codigoCartera = :codigoCartera\n"
            + "   and t.identificacion = :identificacion\n"
            + "   and t.fechaingreso = (select max(gestion.fechaingreso)\n"
            + "						    from TblGestion gestion\n"
            + "						   where gestion.codigoCartera = t.codigoCartera\n"
            + "                             and gestion.identificacion = t.identificacion)"),
    @NamedQuery(name = "TblGestion.findByCodigoGestor", query = "SELECT t FROM TblGestion t WHERE t.codigoGestor = :codigoGestor order by t.fechaingreso desc"),
    @NamedQuery(name = "TblGestion.findByCodigoGestorANDCodigoCartera", query = "SELECT t FROM TblGestion t WHERE t.codigoGestor = :codigoGestor AND t.codigoCartera = :codigoCartera order by t.fechaingreso desc"),
    @NamedQuery(name = "TblGestion.findByFechaGestion", query = "SELECT t FROM TblGestion t WHERE t.fechaGestion = :fechaGestion order by t.fechaingreso desc"),
    @NamedQuery(name = "TblGestion.findByDescripcion", query = "SELECT t FROM TblGestion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TblGestion.findByEstado", query = "SELECT t FROM TblGestion t WHERE t.estado = :estado"),
    @NamedQuery(name = "TblGestion.findByUsuarioingreso", query = "SELECT t FROM TblGestion t WHERE t.usuarioingreso = :usuarioingreso order by t.fechaingreso desc"),
    @NamedQuery(name = "TblGestion.findByFechaingreso", query = "SELECT t FROM TblGestion t WHERE t.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "TblGestion.findByUsuariomodifico", query = "SELECT t FROM TblGestion t WHERE t.usuariomodifico = :usuariomodifico"),
    @NamedQuery(name = "TblGestion.findByFechamodifico", query = "SELECT t FROM TblGestion t WHERE t.fechamodifico = :fechamodifico")})
public class TblGestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestion")
    private Long idGestion;

    @Size(max = 10)
    @Column(name = "codigo_cartera")
    private String codigoCartera;

    @Size(max = 100)
    @Column(name = "nombre_cartera")
    private String nombre_cartera;

    @Size(max = 50)
    @Column(name = "identificacion")
    private String identificacion;

    @Size(max = 150)
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Size(max = 50)
    @Column(name = "operacion")
    private String operacion;
    
    @Column(name = "leyusura")
    private String leyusura;

    @Size(max = 10)
    @Column(name = "codigo_gestor")
    private String codigoGestor;

    @Column(name = "fecha_gestion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGestion;

    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;

    @Size(max = 3)
    @Column(name = "estado")
    private String estado;

    @Size(max = 50)
    @Column(name = "usuarioingreso")
    private String usuarioingreso;

    @Column(name = "fechaingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;

    @Size(max = 50)
    @Column(name = "usuariomodifico")
    private String usuariomodifico;

    @Column(name = "fechamodifico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodifico;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGestion", fetch = FetchType.LAZY)
    private List<TblLlamada> tblLlamadaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGestion", fetch = FetchType.LAZY)
    private List<TblPromesa> tblPromesaList;
    

    @Transient
    private String codigo_cliente;

    @Transient
    private TblLlamada ultimaLLamada;
    
    @Transient
    private TblPromesa ultimaPromesa;
    

    public TblGestion() {
    }

    public TblGestion(Long idGestion) {
        this.idGestion = idGestion;
    }

    public Long getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(Long idGestion) {
        this.idGestion = idGestion;
    }

    public String getCodigoCartera() {
        return codigoCartera;
    }

    public void setCodigoCartera(String codigoCartera) {
        this.codigoCartera = codigoCartera;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCodigoGestor() {
        return codigoGestor;
    }

    public void setCodigoGestor(String codigoGestor) {
        this.codigoGestor = codigoGestor;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechamodifico() {
        return fechamodifico;
    }

    public void setFechamodifico(Date fechamodifico) {
        this.fechamodifico = fechamodifico;
    }

    @XmlTransient
    public List<TblLlamada> getTblLlamadaList() {
        return tblLlamadaList;
    }

    public void setTblLlamadaList(List<TblLlamada> tblLlamadaList) {
        this.tblLlamadaList = tblLlamadaList;
    }

    @XmlTransient
    public List<TblPromesa> getTblPromesaList() {
        return tblPromesaList;
    }

    public void setTblPromesaList(List<TblPromesa> tblPromesaList) {
        this.tblPromesaList = tblPromesaList;
    }

    public String getNombre_cartera() {
        return nombre_cartera;
    }

    public void setNombre_cartera(String nombre_cartera) {
        this.nombre_cartera = nombre_cartera;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }


    public String getLeyusura() {
        return leyusura;
    }

    public void setLeyusura(String leyusura) {
        this.leyusura = leyusura;
    }

    public TblPromesa getUltimaPromesa() {
        return ultimaPromesa;
    }

    public void setUltimaPromesa(TblPromesa ultimaPromesa) {
        this.ultimaPromesa = ultimaPromesa;
    }

    public TblLlamada getUltimaLLamada() {
        return ultimaLLamada;
    }

    public void setUltimaLLamada(TblLlamada ultimaLLamada) {
        this.ultimaLLamada = ultimaLLamada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestion != null ? idGestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGestion)) {
            return false;
        }
        TblGestion other = (TblGestion) object;
        if ((this.idGestion == null && other.idGestion != null) || (this.idGestion != null && !this.idGestion.equals(other.idGestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inversa.cobros.model.TblGestion[ idGestion=" + idGestion + " ]";
    }

    /*
    @XmlTransient
    public List<TblGestionsaldo> getTblGestionsaldoList() {
        return tblGestionsaldoList;
    }

    public void setTblGestionsaldoList(List<TblGestionsaldo> tblGestionsaldoList) {
        this.tblGestionsaldoList = tblGestionsaldoList;
    }
    */

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioingreso() {
        return usuarioingreso;
    }

    public void setUsuarioingreso(String usuarioingreso) {
        this.usuarioingreso = usuarioingreso;
    }

    public String getUsuariomodifico() {
        return usuariomodifico;
    }

    public void setUsuariomodifico(String usuariomodifico) {
        this.usuariomodifico = usuariomodifico;
    }

}
