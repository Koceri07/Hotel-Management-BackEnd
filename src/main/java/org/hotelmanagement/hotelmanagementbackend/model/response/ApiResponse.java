package org.hotelmanagement.hotelmanagementbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String code;
    private String message;
    private Object data;

    public ApiResponse(Object data){
        setCode("200");
        setMessage("Successfuly");
        setData(data);
    }

    public void badRequest(Object data){
        setCode("500");
        setMessage("Bad Request");
        setData(data);
    }
}
