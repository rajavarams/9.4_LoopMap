package com.tts;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Cars {
    public static void inventory(HashMap<String,Integer> cars) {
        for(String i: cars.keySet()){
            System.out.println("Model: "+i+"\tcounts: \n"+cars.get(i));
        }
    }
    public static void inventoryByBrand(HashMap<String,Integer> cars,String carBrand) {
        int sum=0;
        for(String i: cars.keySet()){
            String[] brand=i.split("/");
            if(brand[0].equalsIgnoreCase(carBrand)){
                sum+=cars.get(i);
            }
        }
        System.out.printf("You have %d  %s cars\n",sum,carBrand);
    }
    public static void inventoryByModel(HashMap<String,Integer> cars,String carModel) {
        for(String i: cars.keySet()){
            String[] model=i.split("/");
            if(model[1].equalsIgnoreCase(carModel)){
                System.out.printf("You have %d  %s %s cars\n",cars.get(i),model[0].toUpperCase(),model[1].toUpperCase());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String   buyInput;
        boolean search=true;
        boolean keepGoing=true;
        HashMap<String,Integer> cars=new HashMap<>();
        cars.put("Honda/Odyssey",1);
        cars.put("Honda/Civic",3);
        cars.put("Hyundai/Tucson",1);
        cars.put("Hyundai/Kona",0);
        inventoryByBrand(cars,"honda");
        inventoryByModel(cars,"civic");
        while (keepGoing){
            System.out.println("Are you employee? Yes/No");
            buyInput=scanner.nextLine();
            if(buyInput.equalsIgnoreCase("yes")||buyInput.equalsIgnoreCase("y")) {
                System.out.println("Inventory by Car Brand? Yes/No");
                buyInput = scanner.nextLine();
                if (buyInput.equalsIgnoreCase("yes") || buyInput.equalsIgnoreCase("y")) {
                    System.out.println("Enter the car brand please:");
                    String carBrand=scanner.nextLine();
                    inventoryByBrand(cars,carBrand );
                }
                System.out.println("Inventory by Car Model? Yes/No");
                buyInput = scanner.nextLine();
                if (buyInput.equalsIgnoreCase("yes") || buyInput.equalsIgnoreCase("y")) {
                    System.out.println("Enter the car model please:");
                    String carModel=scanner.nextLine();
                    inventoryByModel(cars,carModel );
                }
                System.out.println("Inventory for all cars? Yes/No");
                buyInput = scanner.nextLine();
                if (buyInput.equalsIgnoreCase("yes") || buyInput.equalsIgnoreCase("y")) {
                    System.out.println("The available cars:");
                    inventory(cars);
                }
            }
            while (search){
                System.out.println("Hello!!! So glad to help you today\n What Car are you looking for?");
                String carModel=scanner.nextLine();
                for(String i: cars.keySet()){
                    String[] model=i.split("/");
                    if(carModel.equalsIgnoreCase(model[1])) {
                        if(cars.get(i)>0) {
                            System.out.printf("Hooray we have %d left !!\n", cars.get(i));
                            System.out.println("Do you want to go ahead and buy one?? yes/no");
                            buyInput=scanner.nextLine();
                            if(buyInput.equalsIgnoreCase("yes")||buyInput.equalsIgnoreCase("y")){
                                System.out.println("We wil go ahead and reserve it for you and mark it sold!!!");
                                cars.replace(i,cars.get(i),cars.get(i)-1);
                                System.out.println("Congratulations! for yor new car\nDo you want to look up for another car?");
                                buyInput=scanner.nextLine();
                                if(buyInput.equalsIgnoreCase("yes")||buyInput.equalsIgnoreCase("y")){
                                    search=true;
                                }
                                else
                                    search=false;
                                System.out.println("Thank you for your business, go ahead and full the required form to complete your purchase");
                                System.out.println("Good Bye");
                            }
                        } else{
                            System.out.printf("We don't have %s now, do you like too see different Model? Yes/No\n",cars.get(i));
                            buyInput=scanner.nextLine();
                            if(buyInput.equalsIgnoreCase("yes")||buyInput.equalsIgnoreCase("y")){
                                search=true;
                                keepGoing=true;
                            }
                            else{
                                keepGoing=false;
                                search=false;
                                System.out.println("Good Bye");
                            }
                        }
                    }}
            }}
    }
}
