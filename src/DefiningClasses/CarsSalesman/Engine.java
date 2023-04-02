package DefiningClasses.CarsSalesman;

public class Engine {
    private String model;
    private int power;
    private Integer displacement;
    private String efficiency;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Object getDisplacement() {
        return this.displacement != null ? this.displacement : "n/a";
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return this.efficiency != null ? this.efficiency : "n/a";
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
