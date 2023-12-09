package automationexercise.APIs;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RegisterAPI {
    private SHAFT.API apidriver;

    //Constructor
    public RegisterAPI(SHAFT.API driver) {
        this.apidriver = driver ;
    }

    //Actions
    /*public RegisterAPI createNewUser(String name,String email,String password,String title,String birthDate,String birthMonth,String birthYear,String firstname,String lastname
            ,String address1,String country,String zipcode,String state,String city,String mobileNumber) throws JSONException {
        apidriver.post(baseURL + "/api/createAccount").setRequestBody(createUserBody(name,email,password,title,birthDate,birthMonth,birthYear,firstname,lastname,address1,country,zipcode,state,city,mobileNumber))
                .setContentType(ContentType.JSON).setTargetStatusCode(200).perform();
        return this;
    }

    private JSONObject createUserBody (String name,String email,String password,String title,String birthDate,String birthMonth,String birthYear,String firstname,String lastname
            ,String address1,String country,String zipcode,String state,String city,String mobileNumber) throws JSONException {
        JSONObject createUserBody = new JSONObject();
        createUserBody.put("name",name);
        createUserBody.put("email",email);
        createUserBody.put("password",password);
        createUserBody.put("title",title);
        createUserBody.put("birth_date",birthDate);
        createUserBody.put("birth_month",birthMonth);
        createUserBody.put("birth_year",birthYear);
        createUserBody.put("firstname",firstname);
        createUserBody.put("lastname",lastname);
        createUserBody.put("address1",address1);
        createUserBody.put("country",country);
        createUserBody.put("name",zipcode);
        createUserBody.put("name",state);
        createUserBody.put("name",city);
        createUserBody.put("mobile_number",mobileNumber);
        return createUserBody;
    }*/
    public RegisterAPI createUser (String userName , String email , String password){
        List<List<Object>> formInputs = Arrays.asList(
                Arrays.asList("name", userName),
                Arrays.asList("email", email),
                Arrays.asList("password", password),
                Arrays.asList("title", "Mr."),
                Arrays.asList("birth_date", "12"),
                Arrays.asList("birth_month", "Dec"),
                Arrays.asList("birth_year", "1998"),
                Arrays.asList("firstname", "Mostafa"),
                Arrays.asList("lastname", "Elkholy"),
                Arrays.asList("company", "_VOIS"),
                Arrays.asList("address1", "135 port"),
                Arrays.asList("address2", "DownTown"),
                Arrays.asList("country", "India"),
                Arrays.asList("name", "11617"),
                Arrays.asList("name", "Cairo"),
                Arrays.asList("name", "Cairo"),
                Arrays.asList("mobile_number", "01119832364")
        );
        apidriver.post("createAccount").setParameters(formInputs, RestActions.ParametersType.FORM).setContentType(ContentType.URLENC).setTargetStatusCode(200).perform();
        return this;
    }
}
