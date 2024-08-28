package org.example.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
@AllArgsConstructor
public class Contact {
    @NonNull
    private String name;
    @NonNull
    private int phoneNumber;


}
