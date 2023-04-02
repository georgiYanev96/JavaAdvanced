package DefiningClasses.RawData;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {

    private String model;

    private Engine engine;

    private Cargo cargo;

    private Map<Integer, Tyre> tyres = new LinkedHashMap<>();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Map<Integer, Tyre> getTyres() {
        return tyres;
    }

    public void setTyres(Map<Integer, Tyre> tyres) {
        this.tyres = tyres;
    }
}
