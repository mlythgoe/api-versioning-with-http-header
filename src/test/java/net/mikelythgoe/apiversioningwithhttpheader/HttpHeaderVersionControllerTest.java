package net.mikelythgoe.apiversioningwithhttpheader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HttpHeaderVersionController.class)
class HttpHeaderVersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String VERSION_HEADER = "X-API-Version";

    @Test
    void helloV1_ShouldReturnVersion1() throws Exception {
        mockMvc.perform(get("/hello")
                .header(VERSION_HEADER, "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 1"));
    }

    @Test
    void helloV2_ShouldReturnVersion2() throws Exception {
        mockMvc.perform(get("/hello")
                .header(VERSION_HEADER, "2.0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 2"));
    }

    @Test
    void helloV3point5_ShouldReturnVersion3point5() throws Exception {
        mockMvc.perform(get("/hello")
                .header(VERSION_HEADER, "3.5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 3.5"));
    }

    @Test
    void helloV9_ShouldReturnVersion9() throws Exception {
        mockMvc.perform(get("/hello")
                .header(VERSION_HEADER, "9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 9"));
    }

    @Test
    void helloV9point9_ShouldReturnVersion9point9() throws Exception {
        mockMvc.perform(get("/hello")
                .header(VERSION_HEADER, "9.9")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 9.9"));
    }

    @Test
    void hello_WithInvalidVersion_ShouldReturnBadRequest() throws Exception {
        // Invalid Version should return Bad Request
        mockMvc.perform(get("/hello")
                .header(VERSION_HEADER, "99999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void hello_WithoutHeader_ShouldReturnBadRequest() throws Exception {
        // No Version should return Bad Request
        mockMvc.perform(get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
