package com.ouc.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dqs
 * @description TODO
 * @dateTime 2022/4/27 23:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorInfo {
    private List<Sensor> Sensor;
}
