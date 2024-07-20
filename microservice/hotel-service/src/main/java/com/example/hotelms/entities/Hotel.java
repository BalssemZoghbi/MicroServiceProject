package com.example.hotelms.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "Hotel")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Hotel {
    @Id
    private String id;
    private String name;
    private String address;
}
/*public record Hotel(
        Long id,
         String name,
         String address
){

   /* public Hotel id(
            final Long id
    ) {
        return new Hotel(
                Objects.nonNull(id)
                        ? id
                        : this.id,
                this.name,
                this.address
        );
    }
    public Hotel name(
            final String name
    ) {
        return new Hotel(
                Objects.nonNull(name)
                        ? name
                        : this.name,
                this.id,
                this.address
        );
    }
    public Hotel address(
            final String address
    ) {
        return new Hotel(
                Objects.nonNull(address)
                        ? address
                        : this.address,
                this.name,
                this.id
        );
    }
}*/
