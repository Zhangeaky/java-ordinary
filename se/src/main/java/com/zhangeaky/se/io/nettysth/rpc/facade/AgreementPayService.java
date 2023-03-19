package com.zhangeaky.se.io.nettysth.rpc.facade;

import com.zhangeaky.se.io.nettysth.rpc.facade.request.AgreementPayRequest;
import com.zhangeaky.se.io.nettysth.rpc.facade.response.AgreementPayResponse;

public interface AgreementPayService {

    AgreementPayResponse pay(AgreementPayRequest request);
}
