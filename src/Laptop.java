import java.util.HashMap;
import java.util.Map;

public class Laptop {
    private String model;
    private int ram;
    private int hardDrive;
    private String os;
    private String color;

    public Laptop(String model, int ram, int hardDrive, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", ram=" + ram + "GB" +
                ", hardDrive=" + hardDrive + "GB" +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}