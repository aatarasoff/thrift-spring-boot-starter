package ru.trylogic.spring.boot.thrift.examples.simple;

import com.kurento.kms.thrift.api.KmsMediaServerService;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class KmsMediaServerServiceDebugTests {

    @Value("${local.server.port}")
    int port;

    TProtocolFactory protocolFactory = new TJSONProtocol.Factory();

    KmsMediaServerService.Iface client;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/debug");

        TProtocol protocol = protocolFactory.getProtocol(transport);

        client = new KmsMediaServerService.Client(protocol);
    }

    @Test
    public void testDebugCall() throws Exception {
        String result = client.invokeJsonRpc("Hello world");

        assertEquals("HELLO WORLD", result);
    }
}