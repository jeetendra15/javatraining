package stream.samples;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FileStreamTests {

	String filePath = "./src/file.txt";

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void countNumbers() throws IOException {
//
//		Stream<String> numbers = Files.lines(Paths.get(filePath));
//		long length = numbers.count();
//		System.out.println(length);
//	}

	@Test
	public void getEvenNumbers() throws IOException {

		Stream<String> numbers = Files.lines(Paths.get(filePath));

		List<String> num = numbers.filter(n -> (Integer.parseInt(n)) % 2 == 0)
							.collect(Collectors.toList());

		System.out.println(num);
	}

	
	

	@Sample
	@Test
	public void getPaths() throws IOException {

		Files.list(Paths.get(".")).forEach(System.out::println);
	}

}
