package org.bitcoin.timechain.calendar.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class JsonResponseResult implements Serializable {

    private Object result;

}
