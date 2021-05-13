package ong.ternchow.rsocketclient;

import static ong.ternchow.rsocketclient.Application.HOST;
import static ong.ternchow.rsocketclient.Application.TCP_PORT;

import java.nio.ByteBuffer;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;

public class ReqResClient {

    private final RSocket socket;

    public ReqResClient() {
        this.socket = RSocketFactory.connect()
                .transport(TcpClientTransport.create(HOST, TCP_PORT))
                .start()
                .block();
    }

    public ByteBuffer callBlocking(byte[] byteArray) {
        return socket
                .requestResponse(DefaultPayload.create(byteArray))
                .map(Payload::getData)
                .block();
    }
    
    public void dispose() {
        this.socket.dispose();
    }

}
