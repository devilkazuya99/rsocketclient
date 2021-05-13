package ong.ternchow.rsocketclient;

import java.nio.ByteBuffer;
import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.SerializationUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    public static final String HOST = "localhost";
    public static final int TCP_PORT = 8910;

    public static void main(String[] args) {

        ReqResClient client = new ReqResClient();
        
        User user = new User("devil", "kazuya");
        try {
            // serializing object to byte array.
            byte[] bytes = SerializationUtils.serialize(user);
            
            log.info("Sending 'user' to server:   ----  {}", user);
            ByteBuffer response = client.callBlocking(bytes);
            
            // deserializing byte array back to object.
            User clone = (User) SerializationUtils.deserialize(response.array());
            log.info("Getting 'user' from server: ----  {}", clone);
            
        } catch (NullPointerException | SerializationException e) {
            log.error("something wrong", e);
        }
        
        client.dispose();
    }

}
