package com.project.pizza;

import com.project.pizza.application.UserAppService;
import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.entity.Address;
import com.project.pizza.domain.entity.Name;
import com.project.pizza.domain.entity.Password;
import com.project.pizza.domain.entity.Role;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

        @Autowired
        private MockMvc mvc;
        @Autowired
        private UserAppService userAppService;


        @Test
        public void login_test() throws Exception {
        mvc.perform(post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"email\":\"email\",\n" +
                        "    \"firstname\":\"bilal\",\n" +
                        "    \"lastname\":\"taghda\",\n" +
                        "    \"role\":\"CUSTOMER\",\n" +
                        "    \"longitude\":10.0,\n" +
                        "    \"latitude\":10.0,\n" +
                        "    \"psw\":\"P1sw\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());

    }

        @Test
        public void get_details_test() throws Exception {
            User user = new User("email", new Name("",""), Role.CUSTOMER
                    , new Address(0l, 0l),new Password("Psw123"));

            Authentication authentication = Mockito.mock(Authentication.class);
            SecurityContext securityContext = Mockito.mock(SecurityContext.class);
            Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
            SecurityContextHolder.setContext(securityContext);
            Mockito.when(authentication.getPrincipal()).thenReturn(user);
            Mockito.when(userAppService.getUserDetails()).thenReturn(user);

            mvc.perform(get("/api/user/details"))
                    .andDo(print())
                    .andExpect(jsonPath("$.role").value("CUSTOMER"))
                    .andExpect(status().isOk());

        }


}
