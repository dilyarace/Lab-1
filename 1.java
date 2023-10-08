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










//SUB CLASSES

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










// FACTORY CLASS

// ComputerFactory Class
public class ComputerFactory {

    // Method for creating objects of PC or Server classes
    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type))
            return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type))
            return new Server(ram, hdd, cpu);

        return null;
    }
}










// TestFactory Class
public class TestFactory {
    public static void main(String[] args) {

        // Creating Computer objects using ComputerFactory
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");

        // Output
        System.out.println("Factory PC Config::" + pc);
        System.out.println("Factory Server Config::" + server);
    }
}

