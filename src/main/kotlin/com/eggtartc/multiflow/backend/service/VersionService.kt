package com.eggtartc.multiflow.backend.service

import org.springframework.stereotype.Service


@Service
class VersionService {
    fun getVersion(): String {
        return "1.0"
    }
}
