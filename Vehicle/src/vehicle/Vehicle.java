
package vehicle;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Normal{
    private String model;
    private String enginePower;
    private String tireSize;
    private String engineType;

    public Normal(String model, String engineType, String enginePower, String tireSize) {
        this.model = model;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public String getTireSize() {
        return tireSize;
    }

    public String getEngineType() {
        return engineType;
    }
}
class Sports extends Normal{
    private String turbo;
    public Sports(String model, String turbo, String engineType, String enginePower, String tireSize) {
        super(model, engineType, enginePower, tireSize);
        this.turbo = turbo;
    }
    
    public String getTurbo() {
        return turbo;}
}
class Heavy extends Normal{
    private String weight;

    public Heavy(String model, String weight, String engineType, String enginePower, String tireSize) {
        super(model, engineType, enginePower,tireSize);
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }
}
public class Vehicle {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Normal> Vehicles = new ArrayList<Normal>();
        int visitor = 0;
        while(s.hasNext())
        {
            String userChoice = s.next();
            if(userChoice.equalsIgnoreCase("add"))
            {
                s.nextLine();
                String input = s.nextLine();
                String[] vehicle = input.split(" ");
            // For Normal Vehicle
            //Model Number,Engine Type,Engine Power,Tire Size
            
                            if(vehicle.length==4)
       
                {
                    System.out.println("Normal");
                    Vehicles.add(new Normal(vehicle[0], vehicle[1], vehicle[2], vehicle[3]));
                }
                else
                {
            // For Sports Vehicle
            //Model Number,Model Name(turbo),Engine Type,Engine Power,Tire Size

                    if(vehicle[1].equalsIgnoreCase("turbo"))
                    {
                        System.out.println("Sports");
                        visitor=visitor+20;
                        boolean add = Vehicles.add(new Sports(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4]));
                    }

                    // For Heavy Vehicle
                    //Model Number,Weight,Engine Type,Engine Power,Tire Size
                    else
                    {
                        boolean add = Vehicles.add(new Heavy(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4]));
                    }
                }}
            else if(userChoice.equalsIgnoreCase("remove"))
            {
                if(Vehicles.size()>0)
                {
                    visitor-=20;
                    Vehicles.remove(Vehicles.size()-1);
                }
                else
                {
                    System.out.println("Empty vehicle");
                }
            }
            else if(userChoice.equalsIgnoreCase("List vehicles with details"))
            {
                for(Normal obj:Vehicles)
                {

                    if(obj instanceof Sports)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Model Name = "+((Sports) obj).getTurbo()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize());
                    }
                    else if(obj instanceof Heavy)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Weight = "+((Heavy) obj).getWeight()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize());
                    }
                    else if(obj instanceof Normal)
                    {
                        System.out.println("Model Number = "+obj.getModel()+" Engine Type = "+obj.getEngineType()+" Engine Power = "+obj.getEnginePower()+" Tire Size = "+obj.getTireSize());
                    }
                }
            }
            else if(userChoice.equalsIgnoreCase("List vehicles with details"))
            {
                for(Normal obj:Vehicles)
                {

                    if(obj instanceof Sports)
                    {
                        System.out.println("Model number = "+obj.getModel()+" Model name = "+((Sports) obj).getTurbo()+" Engine type = "+obj.getEngineType()+" Engine power = "+obj.getEnginePower()+" Tire size = "+obj.getTireSize()+" Current expected visitor = "+visitor);
                    }
                    else if(obj instanceof Heavy)
                    {
                        System.out.println("Model number = "+obj.getModel()+" Weight = "+((Heavy) obj).getWeight()+" Engine type = "+obj.getEngineType()+" Engine power = "+obj.getEnginePower()+" Tire size = "+obj.getTireSize()+" Current expected visitor = "+visitor);
                    }
                    else if(obj instanceof Normal)
                    {
                        System.out.println("Model number = "+obj.getModel()+" Engine type = "+obj.getEngineType()+" Engine power = "+obj.getEnginePower()+" Tire size = "+obj.getTireSize()+" Current expected visitor = "+visitor);
                    }
                }
            }
        }    
    }
}

