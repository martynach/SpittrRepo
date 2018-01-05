package spittr.web;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spittr.Spitter;
import spittr.data.ISpitterRepository;
import spittr.data.MockedSpitterRepository;

public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        ISpitterRepository spitterRepository = Mockito.mock(ISpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Mockito.when(spitterRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(spitterRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/spittr/spitter/register")
                .param("firstname", "Jack")
                .param("lastname", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spittr/spitter/jbauer"));

        Mockito.verify(spitterRepository, Mockito.atLeastOnce()).save(unsaved);

    }

    @Test
    public void shouldShowRegistration() throws Exception {
        ISpitterRepository spitterRepository = Mockito.mock(ISpitterRepository.class);

        SpitterController controller = new SpitterController(spitterRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittr/spitter/register")).andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void showUserProfileTest() throws Exception {
        ISpitterRepository repository = Mockito.mock(ISpitterRepository.class);
        Spitter expected = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        Mockito.when(repository.findByUsername("jbauer")).thenReturn(expected);
        SpitterController controller = new SpitterController(repository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittr/spitter/jbauer"))
                .andExpect(MockMvcResultMatchers.view().name("profile"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spitter"))
                .andExpect(MockMvcResultMatchers.model().attribute("spitter", expected));
    }

    @Test
    public void testSetTest() {
        MockedSpitterRepository.hashSetTest();
    }

    @Test
    public void testMapTest() {
        MockedSpitterRepository.hashMapTest();
    }
}
