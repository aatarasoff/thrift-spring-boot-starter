package ru.trylogic.spring.boot.thrift.examples.simple;

import com.kurento.kms.thrift.api.KmsMediaServerService;
import org.apache.thrift.TException;

/**
 * Created by aleksandr on 05.07.15.
 */
public class KmsMediaServerServiceImpl implements KmsMediaServerService.Iface {
    @Override
    public String invokeJsonRpc(String request) throws TException {
        return request.toUpperCase();
    }
}