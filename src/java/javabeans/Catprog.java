/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javabeans;

import java.math.BigDecimal;



/**
 *
 * @author Rafael Mendez
 */
public class Catprog 
{
   
    public Catprog(){}
    
    
    
     public Catprog (Integer id_Catprog,String clave,String descripcion, Integer mecanica, BigDecimal sub_ini, BigDecimal eng_fon, BigDecimal eng_inv, BigDecimal interes, BigDecimal admon, BigDecimal seguro, BigDecimal costo_m2, BigDecimal por_sub, BigDecimal por_admon, BigDecimal por_sv, BigDecimal sub_bp, BigDecimal por_os, BigDecimal sal_min, BigDecimal pago_mes, BigDecimal por_eng, Integer id_del, Integer id_colonia, BigDecimal anual, Integer plazo, Integer status, BigDecimal por_cap) {
        this.id_Catprog = id_Catprog;
        this.clave = clave;
        this.descripcion = descripcion;
        this.mecanica = mecanica;
        this.sub_ini = sub_ini;
        this.eng_fon = eng_fon;
        this.eng_inv = eng_inv;
        this.interes = interes;
        this.admon = admon;
        this.seguro = seguro;
        this.costo_m2 = costo_m2;
        this.por_sub = por_sub;
        this.por_admon = por_admon;
        this.por_sv = por_sv;
        this.sub_bp = sub_bp;
        this.por_os = por_os;
        this.sal_min = sal_min;
        this.pago_mes = pago_mes;
        this.por_eng = por_eng;
        this.id_del = id_del;
        this.id_colonia = id_colonia;
        this.anual = anual;
        this.plazo = plazo;
        this.status = status;
        this.por_cap = por_cap;
        
        

        
    }
    
     
    public Catprog (Integer id_Catprog,String clave,String descripcion, Integer mecanica, BigDecimal sub_ini, BigDecimal eng_fon, BigDecimal eng_inv, BigDecimal interes, BigDecimal admon, BigDecimal seguro, BigDecimal costo_m2, BigDecimal por_sub, BigDecimal por_admon, BigDecimal por_sv, BigDecimal sub_bp, BigDecimal por_os, BigDecimal sal_min, BigDecimal pago_mes, BigDecimal por_eng, String delegacion, String colonia, BigDecimal anual, Integer plazo, Integer status, BigDecimal por_cap) {
        this.id_Catprog = id_Catprog;
        this.clave = clave;
        this.descripcion = descripcion;
        this.mecanica = mecanica;
        this.sub_ini = sub_ini;
        this.eng_fon = eng_fon;
        this.eng_inv = eng_inv;
        this.interes = interes;
        this.admon = admon;
        this.seguro = seguro;
        this.costo_m2 = costo_m2;
        this.por_sub = por_sub;
        this.por_admon = por_admon;
        this.por_sv = por_sv;
        this.sub_bp = sub_bp;
        this.por_os = por_os;
        this.sal_min = sal_min;
        this.pago_mes = pago_mes;
        this.por_eng = por_eng;
        this.delegacion = delegacion;
        this.colonia = colonia;
        this.anual = anual;
        this.plazo = plazo;
        this.status = status;
        this.por_cap = por_cap;
        
    } 
    
     
    public Catprog (Integer id_Catprog,String clave,String descripcion, Integer mecanica, BigDecimal sub_ini, BigDecimal eng_fon, BigDecimal eng_inv, BigDecimal interes, BigDecimal admon, BigDecimal seguro, BigDecimal costo_m2, BigDecimal por_sub, BigDecimal por_admon, BigDecimal por_sv, BigDecimal sub_bp, BigDecimal por_os, BigDecimal sal_min, BigDecimal pago_mes, BigDecimal por_eng,Integer id_del, Integer id_colonia, String delegacion, String colonia, BigDecimal anual, Integer plazo, Integer status, BigDecimal por_cap) {
        this.id_Catprog = id_Catprog;
        this.clave = clave;
        this.descripcion = descripcion;
        this.mecanica = mecanica;
        this.sub_ini = sub_ini;
        this.eng_fon = eng_fon;
        this.eng_inv = eng_inv;
        this.interes = interes;
        this.admon = admon;
        this.seguro = seguro;
        this.costo_m2 = costo_m2;
        this.por_sub = por_sub;
        this.por_admon = por_admon;
        this.por_sv = por_sv;
        this.sub_bp = sub_bp;
        this.por_os = por_os;
        this.sal_min = sal_min;
        this.pago_mes = pago_mes;
        this.por_eng = por_eng;
        this.id_del = id_del;
        this.id_colonia = id_colonia;
        this.delegacion = delegacion;
        this.colonia = colonia;
        this.anual = anual;
        this.plazo = plazo;
        this.status = status;
        this.por_cap = por_cap;
        
    } 
    
       
    private Integer id_Catprog;
    private String clave;
    private String descripcion;
    private Integer mecanica;
    private BigDecimal sub_ini;
    private BigDecimal eng_fon;
    private BigDecimal eng_inv;
    private BigDecimal interes;
    private BigDecimal admon;
    private BigDecimal seguro;
    private BigDecimal costo_m2;
    private BigDecimal por_sub;
    private BigDecimal por_admon;
    private BigDecimal por_sv;
    private BigDecimal sub_bp;
    private BigDecimal por_os;
    private BigDecimal sal_min;
    private BigDecimal pago_mes;
    private BigDecimal por_eng;
    private Integer id_del;
    private String delegacion;
    private Integer id_colonia;
    private String colonia;
    private BigDecimal anual;
    private Integer plazo;
    private BigDecimal por_cap;
    private Integer status;
    

        
    
    


    public Integer getId_Catprog() {        
        return id_Catprog;
    }

    public void setId_Catprog(Integer id_Catprog) {
        this.id_Catprog = id_Catprog;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Integer getMecanica() {
        return mecanica;
    }

    public void setMecanica(Integer mecanica) {
        this.mecanica = mecanica;
    }

    public BigDecimal getSub_ini() {
        return sub_ini;
    }

    public void setSub_ini(BigDecimal sub_ini) {
        this.sub_ini = sub_ini;
    }
    
    public BigDecimal getEng_fon() {
        return eng_fon;
    }

    public void setEng_fon(BigDecimal eng_fon) {
        this.eng_fon = eng_fon;
    }

    public BigDecimal getEng_inv() {
        return eng_inv;
    }

    public void setEng_inv(BigDecimal eng_inv) {
        this.eng_inv = eng_inv;
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
    
    public BigDecimal getSeguro() {
        return seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    public BigDecimal getCosto_m2() {
        return costo_m2;
    }

    public void setCosto_m2(BigDecimal costo_m2) {
        this.costo_m2 = costo_m2;
    }

    public BigDecimal getPor_sub() {
        return por_sub;
    }

    public void setPor_sub(BigDecimal por_sub) {
        this.por_sub = por_sub;
    }

    public BigDecimal getPor_admon() {
        return por_admon;
    }

    public void setPor_admon(BigDecimal por_admon) {
        this.por_admon = por_admon;
    }
    
    public BigDecimal getPor_sv() {
        return por_sv;
    }

    public void setPor_sv(BigDecimal por_sv) {
        this.por_sv = por_sv;
    }
    
    public BigDecimal getSub_bp() {
        return sub_bp;
    }

    public void setSub_bp(BigDecimal sub_bp) {
        this.sub_bp = sub_bp;
    }
    
    public BigDecimal getPor_os() {
        return por_os;
    }

    public void setPor_os(BigDecimal por_os) {
        this.por_os = por_os;
    }
    
    public BigDecimal getSal_min() {
        return sal_min;
    }

    public void setSal_min(BigDecimal sal_min) {
        this.sal_min = sal_min;
    }
    
    public BigDecimal getPago_mes() {
        return pago_mes;
    }

    public void setPago_mes(BigDecimal pago_mes) {
        this.pago_mes = pago_mes;
    }
    
    public BigDecimal getPor_eng() {
        return por_eng;
    }

    public void setPor_eng(BigDecimal por_eng) {
        this.por_eng = por_eng;
    }
    
    public Integer getId_del() {
        return id_del;
    }

    public void setId_del(Integer id_del) {
        this.id_del = id_del;
    }
    
    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }
    
    public Integer getId_colonia() {
        return id_colonia;
    }

    public void setId_colonia(Integer id_colonia) {
        this.id_colonia = id_colonia;
    }
    
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    public BigDecimal getAnual() {
        return anual;
    }

    public void setAnual(BigDecimal anual) {
        this.anual = anual;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public BigDecimal getPor_cap() {
        return por_cap;
    }

    public void setPor_cap(BigDecimal por_cap) {
        this.por_cap = por_cap;
    }
        
        
}