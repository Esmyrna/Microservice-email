package ms.email.controllers;

import jakarta.validation.Valid;
import ms.email.dtos.EmailDto;
import ms.email.models.EmailModel;
import ms.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    // Ponto de injeção
    @Autowired
    EmailService emailService;

     @PostMapping
     public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
         // transformar o dto em model para conseguir salvar no banco de dados
         EmailModel emailModel = new EmailModel();
         BeanUtils.copyProperties(emailDto, emailModel);
         emailService.sendEmail(emailModel);

         return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
     }

}
