package com.github.ls.common.order;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cl_car_info")
public class ClCarInfo implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "load_order_no", length = 50, unique = true)
  @JsonProperty(value = "load_order_no")
  private String loadOrderNo;

  @Column(name = "biz_order_no", length = 50, unique = true)
  @JsonProperty(value = "biz_order_no")
  private String bizOrderNo;

  @JsonProperty(value = "car_no")
  @Column(name = "car_no", length = 50)
  private String carNo;

  @JsonProperty(value = "car_brand")
  @Column(name = "car_brand", length = 50)
  private String carBrand;

  @JsonProperty(value = "car_model")
  @Column(name = "car_model", length = 50)
  private String carModel;

  @JsonProperty(value = "car_color")
  @Column(name = "car_color", length = 50)
  private String carColor;

  @JsonProperty(value = "car_FrameNo")
  @Column(name = "car_FrameNo", length = 50)
  private String carFrameNo;

  @JsonProperty(value = "car_engine_no")
  @Column(name = "car_engine_no", length = 50)
  private String carEngineNo;

  @JsonProperty(value = "car_driving_mileage")
  @Column(name = "car_driving_mileage", length = 50)
  private String carDrivingMileage;

  @JsonProperty(value = "car_service_life")
  @Column(name = "car_service_life", length = 50)
  private String carServiceLife;

  @JsonProperty(value = "major_accident")
  @Column(name = "major_accident", length = 50)
  private String majorAccident;

  @JsonProperty(value = "accident_type")
  @Column(name = "accident_type", length = 50)
  private String accidentType;

  @JsonProperty(value = "install_gps")
  @Column(name = "install_gps", length = 50)
  private String installGps;

}
