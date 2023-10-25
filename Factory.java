public class Factory {
    private String name;
    private String inputProduct;
    private String outputProduct;
    private int Price;
    private int MaxTime;
    private boolean isBuild;
    private boolean checkTime ;
    private boolean activation;
    private int time;

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public boolean isActivation() { return activation; }
    public void setActivation(boolean activation) {this.activation = activation; }
    public void setInputProduct(String o) {
        this.inputProduct = o;
    }
    public void setOutputProduct(String o) {
        this.outputProduct = o;
    }
    public void setPrice(int price) {
        Price = price;
    }
    public void setMaxTime(int maxTime) {
        MaxTime = maxTime;
    }
    public boolean isBuild() {
        return isBuild;
    }
    public boolean isCheckTime() { return checkTime; }
    public void setCheckTime(boolean checkTime) { this.checkTime = checkTime; }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getInputProduct() {
        return inputProduct;
    }
    public String getOutputProduct() {
        return outputProduct;
    }
    public int getPrice() {
        return Price;
    }
    public int getMaxTime() {
        return MaxTime;
    }
    public void setBuild(boolean a){
        this.isBuild=a;
    }

}
