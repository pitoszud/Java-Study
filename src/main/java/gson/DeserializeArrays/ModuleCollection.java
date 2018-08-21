package gson.DeserializeArrays;

import java.util.List;

public class ModuleCollection {
    List<ModuleJsonA> Modules;

    public ModuleCollection(
            List<ModuleJsonA> moduleCollection
    ){
        this.Modules = moduleCollection;
    }

    @Override
    public String toString() {
        return "ModuleCollection{" +
                ", moduleJsonAList=" + Modules +
                '}';
    }
}

