package spittr.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.ISpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;

public class SpittleControllerTest {

    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("I'am new spittle", new Date());
        ISpittleRepository repository = Mockito.mock(ISpittleRepository.class);
        Mockito.when(repository.findOne(123)).thenReturn(expectedSpittle);
        SpittleController controller = new SpittleController(repository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittr/spittles/123"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));

    }


    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        ISpittleRepository spittleRepository = mock(ISpittleRepository.class);
        Mockito.when(spittleRepository.findSpittles(23456, 50)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(spittleRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("views/spittles.jsp")).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittr/spittles?max=23456&count=50"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittleList", expectedSpittles));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        ISpittleRepository spittleRepository = mock(ISpittleRepository.class);
        Mockito.when(spittleRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(spittleRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("views/spitlles.jsp")).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittr//spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"));
        // .andExpect(MockMvcResultMatchers.model().attribute("spittleList", hasItems(expectedSpittles.toArray())));



    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
