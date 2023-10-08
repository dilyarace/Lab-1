// SUPER CLASS

// Abstract Computer class
public abstract class Computer {

    // Abstract methods to be implemented in subclasses
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    // Overriding the toString() method
    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}










// SUB CLASSES

//The PC subclass of the Computer superclass
public class PC extends Computer {

    // Private fields
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor
    public PC(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // Implementations of abstract methods
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}










//The Server subclass of the Computer superclass
public class Server extends Computer {

    // Private fields
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor
    public Server(String ram, String hdd, String cpu){
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // Implementations of abstract methods
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }
}










// FACTORY CLASSES FOR EACH SUB-CLASS

// Interface ComputerAbstractFactory
public interface ComputerAbstractFactory {

    // createComputer() method to be implemented by interface subclasses
    public Computer createComputer();
}
//Now our factory classes will implement this interface and return their respective sub-class










// Class PCFactory that implements the previus interface
public class PCFactory implements ComputerAbstractFactory {

    // Private fields
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor
    public PCFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // Method createComputer() is returning an instance of super class Computer
    @Override
    public Computer createComputer() {
        // Creating a PC class object
        return new PC(ram, hdd, cpu);
    }
}










// Class ServerFactory that implements the previus interface
public class ServerFactory implements ComputerAbstractFactory {

    // Private fields
    private String ram;
    private String hdd;
    private String cpu;

    // Constructor
    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;11.java
        this.hdd = hdd;
        this.cpu = cpu;
    }

    // Method createComputer() is returning an instance of super class Computer
    @Override
    public Computer createComputer() {
        // Creating a Server class object
        return new Server(ram, hdd, cpu);
    }
}










// Class ComputerFactory
public class ComputerFactory {

    // Method getComputer() create objects from class Computer using factory interface
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}









// Class TestDesignPatterns
public class TestDesignPatterns {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        // Creating type PC using PCFactory
        Computer pc = com.journaldev.design.abstractfactory.ComputerFactory.getComputer(
                new PCFactory("2 GB", "500 GB", "2.4 GHz"));

        // Creating type Server using PCFactory
        Computer server = com.journaldev.design.abstractfactory.ComputerFactory.getComputer(
                new ServerFactory("16 GB", "1 TB", "2.9 GHz"));

        // Output information about the created computers
        System.out.println("AbstractFactory PC Config::" + pc);
        System.out.println("AbstractFactory Server Config::" + server);
    }
}
