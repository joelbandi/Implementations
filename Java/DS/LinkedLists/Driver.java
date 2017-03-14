public class Driver{

	public static void main(String[] args){

		Node mylist = new Node();
		System.out.println(mylist.isEmpty());
		mylist.append(4);
		mylist.append(5);
		mylist.append(6);
		mylist.append(7);
		mylist.printem();
		System.out.println("--");
		mylist.printem();
		System.out.println("--");
		mylist.remove(7);
		mylist.remove(6);
		mylist.printem();
		System.out.println(mylist.isEmpty());


	}
}