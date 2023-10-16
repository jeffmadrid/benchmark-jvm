package hashing

import org.openjdk.jmh.annotations.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@State(Scope.Benchmark)
open class SynchronizedMacPerHash {

    private val hmacSha256 = "HmacSHA256"
    private val secret = "secret".toByteArray()
    private val data = "data".toByteArray()
    private val mac = Mac.getInstance(hmacSha256).apply {
        init(SecretKeySpec(secret, hmacSha256))
    }

    @Benchmark
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    fun synchronizedHash(): ByteArray {
        return hash()
    }

    @Synchronized
    fun hash(): ByteArray {
        return mac.doFinal(data)
    }
}