package ru.troninaya.service.excpection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.troninaya.service.model.Request;
import ru.troninaya.service.model.Response;


public class ProcessFailException extends Exception{


}
