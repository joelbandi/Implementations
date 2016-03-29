public class Stringlearn{

	public static void main(String[] args){

		String joel = "This is a test string. Use it wisely.";
		char[] bandi = {'R','2','D','2','.',};
		System.out.println("\n");

		//to char array and iterating throught a string
		System.out.println("using a for loop to iterate through a char array");
		char[] arr = joel.toCharArray();
		for(int i =0; i<arr.length;i++){

			System.out.print(arr[i]);
		}
		System.out.println("\n");
		


		//to concatenate strings use this function
		System.out.print("concatenate strings using concat");
		String one = joel;
		one = one.concat(" I used it wisely.");
		System.out.println(one);
		System.out.print("\n");


		//compareTo method to lexicographically compare two strings : compareToIgnoreCase,
		String aone = "aca";
		String atwo = "aab";
		int res = aone.compareTo(atwo);
		System.out.println("the comparison result : "+res);



		// .equals() , .equalsIgnoreCase(), .contentEquals(StringBuffer sb),

		// .endsWith(String suffix);

		// .getBytes(String charsetName);  which returns a byte array in java -- byte[] ,charsetName = "UTF-8" or "ISO-8859-1"

		// .hashCode() returns an integer has code if this string inputted to this method 

		// .indexOf(char ch) returns the index of the first occurence of char ch  .lastIndexOf(char ch) returns the last index

		// .matches(String regex) gives out a boolean if it does

		// .replace(char oldChar , char newChar);

		// .replaceAll(String regex, String replacement);

		// String[]	split(String regex) plits a string around the reger pattern and returns a string array

		// .toCharArray() , .toLowerCase() , .toUpperCase();



	}
}