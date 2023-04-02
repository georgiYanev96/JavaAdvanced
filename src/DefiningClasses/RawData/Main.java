package DefiningClasses.RawData;

import DefiningClasses.CompanyRoster.Department;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//You are the owner of a courier company and you want to make a system for tracking your cars and their cargo.
// Define a class Car that holds information about model, engine, cargo and a collection of exactly 4 tires.
// The engine, cargo and tire should be separate classes, create a constructor that receives all information about
// the Car and creates and initializes its inner components (engine, cargo and tires).
//On the first line of the input you will receive a number N - the number of cars you have, on each of
// the next N lines you will receive information about a car in the format
// "<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age>
// <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>" where the speed, power, weight and tire age are integers,
// tire pressure is a double.
//After the N lines you will receive a single line with one of 2 commands "fragile" or "flamable" ,
// if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1,
// if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
// The cars should be printed in order of appearing in the input.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<Car, String> cars = new LinkedHashMap<>();
        while (n > 0){
            String[] tokkens = scanner.nextLine().split(" ");
            String model = tokkens[0];

            Engine engine = new Engine();
            engine.setEngineSpeed(Integer.parseInt(tokkens[1]));
            engine.setEnginePower(Integer.parseInt(tokkens[2]));

            Cargo cargo = new Cargo();
            cargo.setWeight(Integer.parseInt(tokkens[3]));
            cargo.setType(tokkens[4]);

            Tyre tyre1 = new Tyre();
            tyre1.setPressure(Double.parseDouble(tokkens[5]));
            tyre1.setAge(Integer.parseInt(tokkens[6]));

            Tyre tyre2 = new Tyre();
            tyre2.setPressure(Double.parseDouble(tokkens[5]));
            tyre2.setAge(Integer.parseInt(tokkens[6]));

            Tyre tyre3 = new Tyre();
            tyre3.setPressure(Double.parseDouble(tokkens[5]));
            tyre3.setAge(Integer.parseInt(tokkens[6]));

            Tyre tyre4 = new Tyre();
            tyre4.setPressure(Double.parseDouble(tokkens[5]));
            tyre4.setAge(Integer.parseInt(tokkens[6]));

            Map<Integer, Tyre> tyres = new LinkedHashMap<>();
            tyres.put(1, tyre1);
            tyres.put(2, tyre2);
            tyres.put(3, tyre3);
            tyres.put(4, tyre4);

            Car car = new Car();
            car.setModel(model);
            car.setEngine(engine);
            car.setCargo(cargo);
            car.setTyres(tyres);

            cars.put(car, cargo.getType());
            n--;
        }
        String command = scanner.nextLine();

        for (Map.Entry<Car, String> entry : cars.entrySet()) {
            if(command.equals("fragile")){
                boolean toPrint = false;
                Map<Integer, Tyre> currentCarTyres = entry.getKey().getTyres();
                for (int i = 1; i < currentCarTyres.size(); i++) {
                    if(currentCarTyres.get(i).getPressure() < 1){
                        toPrint = true;
                    }
                }
                if(toPrint){
                    System.out.println(entry.getKey().getModel());
                }
            }else if(command.equals("flamable")){
                boolean toPrint = false;
                if(entry.getKey().getEngine().getEnginePower() > 250){
                    toPrint = true;
                }
                if(toPrint){
                    System.out.println(entry.getKey().getModel());
                }
            }
        }
    }

}
