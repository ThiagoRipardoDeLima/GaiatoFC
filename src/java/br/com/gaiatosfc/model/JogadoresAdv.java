package br.com.gaiatosfc.model;
// Generated 22/04/2016 14:13:13 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JogadoresAdv generated by hbm2java
 */
@Entity
@Table(name="jogadores_adv"
    ,schema="public"
)
public class JogadoresAdv  implements java.io.Serializable {


     private int codJdAdv;
     private String nome;
     private String posicao;
     private Integer codTime;
     private Set golsAdvs = new HashSet(0);
     private Set adversarioses = new HashSet(0);

    public JogadoresAdv() {
    }

	
    public JogadoresAdv(int codJdAdv) {
        this.codJdAdv = codJdAdv;
    }
    public JogadoresAdv(int codJdAdv, String nome, String posicao, Integer codTime, Set golsAdvs, Set adversarioses) {
       this.codJdAdv = codJdAdv;
       this.nome = nome;
       this.posicao = posicao;
       this.codTime = codTime;
       this.golsAdvs = golsAdvs;
       this.adversarioses = adversarioses;
    }
   
     @Id 

    
    @Column(name="cod_jd_adv", unique=true, nullable=false)
    public int getCodJdAdv() {
        return this.codJdAdv;
    }
    
    public void setCodJdAdv(int codJdAdv) {
        this.codJdAdv = codJdAdv;
    }

    
    @Column(name="nome", length=40)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="posicao", length=30)
    public String getPosicao() {
        return this.posicao;
    }
    
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    
    @Column(name="cod_time")
    public Integer getCodTime() {
        return this.codTime;
    }
    
    public void setCodTime(Integer codTime) {
        this.codTime = codTime;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="jogadoresAdv")
    public Set getGolsAdvs() {
        return this.golsAdvs;
    }
    
    public void setGolsAdvs(Set golsAdvs) {
        this.golsAdvs = golsAdvs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="jogadoresAdv")
    public Set getAdversarioses() {
        return this.adversarioses;
    }
    
    public void setAdversarioses(Set adversarioses) {
        this.adversarioses = adversarioses;
    }




}

