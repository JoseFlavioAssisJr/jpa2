package br.cesjf.lppo;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author José Flávio
 */
    @Entity
    
public class Livro implements Serializable{
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String titulo;
    private String autor;
    private Integer ano;

    public Livro() {
    }

    public Livro(Long id, String titulo, String autor, Integer ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
}
