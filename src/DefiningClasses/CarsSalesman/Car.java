package DefiningClasses.CarsSalesman;

public class Car {
    private String model;
    private Engine engine = new Engine();
    private Integer weight;
    private String color;

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

    public Object getWeight() {
        return this.weight != null ? this.weight : "n/a";
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {

        return this.color != null ? this.color : "n/a";
    }

    public void setColor(String color) {
        this.color = color;
    }
//<CarModel>:
//<EngineModel>:
//Power: <EnginePower>
//Displacement: <EngineDisplacement>
//Efficiency: <EngineEfficiency>
//Weight: <CarWeight>
//Color: <CarColor>
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.model).append(":").append("\n")
                .append(this.engine.getModel()).append(":").append("\n")
                .append("Power: ").append(this.engine.getPower()).append("\n")
                .append("Displacement: ").append(this.engine.getDisplacement()).append("\n")
                .append("Efficiency: ").append(this.engine.getEfficiency()).append("\n")
                .append("Weight: ").append(this.getWeight()).append("\n")
                .append("Color: ").append(this.getColor()).append("\n");

        return  output.toString();
    }
}
