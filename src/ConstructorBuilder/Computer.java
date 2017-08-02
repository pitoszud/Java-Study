/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstructorBuilder;

/**
 *
 * @author UPatryk
 */
public class Computer {
    // required parameters
    private final String cpu;
    private final int ram;
    private final String hd;
    
    // optional parameters
    private final String atxForm;
    private final String monitor;
    private final String gpu;
    private final int screen;
    
    // private - cannot be directly instantiated in the client
    // immutable - all attributes are final
    private Computer(CompBuilder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.hd = builder.hd;
        this.atxForm = builder.atxForm;
        this.monitor = builder.monitor;
        this.gpu = builder.gpu;
        this.screen = builder.screen;
    }
    
    public static Computer getBasicComputer(){
        return new Computer.CompBuilder("i7",32,"250ssd")
                .build();
    }
    
    public static Computer getMediumComputer(){
        return new Computer.CompBuilder("i7",32,"250ssd")
                .gpu("nvida640")
                .screenSize(27)
                .build();
    }
    
    public static Computer setMediumComputer(String cpu, int ram, String hd){
        return new Computer.CompBuilder(cpu, ram, hd)
                .gpu("nvida640")
                .screenSize(27)
                .build();
    }

    @Override
    public String toString() {
        return "Computer{" + "cpu=" + cpu + ", ram=" + ram + ", hd=" + hd + 
                ", atxForm=" + atxForm + ", monitor=" + monitor + 
                ", gpu=" + gpu + ", screen=" + screen + '}';
    }
    

    public static class CompBuilder{
        // required parameters used in Builder constructor
        private final String cpu;
        private final int ram;
        private final String hd;
        
        // optional parameters 
        private String atxForm = "";
        private String monitor = "";
        private String gpu = "";
        private int screen;
        
        // set required parameters in the CompBuilder constructor
        public CompBuilder(String cpu, int ram, String hd){
            if (cpu == null || ram == 0 || hd == null) {
                throw new IllegalArgumentException("cpu, ram and hd cannot be null or 0");
            }
            this.cpu = cpu;
            this.ram = ram;
            this.hd = hd;
        }
    
        public CompBuilder atxForm(String val){
            atxForm = val;
            return this;
        }
        
        public CompBuilder monitor(String val){
            monitor = val;
            return this;
        }
        
        public CompBuilder gpu(String val){
            gpu = val;
            return this;
        }
        
        public CompBuilder screenSize(int val){
            screen = val;
            return this;
        }
        
        public Computer build(){
            Computer comp = new Computer(this);
            if (comp.ram > 64) {
                throw new IllegalStateException("too much ram");
            }
            return comp;
        }
    }
    
}
