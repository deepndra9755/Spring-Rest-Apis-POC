package com.school.vo;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourceVo {
	@Nullable
	Integer id;
	String courceName;
	Integer duration;
	String address;
	Integer fees;
	

}
