package com.salaryexample.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailMessage {

    private String to;
    private String subject;
    private String message;

}
