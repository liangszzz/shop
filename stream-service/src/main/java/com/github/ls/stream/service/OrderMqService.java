package com.github.ls.stream.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.order.mq.AddAttachmentVO;
import com.github.ls.stream.channel.UploadAttachmentChannel;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding({UploadAttachmentChannel.class})
public class OrderMqService {

    private final UploadAttachmentChannel uploadAttachmentChannel;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public OrderMqService(UploadAttachmentChannel uploadAttachmentChannel) {
        this.uploadAttachmentChannel = uploadAttachmentChannel;
    }

    public ResponseData attachmentUploadMq(AddAttachmentVO vo) {
        log.info("接收:" + vo.toString());

        Message<AddAttachmentVO> message = MessageBuilder.withPayload(vo).setHeader("DELAY", 4).build();
        boolean send = uploadAttachmentChannel.output().send(message,2000);

//        SendResult sendResult = rocketMQTemplate.syncSend("upload-attachment-topic", MessageBuilder.withPayload(vo).build(), 2000, 4);
//        log.info(sendResult.toString());
        return new ResponseData(true ? ResponseCode.SUCCESS : ResponseCode.SERVER_EXCEPTION);
    }

    @StreamListener(UploadAttachmentChannel.INPUT)
    public void attachmentUploadCustomer(AddAttachmentVO vo) {
        log.info("消费:" + vo.toString());
    }
}
