package Singletons.SimpleSingleton;

public class ModuleClient {


    public static void main(String[] args) {
        Module module = ModuleLab.newModuleLab().getModule("M1");
        System.out.println(module.toString());
    }
}
