package com.project.stussy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDto<T> {
	private int code;
<<<<<<< HEAD
	private String massege;
=======
	private String message;
>>>>>>> origin/joohong
	private T data;
}
