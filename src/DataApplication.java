

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

public class DataApplication {
	public static void main(String[] args) {
		String m3 = "src\\model3.csv";
		String mS= 	"src\\modelS.csv";
		String mX= "src\\modelX.csv";

		



		processCarData(m3, "Model 3");
		processCarData(mS, "Model S");
		processCarData(mX, "Model X");
	}

	private static void processCarData(String filePath, String modelName) {
		List<CarData> carDataList = FileService.readFile(filePath);

		Optional<CarData> maxCarSales = carDataList.stream()
				.max(Comparator.comparingInt(CarData::getSales));
		Optional<CarData> minCarSales = carDataList.stream()
				.min(Comparator.comparingInt(CarData::getSales));


		Map<Integer, Integer> salesByYear = new HashMap<>();


		for (CarData carData : carDataList) {
			int year = carData.getDate().getYear();
			salesByYear.put(year, salesByYear.getOrDefault(year, 0) + carData.getSales());
		}


		if (maxCarSales.isPresent() && minCarSales.isPresent()) {
			CarData maxData = maxCarSales.get();
			CarData minData = minCarSales.get();

			System.out.println(modelName + " Yearly Sales Report");
			System.out.println("-------------------");


			for (Map.Entry<Integer, Integer> entry : salesByYear.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}

			System.out.println("The best month for " + modelName + " was: " + maxData.getDate());
			System.out.println("The worst month for " + modelName + " was: " + minData.getDate());
			System.out.println("");
		}
	}
}