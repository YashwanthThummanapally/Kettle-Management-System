package com.edubridge.kettle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Kettle {
	private int kettleId;
	private String kettleBrand, material, storage;
	private float kettleCapacity;
	private double price;
}
