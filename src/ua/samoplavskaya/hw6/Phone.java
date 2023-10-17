package ua.samoplavskaya.hw6;

public class Phone {
    String number;
    String model;
    double weight;

    public Phone() {
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone();
        phone1.number = "0678033963";
        phone1.model = "nokia";
        phone1.weight = 133.0;
        Phone phone2 = new Phone("0678324567", "Samsung", 233.5);
        Phone phone3 = new Phone("0987523146", "iPhone");
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        phone1.receiveCall("Pavel");
        System.out.println("Номер телефона: " + phone1.getNumber());
        phone2.receiveCall("Alex");
        System.out.println("Номер телефона: " + phone2.getNumber());
        phone3.receiveCall("Anna");
        System.out.println("Номер телефона: " + phone3.getNumber());


    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public String getNumber() {
        return number;
    }

}
