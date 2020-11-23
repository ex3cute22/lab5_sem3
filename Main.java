import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static void main(String[] args){
		// Car car = new Car();
		// car.Init();	
		// car.Read();
		// car.Display();
		System.setProperty("console.encoding","windows-1251");
		var toyota = new Car();
    Car bmw = new Car();
    Car lamba = new Car();
    Shop diler_1 = new Shop();
    Shop diler_2 = new Shop();

    toyota.Init("toyota", "carib", 83, "автомат", "зелёный", 1998, 100000);
    bmw.Init("bmw", "m5", 200, "автомат", "чёрный", 2020, 300000);
    lamba.Init("lamba", "veneno", 400, "автомат", "красный", 2019, 400000);

	diler_1.Init(toyota);
	diler_2.Init();
    diler_2.Read();
    diler_1.Display();
    diler_1.ChangeClass();
    diler_1.InfoClass();
    diler_2.ChangeClass();
    diler_2.Display();
    diler_2.SaleCar();
    diler_2.Init(bmw);
    diler_2.SaleCar();
    diler_2.InfoBalance();
	}
}

class Shop{
	Car slot = new Car();
	private int balance = 0;
	private String classCar;

	public void Init() {
        slot.Init();
        classCar = "Не указано";
	}
	public void Init(Car slot) {
        this.slot = slot;
        classCar = "Не указано";
    }
    public void Read() {
        slot.Read();
    }
    public void Display() {
        slot.Display(); 
	}
	public void ChangeClass() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Укажите класс машины: ");
		this.classCar = scan.nextLine();
	}
	public void InfoClass() {
		System.out.println("Класс машины: " + classCar);
    }
    public void InfoBalance() {
        System.out.print("Баланс: ");
		System.out.println(balance);
    }
    public void SaleCar() {
        balance = slot.Sale(balance);
        slot.Init();
    }
}
class Car{

	private String marka;
	private String model;
	private int power;
	private String transmission;
	private String color;
	private int year;
	private int price;
	
	public void Init(){
		marka = "";
		model = "";
		power = 0;
		transmission = "";
		color = "";
		year = 0;
		price = 0;
	}
	public void Init(String marka, String model, int power, String transmission, String color, int year, int price){
		this.marka = marka;
		this.model = model;
		this.power = power;
		this.transmission = transmission;
		this.color = color;
		this.year = year;
		this.price = price;
	}
	public void Read(){
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		try{
		marka = scanString.nextLine();
		model = scanString.nextLine();
		power = scanInt.nextInt();
		transmission = scanString.nextLine();
		color = scanString.nextLine();
		year = scanInt.nextInt();
		price = scanInt.nextInt();
		//scanner.close();
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	public void Display(){
		System.out.println(marka);
		System.out.println(model);
		System.out.println(power);
		System.out.println(transmission);
		System.out.println(color);
		System.out.println(year);
		System.out.println(price + "\n");
	}
	public int Sale(int _balance){
		_balance += price;
		return _balance;
	}
	public void Paint() {
		String newColor;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nСтарый цвет: "+ color + "\tНовый цвет");
        newColor = scan.nextLine();
        color = newColor;
    }
}