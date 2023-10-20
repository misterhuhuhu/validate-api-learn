package beanvalidation.application;


import beanvalidation.application.controllers.UserController;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Resource
    UserController userController;
    @Resource
    private MockMvc mockMvc;

    @Test
    public void whenUserControllerInjected_thenNotNull() throws Exception {
        Assertions.assertNotNull(userController);
    }

    @Test
    public void 当_get传输Users_then正确Response() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void 当_传输正确user_then正确Response() throws Exception {
        
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);
        String user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                                                      .content(user)
                                                      .contentType(MediaType.APPLICATION_JSON))
                                      .andExpect(MockMvcResultMatchers.status().isOk())
                                      .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
    
    @Test
    public void 当传输不正常user_thenCorrectReponse() throws Exception {
        String user = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
        MvcResult nameIsMandatory = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                                                            .content(user)
                                                            .contentType( new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8)))
//                                            .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                                            .andExpect(MockMvcResultMatchers.jsonPath("$.name", IsNot.not(Strings.EMPTY)))
//                                            .andExpect(MockMvcResultMatchers.content().contentType(new MediaType(MediaType.APPLICATION_JSON)))
                                            .andReturn();
        System.err.println(nameIsMandatory.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
