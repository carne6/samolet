package samolet.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import samolet.demo.service.Version

class NotFoundVersionServiceException(version: Version) :
    ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found service for version=$version")


class WrongVersionException(version: String) :
    ResponseStatusException(HttpStatus.BAD_REQUEST, "Version=$version is wrong")


