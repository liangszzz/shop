package com.github.ls.stream.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.order.mq.AddAttachmentVO;
import com.github.ls.stream.channel.UploadAttachmentChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding({UploadAttachmentChannel.class})
public class OrderMqService {

    private final UploadAttachmentChannel uploadAttachmentChannel;

    public OrderMqService(UploadAttachmentChannel uploadAttachmentChannel) {
        this.uploadAttachmentChannel = uploadAttachmentChannel;
    }

    public ResponseData attachmentUploadMq(AddAttachmentVO vo) {
        boolean send = uploadAttachmentChannel.output().send(MessageBuilder.withPayload(vo).build());
        return new ResponseData(send ? ResponseCode.SUCCESS : ResponseCode.SERVER_EXCEPTION);
    }

    @StreamListener(UploadAttachmentChannel.INPUT)
    public void attachmentUploadCustomer(AddAttachmentVO vo) {
        log.info("消费:" + vo.toString());
    }
}
