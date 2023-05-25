package samolet.demo.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import samolet.demo.dto.ResponseDTO

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `get response dto by version v1`() {
        val response = mockMvc.perform(get("/samolet/demo/V1"))
            .andExpect(status().isOk).andReturn().response
        val responseDTO = objectMapper.readValue<ResponseDTO>(response.contentAsString)
        assertEquals(responseDTO.id, 1)
        assertNull(responseDTO.name)
    }

    @Test
    fun `get response dto by version v2`() {
        val response = mockMvc.perform(get("/samolet/demo/V2"))
            .andExpect(status().isOk).andReturn().response
        val responseDTO = objectMapper.readValue<ResponseDTO>(response.contentAsString)
        assertEquals(responseDTO.name, "1")
        assertNull(responseDTO.id)
    }

    @Test
    fun `return 400 status when version is wrong`() {
        mockMvc.perform(get("/samolet/demo/v3"))
            .andExpect(status().isBadRequest)

    }
}