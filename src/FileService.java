import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileService {
	public static List<CarData> readFile(String filePath) {
		List<CarData> csvData = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String line;
		try {
			reader.readLine();
			while((line = reader.readLine()) != null) {

				String[] columns = line.split(",");
				YearMonth yM = YearMonth.parse(columns[0],DateTimeFormatter.ofPattern("MMM-yy"));
				CarData data = new CarData(yM, Integer.parseInt(columns[1]));
				csvData.add(data);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}




		return csvData;

	}
}
