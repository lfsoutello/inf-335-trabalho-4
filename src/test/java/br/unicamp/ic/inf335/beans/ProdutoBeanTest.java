package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author leonardomoscardo
 */
public class ProdutoBeanTest {

    private static final ProdutoBean PRODUTO_BEAN1 = new ProdutoBean();
    private static final ProdutoBean PRODUTO_BEAN2 = new ProdutoBean();
    private static final ProdutoBean PRODUTO_BEAN3 = new ProdutoBean();

    @BeforeAll
    static void fillList() {
        PRODUTO_BEAN1.setCodigo("Produto1");
        PRODUTO_BEAN1.setNome("");
        PRODUTO_BEAN1.setDescricao("");
        PRODUTO_BEAN1.setValor(1.0D);
        PRODUTO_BEAN1.setEstado("");

        PRODUTO_BEAN2.setCodigo("Produto2");
        PRODUTO_BEAN2.setNome("");
        PRODUTO_BEAN2.setDescricao("");
        PRODUTO_BEAN2.setValor(2.0D);
        PRODUTO_BEAN2.setEstado("");

        PRODUTO_BEAN3.setCodigo("Produto2");
        PRODUTO_BEAN3.setNome("");
        PRODUTO_BEAN3.setDescricao("");
        PRODUTO_BEAN3.setValor(2.0D);
        PRODUTO_BEAN3.setEstado("");
    }

    @Test
    void testCompareToValorMenor() {
        final int resultadoComparacao = PRODUTO_BEAN1.compareTo(PRODUTO_BEAN2);
        final int valorMenor = -1;
        assertEquals(valorMenor, resultadoComparacao);
    }

    @Test
    void testCompareToValorMaior() {
        final int resultadoComparacao = PRODUTO_BEAN2.compareTo(PRODUTO_BEAN1);
        final int valorMaior = 1;
        assertEquals(valorMaior, resultadoComparacao);
    }

    @Test
    void testCompareToValorIgual() {
        final int resultadoComparacao = PRODUTO_BEAN2.compareTo(PRODUTO_BEAN3);
        final int valorIgual = 0;
        assertEquals(valorIgual, resultadoComparacao);
    }

}
