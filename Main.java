import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

public class Main{
	public static void main(String[] args){
	
	var toyota = new Car();
    Car bmw = new Car();
    Car lamba = new Car();
    Shop diler_1 = new Shop();
    Shop diler_2 = new Shop();

    toyota.Init("toyota", "carib", 83, "mechanics", "green", 1998, 100000);
    bmw.Init("bmw", "m5", 200, "automatic", "silver", 2020, 300000);
    lamba.Init("lamba", "veneno", 400, "automatic", "red", 2019, 400000);

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
        classCar = "None";
	}
	public void Init(Car slot) {
        this.slot = slot;
        classCar = "None";
    }
    public void Read() {
        slot.Read();
    }
    public void Display() {
        slot.Display(); 
	}
	public void ChangeClass() {
		System.out.print("Class auto: ");
		Scanner scan = new Scanner(System.in);
		this.classCar = scan.nextLine();
	}
	public void InfoClass() {
		try{
		PrintStream out = new PrintStream(System.out, true, "Windows-1251");
		out.println("Class auto: " + classCar);
		}catch(Exception err){
			err.printStackTrace();}	
    }
    public void InfoBalance() {
        try{
		PrintStream out = new PrintStream(System.out, true, "Windows-1251");
		out.print("Balance: ");
		out.println(balance);}
		catch(Exception err){
			err.printStackTrace();}	
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
		try{
			PrintStream out = new PrintStream(System.out, true, "Windows-1251");
		out.println(marka);
		out.println(model);
		out.println(power);
		out.println(transmission);
		out.println(color);
		out.println(year);
		out.println(price + "\n");
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	public int Sale(int _balance){
		_balance += price;
		return _balance;
	}
	public void Paint() {
		String newColor;
		Scanner scan = new Scanner(System.in);
		try{
			PrintStream out = new PrintStream(System.out, true, "Windows-1251");
		out.println("\nOld color: "+ color + "\nNew color: ");}
		catch(Exception err){
			err.printStackTrace();}
        newColor = scan.nextLine();
        color = newColor;
    }
}