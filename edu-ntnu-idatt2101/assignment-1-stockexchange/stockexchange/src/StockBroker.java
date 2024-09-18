import java.util.Random;

public class StockBroker {


  //int[] randomDataset = new int[10];

  int buyDay = 0;
  int sellDay = 0;
  int maxProfit = 0;

  public int[] generateDataset(int[] randomDataset) {
    Random random = new Random();
    for (int i = 0; i < randomDataset.length; i++) {
      randomDataset[i] = random.nextInt(41) - 20;
    }
    return randomDataset;
  }

  public String writeDataset(int[] dataset) {
    StringBuilder datasetString = new StringBuilder();
    for (int j : dataset) {
      datasetString.append(j).append(" ");
    }
    return datasetString.toString();
  }

  public void maxProfit(int[] dataset) {

    for (int i = 0; i < dataset.length; i++) {
      int currentProfit = 0;

      for (int j = i + 1; j < dataset.length; j++) {
        currentProfit += dataset[j];

        if (currentProfit > maxProfit) {
          maxProfit = currentProfit;
          buyDay = i + 1;
          sellDay = j + 1;
        }
      }
    }
  }

  public int getBuyDay() {
    return buyDay;
  }

  public int getSellDay() {
    return sellDay;
  }

  public int getMaxProfit() {
    return maxProfit;
  }
}
