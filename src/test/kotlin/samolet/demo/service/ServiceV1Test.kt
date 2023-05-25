package samolet.demo.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ServiceV1Test {

    private val serviceV1 = ServiceV1()

    @Test
    fun getVersion() {
        assertEquals(serviceV1.version, Version.V1)
    }

    @Test
    fun execute() {
        val responseDTO = serviceV1.execute()
        assertNull(responseDTO.name)
        assertEquals(responseDTO.id, 1)
    }
}