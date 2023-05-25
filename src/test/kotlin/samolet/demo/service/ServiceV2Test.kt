package samolet.demo.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ServiceV2Test {

    private val serviceV2 = ServiceV2()

    @Test
    fun getVersion() {
        assertEquals(serviceV2.version, Version.V2)
    }

    @Test
    fun execute() {
        val responseDTO = serviceV2.execute()
        assertNull(responseDTO.id)
        assertEquals(responseDTO.name, "1")
    }
}