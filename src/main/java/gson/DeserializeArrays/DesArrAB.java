package gson.DeserializeArrays;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DesArrAB {
    public static void main(String[] args) {
        deserilizeModuleArray();
    }

    public static void deserilizeModuleArray(){
        //ModuleJsonA[] moduleArray = new Gson().fromJson(getStringFromJson(), ModuleJsonA[].class);

        String pathNameA = "E:\\JavaStudy\\src\\main\\java\\gson\\JsonRawFiles\\ou_modules.json";
        String pathNameA2 = "G:\\Projects\\JavaStudy\\src\\main\\java\\gson\\JsonRawFiles\\ou_modules.json";
        Type moduleListType = new TypeToken<ArrayList<ModuleJsonA>>(){}.getType();
        String jsonStrA = getJsonString(pathNameA2);
        List<ModuleJsonA> moduleList = new Gson().fromJson(jsonStrA, moduleListType);

        System.out.println(moduleList.get(0));
        System.out.println(moduleList.get(moduleList.size()-1));

        //----------------------------------------------------------------------------------------


        String pathNameB = "E:\\JavaStudy\\src\\main\\java\\gson\\JsonRawFiles\\ou_module_collection.json";
        String pathNameB2 = "G:\\Projects\\JavaStudy\\src\\main\\java\\gson\\JsonRawFiles\\ou_module_collection.json";
        String jsonStrB = getJsonString(pathNameB2);
        ModuleCollection modules = new Gson().fromJson(jsonStrB, ModuleCollection.class);

        System.out.println(modules.Modules.get(0));
        System.out.println(modules.Modules.get(10));
    }


    private static String getJsonString(String pathName){
        String jsonStr;
        try{
            File file = new File(pathName);
            InputStream inputStream = new FileInputStream(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonStr = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException ex){
            return null;
        }

        //System.out.println(jsonStr);
        return jsonStr;
    }




}
