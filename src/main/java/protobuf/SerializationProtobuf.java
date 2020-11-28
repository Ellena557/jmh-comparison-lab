package protobuf;

import com.googlecode.protobuf.format.XmlFormat;
import dto.ProtoDTO;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Arrays;


public class SerializationProtobuf {

    private static ProtoDTO.UserDTO.Builder userBuilder = ProtoDTO.UserDTO.newBuilder()
            .setId(24)
            .setName("Jack")
            .setSurname("Bauer")
            .addAllLanguages(new ArrayList<String>(Arrays.asList("English", "German", "Russian", "Spanish", "Serbian", "Arabic")));

    private static ProtoDTO.BuildingDTO.Builder buildingBuilder = ProtoDTO.BuildingDTO.newBuilder()
            .setId(934)
            .setName("Hogwarts")
            .setCountry("England")
            .addAllFacultees(new ArrayList<String>(Arrays.asList("Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw")))
            .setIsGood(true)
            .setNumStudents(600);

    private static ProtoDTO.BuildingDTO buildingDTO = buildingBuilder.build();
    private static ProtoDTO.UserDTO userDTO = userBuilder.build();

    private static ProtoDTO.DTO.Builder builder = ProtoDTO.DTO.newBuilder()
            .setDate("18-11-2020")
            .setId(666)
            .setUser(userDTO)
            .setStatus("resolved")
            .setCode(55)
            .setBuilding(buildingDTO);

    private static ProtoDTO.DTO dto = builder.build();

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void serializationThroughput() {
        String res = XmlFormat.printToString(dto);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void serializationAvgTime() {
        String res = XmlFormat.printToString(dto);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SerializationProtobuf.class.getSimpleName())
                .threads(4)
                .warmupIterations(5)
                .measurementIterations(7)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
