package com.github.ls.common.order;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "cl_attachment_info")
public class ClAttachmentInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty(value = "load_order_no")
    @Column(name = "load_order_no", length = 50)
    private String loadOrderNo;

    @JsonProperty(value = "biz_order_no")
    @Column(name = "biz_order_no", length = 50)
    private String bizOrderNo;

    @JsonProperty(value = "file_name")
    @Column(name = "file_name", length = 50)
    private String fileName;

    @JsonProperty(value = "file_path")
    @Column(name = "file_path", length = 500)
    private String filePath;

    @JsonProperty(value = "file_size")
    @Column(name = "file_size", length = 10)
    private String fileSize;

    @JsonProperty(value = "file_suffix")
    @Column(name = "file_suffix", length = 5)
    private String fileSuffix;


    @JsonProperty(value = "file_type")
    @Column(name = "file_type", length = 1)
    private String fileType;

    @JsonIgnore
    @JsonProperty(value = "is_image")
    @Column(name = "is_image", length = 3)
    private String isImage;

    @JsonIgnore
    @JsonProperty(value = "fast_dfs_path")
    @Column(name = "fast_dfs_path", length = 50)
    private String fastDfsPath;

    @JsonIgnore
    @JsonProperty(value = "upload_count")
    @Column(name = "upload_count")
    private Integer uploadCount;

    @JsonIgnore
    @JsonProperty(value = "create_date")
    @Column(name = "create_date")
    private Date createDate;

    @JsonIgnore
    @JsonProperty(value = "has_update")
    @Column(name = "has_update", length = 1)
    private String hasUpdate;

}
