public class Dr{


	public static void main(String Args[]){


		Prototype<String> p = new Prototype<String>();

		p.addLeft("one");
		p.addLeft("two");
		p.addRight("three");

		System.out.println(p.popRight());
		System.out.println(p.popLeft());
		System.out.println(p.popLeft());

	}
}