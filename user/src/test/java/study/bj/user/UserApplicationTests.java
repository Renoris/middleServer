package study.bj.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import study.bj.user.controller.UserController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class UserApplicationTests {
    @Autowired
    UserController userController;

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() throws Exception {
        FileInputStream fileInputStream=new FileInputStream(new File("F:\\Desktop\\medicine.png"));
        mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockMultipartFile multipartFile=new MockMultipartFile("file","medicine.png","multipart/form-data",fileInputStream);
        MvcResult result=mockMvc.perform(
                multipart("/picture")
                .file(multipartFile))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }


}
