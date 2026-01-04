public class Bus extends Vehicle implements Servicable {
    protected int capacity;
    protected int y;


    public Bus(String model, int year, double basePrice, int capacity){
        super(model,year,basePrice);
        set_capacity(capacity);
    }



    public void set_capacity(int capacity){
        if(capacity>1000 ){
            throw new IllegalArgumentException("оно не может вместит в себе больше 1000кг");
        }
        this.capacity =capacity;
    }



    public int passengerCapacity(){
        return capacity;
    };



    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        if(age<10.0)
            return  1000.0;
        else
            return 100.0; //цена за одного пассажира
    }


    @Override
    public void perform_service() {
        System.out.println("здраствуйте , какой сервис для автобусов вам предоставлят? " );
    }


    @Override
    public int get_service_interval_km() {
        if(capacity > 30)
            return 10_000;
        else
            return 5_000;
    }
}
