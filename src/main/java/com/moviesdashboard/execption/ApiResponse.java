package com.moviesdashboard.execption;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    @Builder.Default
    private Boolean success = true;

    private ErrorPayload errors;

    @Builder.Default
    private Integer code = HttpStatus.OK.value();

    private T payload;

    private static <T> ApiResponse<T> status(HttpStatus status , T payload ){
        return new ApiResponse<>(true ,null , status.value() , payload);
    }

    public static <T> ApiResponse<T> ok(T payload){
        return status(HttpStatus.OK , payload);
    }
    
    public static <T> ApiResponse<T> created(T payload){
        return status(HttpStatus.CREATED, payload);
    }

    public static <T> ApiResponse<T> accepted(T payload) {
        return status(HttpStatus.ACCEPTED, payload);
    }

}
