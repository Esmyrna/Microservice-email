package ms.email.models;


import jakarta.persistence.*;
import lombok.Data;
import ms.email.enums.StatusEmail;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    // Referência do propietário que está mandando esse email
    private String ownerRef;

    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition  = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    // Se o email foi enviado ou não
    private StatusEmail statusEmail;

}
