
public class Marathon {

	/**
	 * @param args
	 */
	public static int fastestRunner(int[] times){
		//int min = 10000;
		int min = Integer.MAX_VALUE;
		//int index = 0;
		int index = -1;
		
		//find fastest time
		for(int i = 0; i < times.length; i++){
			if(times[i] < min){
				min = times[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static int secondFastest(int[] times){
		//int index = 0;
		int index = -1;
		//int min = 10000;
		int min = Integer.MAX_VALUE;
		int fastestIndex = fastestRunner(times);
		
		for(int i = 0; i < times.length; i++){
			//jump over fastest runner
			if(i == fastestIndex)
				continue;
			
			if(times[i] < min){
				min = times[i];
				index = i;
			}
		}
		
		/*for(; index < times.length; index++){
			if(times[index] == min){
				return index;
			}
		}
		*/
		
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {
				"Elene", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
				"Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
				"Aaron", "Kate"
		};
		
		int[] times = {
				341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
				343, 317, 265
		};
		
		/*for(int i = 0; i < names.length; i++){
			System.out.println(names[i] + ": " + times[i]);
		}
		*/
		
		System.out.println("The fastest runner is " + names[fastestRunner(times)]);
		System.out.println("The second fasest runner is " + names[secondFastest(times)]);
	}

}
