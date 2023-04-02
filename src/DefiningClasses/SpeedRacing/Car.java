package DefiningClasses.SpeedRacing;

import java.text.DecimalFormat;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTravelled = 0;
    DecimalFormat formatter = new DecimalFormat("0.00");

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }

    public void setFuelCostFor1km(double fuelCostFor1km) {
        this.fuelCostFor1km = fuelCostFor1km;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public boolean canMove(int nextKilometers) {
        double neededFuel = nextKilometers * this.fuelCostFor1km;
        return neededFuel <= this.fuelAmount;
    }

    @Override
    public String toString() {
        return  model + " " + formatter.format(fuelAmount) + " " + distanceTravelled;
    }
}
