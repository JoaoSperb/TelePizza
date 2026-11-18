
package com.bcopstein.ex4_lancheriaddd_v1;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:pizzadb_uc5_test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"
})
@AutoConfigureMockMvc
class CardapioControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCarregarCardapioCorrenteComProdutosEIndicacaoDoChef() throws Exception {
        mockMvc.perform(get("/cardapio/corrente"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.titulo").value("Cardapio de Agosto"))
                .andExpect(jsonPath("$.itens", hasSize(3)))
                .andExpect(jsonPath("$.itens[*].descricao",
                        hasItem("Pizza queijo e presunto")))
                .andExpect(jsonPath(
                        "$.itens[?(@.descricao == 'Pizza queijo e presunto')].indicacao",
                        hasItem(true)));
    }

    @Test
    void deveContinuarCarregandoCardapioPorId() throws Exception {
        mockMvc.perform(get("/cardapio/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Cardapio de Agosto"))
                .andExpect(jsonPath("$.itens", hasSize(3)));
    }
}
