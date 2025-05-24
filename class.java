// 👇 Ana sınıf (Base class)
class Animal {
    // 👉 Field'lar (özellikler)
    private String name;   // encapsulation örneği
    private int age;

    // 👉 Constructor (yapıcı metot)
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 👉 Getter ve Setter metodları (Encapsulation için)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 👉 Davranış (method)
    public void speak() {
        System.out.println(name + " ses çıkarıyor.");
    }
}

// 👇 Kalıtım (Inheritance) örneği: Dog sınıfı Animal'dan türemiştir
class Dog extends Animal {

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);  // üst sınıfın constructor'ını çağır
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    // 👉 Overriding (Polymorphism) - methodu yeniden tanımlama
    @Override
    public void speak() {
        System.out.println(getName() + " hav hav diyor! Cinsi: " + breed);
    }
}

// 👇 Soyut sınıf (Abstraction) örneği
abstract class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    // 👉 Soyut metot (implement edilmek zorunda)
    public abstract void move();
}

// 👇 Abstraction'ı tamamlayan sınıf
class Car extends Vehicle {

    public Car(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println(getModel() + " araba ilerliyor...");
    }
}

public class Main {
    public static void main(String[] args) {
        // 👉 Object creation - nesne oluşturma
        Animal genericAnimal = new Animal("Canlı", 3);
        Dog dog = new Dog("Karabas", 5, "Kangal");
        Car car = new Car("Toyota");

        // 👉 Metot çağrısı
        genericAnimal.speak();  // "Canlı ses çıkarıyor."
        dog.speak();            // "Karabas hav hav diyor! Cinsi: Kangal"
        car.move();             // "Toyota araba ilerliyor..."

        // 👉 Polymorphism örneği
        Animal a = new Dog("Çomar", 2, "Golden");
        a.speak();  // "Çomar hav hav diyor!" çünkü Dog classındaki override çalışır

        // 👉 Encapsulation örneği
        dog.setName("Karabas Güncellendi");
        System.out.println("Yeni isim: " + dog.getName());
    }
}
