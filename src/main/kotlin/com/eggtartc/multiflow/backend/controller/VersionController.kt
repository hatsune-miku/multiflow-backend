package com.eggtartc.multiflow.backend.controller

import com.eggtartc.multiflow.backend.packet.ResponsePacket
import com.eggtartc.multiflow.backend.packet.VersionResponse
import com.eggtartc.multiflow.backend.service.VersionService
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersionController {
    @Resource
    lateinit var versionService: VersionService

    @GetMapping("/version")
    fun getVersion(): ResponsePacket<VersionResponse> {
        return ResponsePacket.ok(
            VersionResponse(versionService.getVersion()))
    }
}
