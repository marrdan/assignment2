public class Car extends Vehicle implements Servicable {

    private int doors;


    public Car(String model, int year, double basePrice, int doors){
        super(model, year, basePrice);
        set_doors(doors);
    }





    public void set_doors(int doors){
        if(doors <= 0){
            throw new IllegalArgumentException("двери машин не модет быть меньше нули или равно к нему");
        }
        this.doors = doors;
    }

    public int getDoors(){
        return doors;
    }


    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        return age*100;
    }

    @Override
    public void perform_service() {
        System.out.println("здраствуйте , какой машинный - сервис вам предоставлят? " );

    }

    @Override
    public int get_service_interval_km() {
        return 10_000;
    }
}
