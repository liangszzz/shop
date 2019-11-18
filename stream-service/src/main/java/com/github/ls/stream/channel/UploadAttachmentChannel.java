package com.github.ls.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UploadAttachmentChannel {

    String OUTPUT = "uploadAttachmentOutput";

    @Output(OUTPUT)
    MessageChannel output();

    String INPUT = "uploadAttachmentInput";

    @Input(INPUT)
    SubscribableChannel input();
}
