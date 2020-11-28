package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DTO;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.StringWriter;


public class SerializationJSON {

    private static DTO dto = new DTO();
    private static ObjectMapper objectMapper = new ObjectMapper();


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void serializationThroughput() throws JsonProcessingException {
        //System.out.println(objectMapper.writeValueAsString(dto));
        String res = objectMapper.writeValueAsString(dto);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void serializationAvgTime() throws JsonProcessingException {
        String res = objectMapper.writeValueAsString(dto);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SerializationJSON.class.getSimpleName())
                .threads(4)
                .warmupIterations(5)
                .measurementIterations(7)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
