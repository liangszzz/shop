package com.github.ls.common.order;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cl_car_info")
public class ClCarInfo implements Serializable {

  @Id
  @GeneratedValue
  private long id;

  @NotBlank
  @Column(name = "load_order_no", length = 50, unique = true)
  @JSONField(name = "load_order_no")
  private String loadOrderNo;

  @NotBlank
  @Column(name = "biz_order_no", length = 50, unique = true)
  @JSONField(name = "biz_order_no")
  private String bizOrderNo;

  @NotBlank
  @JSONField(name = "car_no")
  @Column(name = "car_no", length = 50)
  private String carNo;

  @JSONField(name = "car_brand")
  @Column(name = "car_brand", length = 50)
  private String carBrand;

  @JSONField(name = "car_model")
  @Column(name = "car_model", length = 50)
  private String carModel;

  @JSONField(name = "car_color")
  @Column(name = "car_color", length = 50)
  private String carColor;

  @JSONField(name = "car_FrameNo")
  @Column(name = "car_FrameNo", length = 50)
  private String carFrameNo;

  @JSONField(name = "car_engineno")
  @Column(name = "car_engineno", length = 50)
  private String carEngineNo;

  @JSONField(name = "car_driving_mileage")
  @Column(name = "car_driving_mileage", length = 50)
  private String carDrivingMileage;

  @JSONField(name = "car_service_life")
  @Column(name = "car_service_life", length = 50)
  private String carServiceLife;

  @JSONField(name = "major_accident")
  @Column(name = "major_accident", length = 50)
  private String majorAccident;

  @JSONField(name = "accident_type")
  @Column(name = "accident_type", length = 50)
  private String accidentType;

  @NotBlank
  @JSONField(name = "install_gps")
  @Column(name = "install_gps", length = 50)
  private String installGps;

}
