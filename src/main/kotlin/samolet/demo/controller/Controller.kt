package samolet.demo.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import samolet.demo.dto.ResponseDTO
import samolet.demo.service.AdapterService
import samolet.demo.service.getVersionByString

@RestController
@RequestMapping("samolet/demo")
class Controller(private val adapterService: AdapterService) {

    @Operation(description = "Получить список редактируемых справочников")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad request"),
    )
    @GetMapping("/{version}")
    fun calls(@PathVariable version: String): ResponseEntity<ResponseDTO> {
        return ResponseEntity.ok(
            adapterService.execute(getVersionByString(version))
        )
    }
}