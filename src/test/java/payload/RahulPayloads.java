package payload;

import pojo.Rahul_API_Location_Pojo;
import pojo.Rahul_API_Pojo;

import java.util.ArrayList;
import java.util.List;

public class RahulPayloads {
    public static String addNewPlacePayload(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -10,\n" +
                "    \"lng\": 50\n" +
                "  },\n" +
                "  \"accuracy\": 35,\n" +
                "  \"name\": \"Winter House\",\n" +
                "  \"phone_number\": \"(+91) 900 000 0101\",\n" +
                "  \"address\": \"100, small street, cohen 18\",\n" +
                "  \"types\": [\n" +
                "    \"condo\",\n" +
                "    \"apartment\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"German\"\n" +
                "}";

    }
    public static Rahul_API_Pojo addNewPlacePayload2(){
        Rahul_API_Pojo place=new Rahul_API_Pojo();
        place.setAccuracy(11);
        place.setName("Pink House");
        place.setPhone_number("9127651256");
        place.setAddress("1123.street");
        place.setWebsite("mynew@gmail.com");
        place.setLanguage("French");

        List<String> typ = new ArrayList<>();
        typ.add("apartment");
        typ.add("condo");
        place.setTypes(typ);


        Rahul_API_Location_Pojo loc= new Rahul_API_Location_Pojo();
        loc.setLat(-23.122);
        loc.setLng(45.912);
        place.setLocation(loc);

        return place;

    }

}
