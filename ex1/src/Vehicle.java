public abstract class Vehicle {
    protected int id;
    protected static int idGen;
    protected String model;
    protected int year;
    protected double basePrice;


    public Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        set_model(model);
        set_year(year);
        set_basePrice(basePrice);
    }

    public void set_model(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("оно не может быть пустым");
        }
        this.model = model;
    }

    public void set_year(int year) {
        if (year < 0 || year > 2026) {
            throw new IllegalArgumentException("оно не может быть больше этого года и меньше нуля");
        }
        this.year = year;
    }

    public void set_basePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("оно не может быть меньше нуля");
        }
        this.basePrice = basePrice;
    }


    public int getAge(int currentYear){
        return currentYear-year;
    }


    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return id  + " " + model + " " + year + " " + basePrice;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }


}
