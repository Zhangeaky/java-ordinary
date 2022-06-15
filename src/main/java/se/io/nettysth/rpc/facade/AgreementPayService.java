package se.io.nettysth.rpc.facade;

import se.io.nettysth.rpc.facade.request.AgreementPayRequest;
import se.io.nettysth.rpc.facade.response.AgreementPayResponse;

public interface AgreementPayService {

    AgreementPayResponse pay(AgreementPayRequest request);
}
