package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnuncianteBeanTest {

    @Test
    public void testAddAnuncio() {
        final AnuncianteBean anuncianteBean = new AnuncianteBean();
        final AnuncioBean anuncioBean = new AnuncioBean();
        anuncianteBean.addAnuncio(anuncioBean);
        assertTrue(anuncianteBean.getAnuncios().contains(anuncioBean));
    }

    @Test
    public void testRemoveAnuncio() {
        final ArrayList<AnuncioBean> anuncioBeans = new ArrayList<>();
        final AnuncioBean anuncioBean = new AnuncioBean();
        anuncioBeans.add(anuncioBean);
        final AnuncianteBean anuncianteBean = new AnuncianteBean("João Costa", "88444420000", anuncioBeans);
        assertEquals(anuncianteBean.getAnuncios().get(0), anuncioBean);
        anuncianteBean.removeAnuncio(0);
        assertFalse(anuncianteBean.getAnuncios().contains(anuncioBean));
    }

    @Test
    public void testValorMedioAnuncioSemDesconto() {
        final ProdutoBean produtoBean1 = new ProdutoBean();
        produtoBean1.setValor(20.00D);
        final ProdutoBean produtoBean2 = new ProdutoBean();
        produtoBean2.setValor(40.00D);

        final AnuncioBean anuncioBean1 = new AnuncioBean();
        anuncioBean1.setProduto(produtoBean1);
        final AnuncioBean anuncioBean2 = new AnuncioBean();
        anuncioBean2.setProduto(produtoBean2);

        final ArrayList<AnuncioBean> anuncioBeanList = new ArrayList<>();
        anuncioBeanList.add(anuncioBean1);
        anuncioBeanList.add(anuncioBean2);

        final AnuncianteBean anuncianteBean =
                new AnuncianteBean("João Costa", "88444420000", anuncioBeanList);
        assertEquals(30.00D, anuncianteBean.valorMedioAnuncios());
    }

    @Test
    public void testValorMedioAnuncioComDesconto() {
        final ProdutoBean produtoBean1 = new ProdutoBean();
        produtoBean1.setValor(40.00D);
        final ProdutoBean produtoBean2 = new ProdutoBean();
        produtoBean2.setValor(80.00D);

        final AnuncioBean anuncioBean1 = new AnuncioBean();
        anuncioBean1.setDesconto(0.5D);
        anuncioBean1.setProduto(produtoBean1);
        final AnuncioBean anuncioBean2 = new AnuncioBean();
        anuncioBean2.setDesconto(0.5D);
        anuncioBean2.setProduto(produtoBean2);

        final ArrayList<AnuncioBean> anuncioBeanList = new ArrayList<>();
        anuncioBeanList.add(anuncioBean1);
        anuncioBeanList.add(anuncioBean2);

        final AnuncianteBean anuncianteBean =
                new AnuncianteBean("João Costa", "88444420000", anuncioBeanList);
        assertEquals(30.00D, anuncianteBean.valorMedioAnuncios());
    }

}
