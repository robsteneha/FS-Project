import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class FileHandlerImplementation {
	
	private String fileName;
	TreeMap<Long,LineContents> linesMap;
	
	public FileHandlerImplementation(String fileName)
	{
		this.fileName = fileName;
	}
	
	//opens the file and initializes the hashmap
	public void initialize()
	{
		/*File file = new File("D:\\4ISE1JAVA\\File structures project\\src\\"+this.fileName);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		linesMap = new TreeMap<>();
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get("D:\\4ISE1JAVA\\File structures project\\src\\"+this.fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lines!=null)
		{
			lines.forEach(line -> {
				  // Do anything line by line 
				String[] p = line.split(" ");
				String countryName = p[0];
				Long phoneNumber = Long.parseLong(p[1]);
				String name = p[2];
				linesMap.put(phoneNumber, new LineContents(countryName,name));
				});
		}
	}

	public TreeMap<Long, LineContents> getAllLines() {
		// TODO Auto-generated method stub
		return this.linesMap;
	}
	
	

}
