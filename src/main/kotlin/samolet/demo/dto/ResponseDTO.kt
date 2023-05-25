package samolet.demo.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.*


data class ResponseDTO(
    @JsonInclude(Include.NON_NULL) val id: Int? = null,
    @JsonInclude(Include.NON_NULL) val name: String? = null
)
