package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuarterbackController.class)

public class QuarterbackControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuarterbackRepository quarterbackRepo;

    @Mock
    private Quarterback quarterbackOne;

    @Mock
    private Quarterback quarterbackTwo;

    @Test
    public void shouldBeOkForAllQuarterbacksInQuarterbacksTemplate() throws Exception{
        mockMvc.perform(get("/quarterbacks")).andExpect(status().isOk()).andExpect(view().name("quarterbacksTemplate"));
    }

    @Test
    public void shouldFindAllQuarterbacksInModel() throws Exception {
        Collection<Quarterback> allQuarterbacksInModel = Arrays.asList(quarterbackOne,quarterbackTwo);
        when(quarterbackRepo.findAll()).thenReturn(allQuarterbacksInModel);
        mockMvc.perform(get("/quarterbacks")).andExpect(model().attribute("quarterbacksModel", allQuarterbacksInModel));
    }

    @Test
    public void shouldBeOkForOneQuarterbackInQuarterbackTemplate() throws Exception{
        Long quarterbackOneId = 1L;
        when(quarterbackRepo.findOne(quarterbackOneId)).thenReturn(quarterbackOne);
        mockMvc.perform(get("/quarterback?id=1")).andExpect(status().isOk()).andExpect(view().name("quarterbackTemplate"));
    }

    @Test
    public void shouldFindQuarterbackOneInModel() throws Exception{
        Long quarterbackOneId = 1L;
        when(quarterbackRepo.findOne(quarterbackOneId)).thenReturn(quarterbackOne);
        mockMvc.perform(get("/quarterback?id=1")).andExpect(model().attribute("quarterbackModel", quarterbackOne));
    }

    @Test
    public void shouldBeNotFound() throws Exception{
        Long quarterbackTwoId = 2L;
        when(quarterbackRepo.findOne(quarterbackTwoId)).thenReturn(quarterbackTwo);
        mockMvc.perform(get("/quarterback?id=3")).andExpect(status().isNotFound());
    }

}
