package br.com.gaiatosfc.model;
// Generated 22/04/2016 14:13:13 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GolsAdv generated by hbm2java
 */
@Entity
@Table(name="gols_adv"
    ,catalog="gaiatosfc"
)
public class GolsAdv  implements java.io.Serializable {


     private int codGAdv;
     private JogadoresAdv jogadoresAdv;
     private Jogos jogos;
     private Date data;
     private String momentoGol;

    public GolsAdv() {
    }

	
    public GolsAdv(int codGAdv) {
        this.codGAdv = codGAdv;
    }
    public GolsAdv(int codGAdv, JogadoresAdv jogadoresAdv, Jogos jogos, Date data, String momentoGol) {
       this.codGAdv = codGAdv;
       this.jogadoresAdv = jogadoresAdv;
       this.jogos = jogos;
       this.data = data;
       this.momentoGol = momentoGol;
    }
   
    @Id  
    @Column(name="cod_g_adv", unique=true, nullable=false)
    public int getCodGAdv() {
        return this.codGAdv;
    }
    
    public void setCodGAdv(int codGAdv) {
        this.codGAdv = codGAdv;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_jogadoradv")
    public JogadoresAdv getJogadoresAdv() {
        return this.jogadoresAdv;
    }
    
    public void setJogadoresAdv(JogadoresAdv jogadoresAdv) {
        this.jogadoresAdv = jogadoresAdv;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_jogo")
    public Jogos getJogos() {
        return this.jogos;
    }
    
    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data", length=13)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    
    @Column(name="momento_gol", length=30)
    public String getMomentoGol() {
        return this.momentoGol;
    }
    
    public void setMomentoGol(String momentoGol) {
        this.momentoGol = momentoGol;
    }




}


