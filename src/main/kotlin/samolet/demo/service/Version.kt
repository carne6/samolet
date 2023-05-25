package samolet.demo.service

import samolet.demo.exception.WrongVersionException

enum class Version {
    V1, V2
}

fun getVersionByString(versionAsString: String): Version =
    Version.values().find { it.name == versionAsString.uppercase() } ?: throw WrongVersionException(versionAsString)
