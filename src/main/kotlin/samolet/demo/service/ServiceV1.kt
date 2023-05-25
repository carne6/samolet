package samolet.demo.service

import org.springframework.stereotype.Component
import samolet.demo.dto.ResponseDTO

@Component
class ServiceV1 : Service {
    override val version: Version get() = Version.V1

    val responseDTO = ResponseDTO(1)

    override fun execute() = responseDTO
}