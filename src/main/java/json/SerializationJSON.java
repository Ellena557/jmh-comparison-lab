package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DTO;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializationJSON {

    private static DTO dto = new DTO();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static byte[] dataSerialize;

    static {
        try {
            String path = "C:/Users/Elena/Desktop/Оптимизация программ/lab_jmh/src/main/java/data/dto.json";
            dataSerialize = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void serializationThroughput() throws IOException {
        DTO res = objectMapper.readValue(dataSerialize, DTO.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void serializationAvgTime() throws IOException {
        DTO res = objectMapper.readValue(dataSerialize, DTO.class);
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
