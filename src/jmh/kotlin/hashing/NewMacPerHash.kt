package hashing

import org.openjdk.jmh.annotations.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@State(Scope.Benchmark)
open class NewMacPerHash {

    private val hmacSha256 = "HmacSHA256"
    private val secret = "secret".toByteArray()
    private val data = "data".toByteArray()

    @Benchmark
    @Fork(value = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 1)
    fun constructMacAndHash(): ByteArray {
        val mac = Mac.getInstance(hmacSha256)
        mac.init(SecretKeySpec(secret, hmacSha256))
        return mac.doFinal(data)
    }
}