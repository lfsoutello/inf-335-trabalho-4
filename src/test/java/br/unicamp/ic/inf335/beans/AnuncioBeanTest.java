package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author leonardomoscardo
 */
public class AnuncioBeanTest {

    private static final ProdutoBean PRODUTO_BEAN1 = new ProdutoBean();

    @BeforeAll
    static void fillList() {
        PRODUTO_BEAN1.setCodigo("Produto1");
        PRODUTO_BEAN1.setNome("");
        PRODUTO_BEAN1.setDescricao("");
        PRODUTO_BEAN1.setValor(100.0D);
        PRODUTO_BEAN1.setEstado("");
    }

    @Test
    void testeGetValorSemDesconto() {
        final ArrayList<URL> fotosUrlMock = new ArrayList<>();
        final AnuncioBean anuncioBean = new AnuncioBean(PRODUTO_BEAN1, fotosUrlMock, 0.0);
        double valor = anuncioBean.getValor();
        assertEquals(100, valor);
    }

    @Test
    void testGetValorComDesconto() {
        final ArrayList<URL> fotosUrlMock = new ArrayList<>();
        final AnuncioBean anuncioBean = new AnuncioBean(PRODUTO_BEAN1, fotosUrlMock, 0.5);
        double valor = anuncioBean.getValor();
        assertEquals(50, valor);
    }

    @Test
    void testGetValorComDescontoTotal() {
        final ArrayList<URL> fotosUrlMock = new ArrayList<>();
        final AnuncioBean anuncioBean = new AnuncioBean(PRODUTO_BEAN1, fotosUrlMock, 1.0);
        double valor = anuncioBean.getValor();
        assertEquals(0, valor);
    }

    @Test
    void testGetValorComDescontoMaiorQueCem() {
        final ArrayList<URL> fotosUrlMock = new ArrayList<>();
        final AnuncioBean anuncioBean = new AnuncioBean(PRODUTO_BEAN1, fotosUrlMock, 2.0);
        assertThrows(IllegalArgumentException.class, anuncioBean::getValor);
    }

    @Test
    void testGetValorComMenorQueZero() {
        final ArrayList<URL> fotosUrlMock = new ArrayList<>();
        final AnuncioBean anuncioBean = new AnuncioBean(PRODUTO_BEAN1, fotosUrlMock, -0.5);
        assertThrows(IllegalArgumentException.class, anuncioBean::getValor);
    }


}
