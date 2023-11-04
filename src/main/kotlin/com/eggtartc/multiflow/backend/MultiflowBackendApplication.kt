package com.eggtartc.multiflow.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MultiflowBackendApplication

fun main(args: Array<String>) {
    runApplication<MultiflowBackendApplication>(*args)
}
