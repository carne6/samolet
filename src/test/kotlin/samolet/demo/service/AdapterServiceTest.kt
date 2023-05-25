package samolet.demo.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import samolet.demo.exception.NotFoundVersionServiceException

class AdapterServiceTest {

    private val adapterService = AdapterService(mapOf(Version.V1 to ServiceV1()))

    @Test
    fun execute() {
        val responseDTO = adapterService.execute(Version.V1)
        assertEquals(responseDTO.id, 1)
        assertNull(responseDTO.name)
    }

    @Test
    fun `throw exception when service not found by version`() {
        assertThrows(NotFoundVersionServiceException::class.java) {
            adapterService.execute(Version.V2)
        }
    }
}