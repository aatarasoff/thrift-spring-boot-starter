package ru.trylogic.spring.boot.thrift.examples.simple;

import org.apache.thrift.protocol.TJSONProtocol;
import ru.trylogic.spring.boot.thrift.annotation.ThriftHandler;

@ThriftHandler(value = "/debug", factory = TJSONProtocol.Factory.class)
public class KmsMediaServerServiceDebugHandler extends KmsMediaServerServiceImpl {

}
