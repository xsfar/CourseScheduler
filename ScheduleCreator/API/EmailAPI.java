package ScheduleCreator.API;

/**
 * Makes direct calls to the MailJet API.
 *
 * @author Ilyass Sfar
 *
 * Last Updated: 3/29/2020
 */
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class EmailAPI implements APIInterface {

    /**
     * Send email's using an API.
     *
     * @param _email The email that is being sent to, this comes from the user.
     * @param _message This is what is being sent in the email.
     * @return
     * @throws MailjetException
     * @throws MailjetSocketTimeoutException
     */
    @Override
    public void SendEmail(String _email, String _message) throws MailjetException, MailjetSocketTimeoutException {
        //Initalize the API requirements
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        //Create a new client to send emails, using public and private api keys, and speify which version of the client is being used
        client = new MailjetClient(("4ed58dd4eac88294f8decd6ebcb37802"), ("2ebe9765bf49eeac4c25fa0436edbcbf"), new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                //The email that is being used to send, this is controled from the mailjet webiste
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "ScheduleCreatorUNCG@gmail.com")
                                        .put("Name", "Schedule Creator"))
                                //The email that is being send to
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", _email)
                                                .put("Name", "Student")))
                                //Subject line of email
                                .put(Emailv31.Message.SUBJECT, "Schedule Creator")
                                //Body of email
                                .put(Emailv31.Message.TEXTPART, _message)));
        response = client.post(request);

        //Print out what email was just sent, it was sent or not, and any errors from the API
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
