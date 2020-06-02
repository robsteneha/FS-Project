
public class PracticeFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String format = "%1$-10s%2$-10s%3$-20s\n";
		    System.out.format(format, "A", "AA", "AAA");
		    System.out.format(format, "B", "B", "BBBBB");
		    System.out.format(format, "C", "CCCCC", "CCCCCCCC");

		    //String ex[] = { "E", "EEEEEEEEEE", "E" };

		    //System.out.format(String.format(format, (Object[]) ex));

	}

}
