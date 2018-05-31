package gson;

public class GsonDemo3
{
    static class Person {
        String name;
        int age;

        Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return name + ": " + age;
        }
    }

    public static void main(String[] args) throws IOException
    {
        class PersonDeserializer implements JsonDeserializer<Person>
        {
            @Override
            public Person deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context)
            {
                JsonObject jsonObject = json.getAsJsonObject();
                String firstName = jsonObject.get("first-name").getAsString();
                String lastName = jsonObject.get("last-name").getAsString();
                int age = jsonObject.getAsJsonPrimitive("age").getAsInt();
                String address = jsonObject.get("address").getAsString();
                return new Person(firstName + " " + lastName, 45);
            }
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Person.class, new PersonDeserializer());

        Gson gson = gsonBuilder.create();
        String json = "{ first-name: \"John\", last-name: \"Doe\", " +
                "age: 45, address: \"Box 1\" }";
        System.out.println("Original json String:");
        System.out.println(json);

        // json to object
        Person person = gson.fromJson(json, Person.class);
        System.out.println("\njson to object:");
        System.out.println(person);

        // object to json
        System.out.println("\nobject to json:");
        String jStr = gson.toJson(person);
        System.out.println(jStr);

        // object to FileWriter       FileWriter fw = new FileWriter("person.json");       gson.toJson(person, fw);       fw.close();

    }
}
