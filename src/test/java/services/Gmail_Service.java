package services;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

// At constructor, call your file where you have store the token value
// Create a config.properties file in your resource folder, I have created an config.properties_example for you. Copy inside the file and replace YOUR_ACCESS_TOKEN with your gmail authorized access token. 


public class Gmail_Service {
    Properties prop;
    public Gmail_Service() throws IOException {
        prop=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }
    public String getGmailList()
    {
        //Call gmail api
        //Convert response to Json Data format
        //Return the list id to get the latest email info


        RestAssured.baseURI="https://gmail.googleapis.com";
        Response res=given().contentType("application/json").header("Authorization","Bearer "+prop.getProperty("token"))
                .when().get("/gmail/v1/users/me/messages");
        JsonPath jsonObj=res.jsonPath();
        String listId=jsonObj.get("messages[0].id");
        return listId;

    }

    public String readGmail() throws IOException {

        //Similarly call the gmail api, but this time call gmail read api using last id
        //Gmail message body are stored at snippet, so, we take snippet to see inside gmail


        
        String messageId=getGmailList();
        RestAssured.baseURI="https://gmail.googleapis.com";
        Response res=given().contentType("application/json").header("Authorization","Bearer "+prop.getProperty("token"))
                .when().get("/gmail/v1/users/me/messages/"+messageId);

        JsonPath jsonObj=res.jsonPath();
        String myEmail=jsonObj.get("snippet");
        return myEmail;
    }

    public static void main(String[] args) throws IOException {
        Gmail_Service gmailService=new Gmail_Service();
        String myEmail=gmailService.readGmail();
    }


}
