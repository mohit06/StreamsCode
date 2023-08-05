import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class SumOfNumbers {
	
	public static int sumofnumbers(List<Integer> list) {	
		Optional<Integer> result ;
		result = list.stream().reduce((a,b)->a+b);
		return result.get();	
	}
	
	public static double avgOfNumbers(List<Integer> list) {
		return list.stream().mapToInt(e -> e).average().getAsDouble();
	}
	
	public static double avgOfSquaredNumbersGt100(List<Integer> list) {
		return list.stream()
				.map(e -> e*e)
				.filter(e -> e > 100)
				.mapToInt(e -> e)
				.average()
				.getAsDouble();
	}
	
	public static List<Integer> filterEven(List<Integer> list){
		return list.stream().filter(e -> e % 2 == 0).toList();
	}

	public static List<Integer> startsWith2(List<Integer> list){
		return list.stream()
				.map(e -> e+"")
				.filter(e -> e.startsWith("2"))
				.map(Integer::parseInt)
				.toList();
	}
	
	public static List<Integer> duplicateNumbersInList(List<Integer> list){
		HashSet<Integer> set = new HashSet<Integer>();
		return list.stream().filter(e -> !set.add(e)).toList();
	}
	
	public static List<Integer> freqGt5(List<Integer> list){
		return list.stream().filter(e -> Collections.frequency(list, e) > 5).distinct().toList();
	}
	
	public static Integer getMax(List<Integer> list){
		return list.stream().max(Comparator.comparing(Integer::valueOf)).get();
	}
	
	public static Integer getMin(List<Integer> list){
		return list.stream().min(Comparator.comparing(Integer::valueOf)).get();
	}
	
	public static List<Integer> sortList(List<Integer> list){
		return list.stream().sorted().toList();
	}
	
	public static List<Integer> sortListDescendingOrder(List<Integer> list){
		return list.stream().sorted(Collections.reverseOrder()).toList();
	}
	
	public static List<Integer> skip5(List<Integer> list){
		return list.stream().skip(5).toList();
	}
	
	public static List<Integer> last5(List<Integer> list){
		return list.stream().limit(5).toList();
	}
	
	public static int sumOfFirst5Numbers(List<Integer> list) {
		return list.stream().limit(5).reduce((a,b) -> (a+b)).get();
	}
	
	public static int secondMin(List<Integer> list) {
		return list.stream()
				.distinct()
				.sorted()
				.limit(2)
				.skip(1)
				//.reduce(0, (a,b) -> a+b);
				.findFirst().get();
	} 
	
	public static int secondMax(List<Integer> list) {
		return list.stream()
				.distinct()
				.sorted(Collections.reverseOrder())
				.limit(2)
				.skip(1)
				.reduce(0, (a,b) -> a+b);
	} 
	
	
	
}
