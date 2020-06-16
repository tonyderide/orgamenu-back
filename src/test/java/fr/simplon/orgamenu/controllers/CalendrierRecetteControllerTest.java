package fr.simplon.orgamenu.controllers;

import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.services.CalendrierRecetteService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalendrierRecetteControllerTest extends TestCase {

    @MockBean
    CalendrierRecetteService calendrierRecetteService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        when(calendrierRecetteService.findAll()).thenReturn(null);
        ResultActions response = this.mockMvc.perform(get("/api/calendrierrecettes/"));
        response.andExpect(status().isOk());
    }
}
