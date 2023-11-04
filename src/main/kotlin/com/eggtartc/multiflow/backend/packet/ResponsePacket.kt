package com.eggtartc.multiflow.backend.packet

data class ResponsePacket<T>(
    val data: T?,
    val success: Boolean,
    val message: String,
) {
    companion object {
        fun <T> ok(data: T?, message: String): ResponsePacket<T> {
            return ResponsePacket(data, true, message)
        }

        fun<T> ok(data: T): ResponsePacket<T> {
            return ok(data, "success")
        }

        fun <T> ok(message: String): ResponsePacket<T> {
            return ok(null, message)
        }

        fun<T> fail(message: String): ResponsePacket<T> {
            return ResponsePacket(null, false, message)
        }

        fun<T> fail(): ResponsePacket<T> {
            return fail("fail")
        }
    }
}
