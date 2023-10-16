# benchmark-jvm

Project to benchmark "unit level" code to find the optimal implementation for your needs.

# Get started

```shell
./gradlew jmh
```
The default JMH settings are applied, please refer to [build.gradle.kts](build.gradle.kts) file.

# Examples

## Hashing

- [NewMacPerHash](src/jmh/kotlin/hashing/NewMacPerHash.kt): instantiate a new Mac per hash
- [SynchronizedHash](src/jmh/kotlin/hashing/SynchronizedHash.kt): synchronize hash method to be thread-safe

### Results

```shell
$ cat ./build/reports/jmh/results.txt 
Benchmark                           Mode  Cnt        Score   Error  Units
NewMacPerHash.constructMacAndHash  thrpt       2501776.378          ops/s     results/                  tmp/                                              
SynchronizedHash.synchronizedHash  thrpt       5428251.686          ops/s
```

# Machine specs

- Processor: AMD® Ryzen 7 5800u 
- OS: Ubuntu 22.04.3
- OS Type: 64-bit
