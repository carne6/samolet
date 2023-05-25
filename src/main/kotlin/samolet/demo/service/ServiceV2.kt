package samolet.demo.service

import org.springframework.stereotype.Component
import samolet.demo.dto.ResponseDTO

@Component
class ServiceV2 : Service {
    override val version: Version get() = Version.V2

    val responseDTO = ResponseDTO(name = "1")

    override fun execute() = responseDTO
}