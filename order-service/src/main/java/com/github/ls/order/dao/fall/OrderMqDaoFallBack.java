package com.github.ls.order.dao.fall;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.order.mq.AddAttachmentVO;
import com.github.ls.order.dao.OrderMqDao;
import org.springframework.stereotype.Component;

@Component
public class OrderMqDaoFallBack implements OrderMqDao {
    @Override
    public ResponseData attachmentUploadMq(AddAttachmentVO vo) {
        return new ResponseData(ResponseCode.SERVER_EXCEPTION);
    }

    @Override
    public ResponseData contractCreateMq(String order_no) {
        return new ResponseData(ResponseCode.SERVER_EXCEPTION);
    }

}
