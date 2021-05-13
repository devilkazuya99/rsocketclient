package ong.ternchow.rsocketclient;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/* ISO-99999999 standard user */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -8731669541043173364L;
    private String username;
    private String password;
    
}
