package samolet.demo.service

import samolet.demo.dto.ResponseDTO
import samolet.demo.exception.NotFoundVersionServiceException

class AdapterService(private val services: Map<Version, Service>) {

    fun execute(version: Version): ResponseDTO {
        val service = services[version]?: throw NotFoundVersionServiceException(version)
        return service.execute()
    }
}