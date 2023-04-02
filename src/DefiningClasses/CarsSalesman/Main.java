package DefiningClasses.CarsSalesman;
//Define two classes Car and Engine. A Car has a model, engine, weight and color.
// An Engine has model, power, displacement and efficiency. A Car's weight and color and its Engine's
// displacements and efficiency are optional.
//On the first line, you will read a number N which will specify how many lines of engines you will receive,
// on each of the next N lines you will receive information about an Engine in the following format
// "<Model> <Power> <Displacement> <Efficiency>". After the lines with engines,
// on the next line you will receive a number M – specifying the number of Cars that will follow,
// on each of the next M lines the information about a Car will follow in the following format
// "<Model> <Engine> <Weight> <Color>", where the engine in the format will be the model of an existing Engine.
// When creating the object for a Car, you should keep a reference to the real engine in it,
// instead of just the engines model, note that the optional properties might be missing from the formats.
//Your task is to print each car (in the order you received them) and its information in the format defined bellow.
// If any of the optional fields has not been given print "n/a" in its place instead of:
//<CarModel>:
//<EngineModel>:
//Power: <EnginePower>
//Displacement: <EngineDisplacement>
//Efficiency: <EngineEfficiency>
//Weight: <CarWeight>
//Color: <CarColor>

import DefiningClasses.CompanyRoster.Department;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> myCars = new ArrayList<>();
        while (n > 0){
            String[] tokkens = scanner.nextLine().split(" ");
            Engine engine = new Engine();
            if(tokkens.length == 4){
                engine.setModel(tokkens[0]);
                engine.setPower(Integer.parseInt(tokkens[1]));
                engine.setDisplacement(Integer.parseInt(tokkens[2]));
                engine.setEfficiency(tokkens[3]);
            }else if(tokkens.length == 3){
                engine.setModel(tokkens[0]);
                engine.setPower(Integer.parseInt(tokkens[1]));
                if (Character.isDigit(tokkens[2].charAt(0))){
                    engine.setDisplacement(Integer.parseInt(tokkens[2]));
                }else{
                    engine.setEfficiency(tokkens[2]);
                }

            }else if(tokkens.length == 2) {
                engine.setModel(tokkens[0]);
                engine.setPower(Integer.parseInt(tokkens[1]));
            }
            engines.put(tokkens[0], engine);
            n--;
        }
        int m = Integer.parseInt(scanner.nextLine());
        while (m > 0){
            String[] tokkens = scanner.nextLine().split(" ");
            //"<Model> <Engine> <Weight> <Color>",
            Car car = new Car();
            if(tokkens.length ==4 ){
                car.setModel(tokkens[0]);
                car.setEngine(engines.get(tokkens[1]));
                car.setWeight(Integer.valueOf(tokkens[2]));
                car.setColor(tokkens[3]);
            }else if(tokkens.length == 3 ){
                car.setModel(tokkens[0]);
                car.setEngine(engines.get(tokkens[1]));
                if (Character.isDigit(tokkens[2].charAt(0))){
                    car.setWeight(Integer.valueOf(tokkens[2]));
                }else{
                    car.setColor(tokkens[2]);
                }
            }else if(tokkens.length == 2 ){
                car.setModel(tokkens[0]);
                car.setEngine(engines.get(tokkens[1]));
            }
            myCars.add(car);
            m--;
        }
        for (int i = 0; i < myCars.size(); i++) {
            System.out.println(myCars.get(i).toString());
        }
    }
}
