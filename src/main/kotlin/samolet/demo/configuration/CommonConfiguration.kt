package samolet.demo.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import samolet.demo.service.AdapterService
import samolet.demo.service.Service

@Configuration
class CommonConfiguration {

    @Bean
    fun adapterService(services: List<Service>): AdapterService {
        val versionServiceMap = services.associateBy { it.version }
        if (versionServiceMap.size != services.size)
            throw RuntimeException("has more than one implementation service of version")
        return AdapterService(versionServiceMap)
    }

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("demo-public-api")
            .pathsToMatch("/samolet/demo/**")
            .displayName("demo-public-api")
            .build()
    }
}