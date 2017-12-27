package Singletons.SimpleSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleLab {
    private static ModuleLab moduleLab;
    List<Module> moduleList;

    public static ModuleLab newModuleLab(){
        if (moduleLab == null){
            moduleLab = new ModuleLab();
        }

        return moduleLab;
    }

    private ModuleLab(){
        moduleList = getModules();
    }

    public static List<Module> getModules(){
        List<Module> preSetModuleList = Arrays.asList(
                new Module("M1", "module M1", 2, 30, 2),
                new Module("M1", "module M2", 2, 30, 2),
                new Module("M2", "module M3", 2, 30, 3),
                new Module("M3", "module M4", 2, 30, 2),
                new Module("M4", "module M5", 2, 30, 3),
                new Module("M5", "module M6", 2, 30, 2),
                new Module("M6", "module M7", 3, 30, 3),
                new Module("M7", "module M8", 3, 30, 2),
                new Module("M8", "module M9", 3, 30, 2),
                new Module("M9", "module M10", 3, 30, 3),
                new Module("M10", "module M11", 3, 30, 2),
                new Module("M11", "module M12", 3, 30, 3)
        );

        List<Module> moduleList = new ArrayList<>(preSetModuleList);

        return moduleList;

    }

    public void addModule(Module module){
        moduleList.add(module);
    }

    public Module getModule(String moduleId){
        Module module = moduleList.stream()
                .filter(it -> it.getModuleId().equals(moduleId))
                .findAny()
                .orElse(null);

        return module;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public List<Module> deleteAndReturnModules(Module module){
        moduleList.remove(module);
        return moduleList;
    }
}