package br.unicamp.ic.inf335.beans;

import java.util.ArrayList;

/**
 * @author bonacin
 * Classe que representa um anunciante, com respectivos dados e anúncios associados
 */
public class AnuncianteBean {
    /**
     * Nome do anunciante
     */
    private String nome;
    /**
     * CFP do anuncioante
     */
    private String cpf;
    /**
     * Lista de anuncios de um anunciante
     */
    private ArrayList<AnuncioBean> anuncios;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<AnuncioBean> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(ArrayList<AnuncioBean> anuncios) {
        this.anuncios = anuncios;
    }

    /**
     * Construtor deafult
     */
    public AnuncianteBean() {
        nome = "";
        cpf = "";
        anuncios = new ArrayList<>();
    }

    /**
     * Construtor com parametros
     * @param nome
     * @param cpf
     * @param anuncios
     */
    public AnuncianteBean(String nome, String cpf, ArrayList<AnuncioBean> anuncios) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.anuncios = anuncios;
    }

    /**
     * Inclui novo anuncio na lista de anuncios de um anunciante
     * @param nAnuncio Anuncio a ser incluido
     */
    public void addAnuncio(AnuncioBean nAnuncio) {
        anuncios.add(nAnuncio);
    }

    /**
     * Inclui novo anuncio na lista de anuncios de um anunciante
     * @param i Anuncio a ser incluido
     */
    public void removeAnuncio(int i) {
        anuncios.remove(i);
    }

    /**
     * Calcula o valor medio de anuncios de um anuciante
     * @return valor medio dos anuncios
     */
    public Double valorMedioAnuncios() {
        Double soma = 0.0;
        for (AnuncioBean an : anuncios) {
            soma += an.getValor();
        }
        return soma / anuncios.size();
    }

}
