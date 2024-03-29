/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author Rafael Mendez
 */

import java.math.BigDecimal;
import java.util.Date;

public class Candidatos
{
    private Integer id_candidato;
    private Integer id_catprog;
    private String numcontrato;
    private String clave_elect;
    private String curp;
    private String rfc;
    private String nombre;
    private String conyuge;
    private BigDecimal capital;
    private BigDecimal sub_inic;
    private BigDecimal enganche;
    private BigDecimal interes;
    private BigDecimal admon;
    private BigDecimal o_seg;
    private BigDecimal sub_inf;
    private Date fecha_cont;
    private String descripcion;
    private String mza;
    private String lte;
    private BigDecimal area;
    private String domicilio;
    private String clave_cat;
    private Date fecha_ip;
    
    
    
    public Candidatos(){}

    
    //constructor que permite crear un objeto
    //Mensaje a partir de los datos del mismo
    public Candidatos(Integer id_candidato,Integer id_catprog,String numcontrato, String clave_elect, String curp, String rfc, String nombre, String conyuge,BigDecimal capital,BigDecimal sub_inic,BigDecimal enganche,BigDecimal interes,BigDecimal admon,BigDecimal o_seg,BigDecimal sub_inf,Date fecha_cont)
    {
        this.id_candidato=id_candidato;
        this.id_catprog=id_catprog;
        this.numcontrato=numcontrato;
        this.clave_elect=clave_elect;
        this.curp=curp;
        this.rfc=rfc;
        this.nombre=nombre;
        this.conyuge=conyuge;
        this.capital=capital;
        this.sub_inic=sub_inic;
        this.enganche=enganche;
        this.interes=interes;
        this.admon=admon;
        this.o_seg=o_seg;
        this.sub_inf=sub_inf;
        this.fecha_cont=fecha_cont;
        
    }
    
    public Candidatos(Integer id_candidato,Integer id_catprog,String numcontrato, String clave_elect, String curp, String rfc, String nombre, String conyuge,BigDecimal capital,BigDecimal sub_inic,BigDecimal enganche,BigDecimal interes,BigDecimal admon,BigDecimal o_seg,BigDecimal sub_inf,Date fecha_cont,String descripcion)
    {
        this.id_candidato=id_candidato;
        this.id_catprog=id_catprog;
        this.numcontrato=numcontrato;
        this.clave_elect=clave_elect;
        this.curp=curp;
        this.rfc=rfc;
        this.nombre=nombre;
        this.conyuge=conyuge;
        this.capital=capital;
        this.sub_inic=sub_inic;
        this.enganche=enganche;
        this.interes=interes;
        this.admon=admon;
        this.o_seg=o_seg;
        this.sub_inf=sub_inf;
        this.fecha_cont=fecha_cont;
        this.descripcion=descripcion;
        
    }
    
    public Candidatos(Integer id_candidato,Integer id_catprog,String numcontrato, String clave_elect, String curp, String rfc, String nombre, String conyuge,Date fecha_cont,String descripcion,String mza,String lte,BigDecimal area,String domicilio,String clave_cat,Date fecha_ip)
    {
        this.id_candidato=id_candidato;
        this.id_catprog=id_catprog;
        this.numcontrato=numcontrato;
        this.clave_elect=clave_elect;
        this.curp=curp;
        this.rfc=rfc;
        this.nombre=nombre;
        this.conyuge=conyuge;
        
        this.fecha_cont=fecha_cont;
        this.descripcion=descripcion;
        this.mza=mza;
        this.lte=lte;
        this.area=area;
        this.domicilio=domicilio;
        this.clave_cat=clave_cat;
        this.fecha_ip=fecha_ip;
    }
    
    
    public Integer getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Integer id_candidato) {
        this.id_candidato = id_candidato;
    }

    public Integer getId_catprog() {
        return id_catprog;
    }

    public void setId_catprog(Integer id_catprog) {
        this.id_catprog = id_catprog;
    }

    public String getNumcontrato() {
        return numcontrato;
    }

    public void setNumcontrato(String numcontrato) {
        this.numcontrato = numcontrato;
    }

    public String getClave_elect() {
        return clave_elect;
    }

    public void setClave_elect(String clave_elect) {
        this.clave_elect = clave_elect;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getSub_inic() {
        return sub_inic;
    }

    public void setSub_inic(BigDecimal sub_inic) {
        this.sub_inic = sub_inic;
    }

    public BigDecimal getEnganche() {
        return enganche;
    }

    public void setEnganche(BigDecimal enganche) {
        this.enganche = enganche;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getAdmon() {
        return admon;
    }

    public void setAdmon(BigDecimal admon) {
        this.admon = admon;
    }

    public BigDecimal getO_seg() {
        return o_seg;
    }

    public void setO_seg(BigDecimal o_seg) {
        this.o_seg = o_seg;
    }

    public BigDecimal getSub_inf() {
        return sub_inf;
    }

    public void setSub_inf(BigDecimal sub_inf) {
        this.sub_inf = sub_inf;
    }

    public Date getFecha_cont() {
        return fecha_cont;
    }

    public void setFecha_cont(Date fecha_cont) {
        this.fecha_cont = fecha_cont;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getMza() {
        return mza;
    }

    public void setMza(String mza) {
        this.mza = mza;
    }
    
    public String getLte() {
        return lte;
    }

    public void setLte(String lte) {
        this.lte = lte;
    }
    
    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
    
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public String getClave_cat() {
        return clave_cat;
    }

    public void setClave_cat(String clave_cat) {
        this.clave_cat = clave_cat;
    }

    public Date getFecha_ip() {
        return fecha_ip;
    }

    public void setFecha_ip(Date fecha_ip) {
        this.fecha_ip = fecha_ip;
    }
    
    
}
