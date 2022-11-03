package com.tmx.nari.agm.model.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Harutyun Badeyan
 * Date: 02.08.22
 * Time: 13:54
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends RuntimeException {
    
    private String message;
    private ErrorCode errorCode;
}
