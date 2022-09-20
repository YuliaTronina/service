package ru.troninaya.service.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.troninaya.service.model.Response;

@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyService{
    @Override
    public Response execute(Response response) {
        response.setUid("4");

        return response;
    }
}
