package com.github.ls.common.order;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "cl_attachment_info")
public class ClAttachmentInfo implements Serializable {

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
    @JSONField(name = "file_name")
    @Column(name = "file_name", length = 50)
    private String fileName;

    @JSONField(name = "file_path")
    @Column(name = "file_path", length = 500)
    private String filePath;

    @JSONField(name = "file_size")
    @Column(name = "file_size", length = 10)
    private String fileSize;

    @JSONField(name = "file_suffix")
    @Column(name = "file_suffix", length = 5)
    private String fileSuffix;

    @JSONField(name = "file_type")
    @Column(name = "file_type", length = 1)
    private String fileType;

    @Null
    @JSONField(name = "is_image")
    @Column(name = "is_image", length = 3)
    private String isImage;

    @Null
    @JSONField(name = "fast_dfs_path")
    @Column(name = "fast_dfs_path", length = 50)
    private String fastDfsPath;

    @Null
    @JSONField(name = "upload_count")
    @Column(name = "upload_count")
    private int uploadCount;

    @Null
    @Column(name = "create_date")
    private Date createDate = new Date();

    @Null
    @Column(name = "has_update", length = 1)
    private String hasUpdate;

}
