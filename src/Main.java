import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		
		
		List<Integer> list = List.of(1,1,2,3,1,289,1,55,6,77,1,289,100,5,3,1);
		//1,2,3,289,55,6,77,100,5
		
		//sum of numbers in the list
		int res = SumOfNumbers.sumofnumbers(list);
		System.out.println(res);
		
		//avg of numbers in the list
		double avg = SumOfNumbers.avgOfNumbers(list);
		System.out.println(avg);
		
		//sq, filter( > 100) and average
		double avg2 = SumOfNumbers.avgOfSquaredNumbersGt100(list);
		System.out.println(avg2);
		
		//get even numbers in the list
		List<Integer> evenList = SumOfNumbers.filterEven(list);
		System.out.println(evenList);
		
		//starts with 2
		List<Integer> startwith2 = SumOfNumbers.startsWith2(list);
		System.out.println(startwith2);
		
		//duplicate numbers in list
		List<Integer> duplicateNumbers = SumOfNumbers.duplicateNumbersInList(list);
		System.out.println(duplicateNumbers);
		
		//freq greater than 5
		List<Integer> listFreqGt5 = SumOfNumbers.freqGt5(list);
		System.out.println(listFreqGt5);
		
		//get max from the list
		int max = SumOfNumbers.getMax(list);
		System.out.println(max);
		
		//get min
		int min = SumOfNumbers.getMin(list);
		System.out.println(min);
		
		//sort the numbers in the list
		List<Integer> sortedList = SumOfNumbers.sortList(list);
		System.out.println(sortedList);
		
		//skip first 5
		List<Integer> skip5 = SumOfNumbers.skip5(list);
		System.out.println(skip5);
		
		//get first 5
		List<Integer> last5 = SumOfNumbers.last5(list);
		System.out.println(last5);
		
		//sum of first 5
		int s = SumOfNumbers.sumOfFirst5Numbers(list);
		System.out.println(s);
		
		//second highest
		int secMax = SumOfNumbers.secondMax(list);
		System.out.println(secMax);
		
		//second lowest
		int secMin = SumOfNumbers.secondMin(sortedList);
		System.out.println(secMin);
		
		
		List<Employee> empList = Arrays.asList(new Employee(1,"e1",30),
				                               new Employee(2,"e2",31),
				                               new Employee(3,"e2",30),
				                               new Employee(4,"e3",32),
				                               new Employee(5,"e3",31));
		
		Map<Integer,List<Employee>> eList =  empList.stream().collect(Collectors.groupingBy(e -> e.getAge()));
		Map<Integer,Set<Employee>> eList2 =  empList.stream().collect(Collectors.groupingBy(e -> e.getAge(),Collectors.toSet()));
		Map<Integer,Set<Employee>> eList3 =  empList.stream().collect(Collectors.groupingBy(e -> e.getAge(),TreeMap::new,Collectors.toSet()));
		System.out.println(eList);
		System.out.println(eList2);
		System.out.println(eList3);
		
		
		
		Map<Boolean,List<Employee>> eList4 = empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() >= 31));
		System.out.println(eList4);
		
		//Imagine Name is department name
		List<String> deptName =  empList.stream().map(e -> e.getName()).distinct().toList();
		System.out.println(deptName);
		
		Map<String,Long> map = empList.stream().collect(Collectors.groupingBy(e -> e.getName(),Collectors.counting()));
		System.out.println(map);
		
		//Imagine ((ID)1,(NAME)e1,(AGE)30) -> 1 is ID, e1 is dept name and 30 is the salary
		// we want to fetch average salary for every department
		Map<String,Double> map2 = empList.stream().collect(Collectors.groupingBy(e -> e.getName(),Collectors.averagingDouble(e-> e.getAge())));
		System.out.println(map2);
		
		
	}

}
