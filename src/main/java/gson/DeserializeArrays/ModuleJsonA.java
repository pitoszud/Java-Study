package gson.DeserializeArrays;

public class ModuleJsonA {
    String Code;
    String ModuleDesc;
    int Level;
    int Credits;

    public ModuleJsonA(
            String Code,
            String moduleDesc,
            int modLevel,
            int modCredits
    ){

        this.Code = Code;
        this.ModuleDesc = moduleDesc;
        this.Level = modLevel;
        this.Credits = modCredits;
    }

    @Override
    public String toString() {
        return "ModuleJsonA{" +
                "Code='" + Code + '\'' +
                ", modDesc='" + ModuleDesc + '\'' +
                ", modLevel=" + Level +
                ", modCredits=" + Credits +
                '}';
    }
}

