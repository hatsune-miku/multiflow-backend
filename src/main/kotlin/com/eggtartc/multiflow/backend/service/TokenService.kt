package com.eggtartc.multiflow.backend.service

import jakarta.annotation.Resource
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant


@Service
class TokenService {
    @Resource
    lateinit var encoder: JwtEncoder

    @Resource
    lateinit var decoder: JwtDecoder

    fun createToken(userId: Int): String {
        val now = Instant.now()
        val expireAt = now.plusSeconds(60 * 60 * 24 * 7)
        val claims = JwtClaimsSet.builder()
            .issuer("Multiflow")
            .issuedAt(now)
            .expiresAt(expireAt)
            .subject("Multiflow")
            .claim("name", "Multiflow")
            .claim("userId", userId.toString())
            .build()
        return encoder.encode(
            JwtEncoderParameters.from(claims)
        ).tokenValue
    }
}

fun Jwt.getUserId(): Int? {
    return this.claims["userId"]?.toString()?.toInt()
}
