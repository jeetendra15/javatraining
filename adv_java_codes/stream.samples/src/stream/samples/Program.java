package stream.samples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = numbers.stream().filter(n -> n % 2 == 0);
		List<Integer> evenNumbers = stream.collect(Collectors.toList());
		
		System.out.println(evenNumbers);
		
		
		List<String> names = Arrays.asList("India, Jeetendra, Chunnu, CHOTU");
		Stream<String> stream2 = names.stream()
				.map(n->n.toLowerCase());
		
		List<String> length = stream2.collect(Collectors.toList());
				
					
					
		System.out.println(length);
		
	}

}
