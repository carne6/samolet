package samolet.demo.service

import samolet.demo.dto.ResponseDTO

interface Service {

    val version: Version

    fun execute(): ResponseDTO

}