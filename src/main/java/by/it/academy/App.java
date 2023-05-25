package by.it.academy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class App 
{
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream inputStream = App.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);

            String environment = System.getProperty("environment");
            String weatherApiUrl = properties.getProperty(environment + ".url");

            System.out.println("Weather API URL: " + weatherApiUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
