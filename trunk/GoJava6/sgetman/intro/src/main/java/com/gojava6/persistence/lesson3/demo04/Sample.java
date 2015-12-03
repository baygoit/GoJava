/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.persistence.lesson3.demo04;

import com.gojava6.persistence.lesson3.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/16/15
 */
@Entity
@DiscriminatorValue("S")
public class Sample extends Item{

}
