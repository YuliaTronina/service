package ru.troninaya.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.troninaya.service.model.Request;
import ru.troninaya.service.model.Response;
import ru.troninaya.service.service.MyService;

import java.util.Collections;

@RestController
public class MyController {


    private final MyService myService;

    @Autowired
    public MyController(@Qualifier("ModifyUid") MyService myService) {
        this.myService = myService;
    }

    Response requestNew;

    @PostMapping(value = "/feedback")

    public ResponseEntity<Response> feedback (@RequestBody Request request){



        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid((request.getOperationUid()))
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        HttpEntity<Response> httpEntity = new HttpEntity<>(response);

        new RestTemplate()
                .exchange("http://localhost:8081/feedback",
                        HttpMethod.POST,
                        httpEntity,
                        new ParameterizedTypeReference<Response>() {});

        return new ResponseEntity<>(myService.execute(response), HttpStatus.OK);
    }


}
