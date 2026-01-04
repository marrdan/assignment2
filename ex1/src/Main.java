public class Main {
    public static void main(String[] args){
        Servicable car = new Car("четырнашка",1999,1000.0,4);
        car.perform_service();
        System.out.println(car.get_service_interval_km());
        Servicable bus = new Bus("bus",2012,1000.0,15);
        bus.perform_service();
        System.out.println(bus.get_service_interval_km());
        console_app app = new console_app();
        app.run();

    }


}