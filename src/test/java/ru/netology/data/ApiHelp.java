package ru.netology.data;

public class ApiHelp {

    public String createCardInfoJson(String cardNumber) {
        return "{\n" +
                "    \"number\": \"" + cardNumber + "\",\n" +
                "    \"month\": \"10\",\n" +
                "    \"year\": \"25\",\n" +
                "    \"holder\": \"Ekaterina Ustinova\",\n" +
                "    \"cvc\": \"365\"\n" +
                "}";
    }

    public String getEmptyCardInfoJson() {
        return "{\n" +
                "    \"number\": \"\",\n" +
                "    \"month\": \"\",\n" +
                "    \"year\": \"\",\n" +
                "    \"holder\": \"\",\n" +
                "    \"cvc\": \"\"\n" +
                "}";
    }
}
