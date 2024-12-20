

	import java.time.YearMonth;

	public class CarData {
		private YearMonth date;
		private Integer sales;
		private String model;

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}


		public Integer getSales() {
			return sales;
		}

		public void setSales(Integer sales) {
			this.sales = sales;
		}

		public CarData(YearMonth yM, int sales) {
			this.date = yM;
			this.sales = sales;
		}






		@Override
		public String toString() {
			return "CarData [Date=" + date + ", sales=" + sales + "]";
		}

		public YearMonth getDate() {
			return date;
		}

		public void setDate(YearMonth date) {
			this.date = date;
		}

}
