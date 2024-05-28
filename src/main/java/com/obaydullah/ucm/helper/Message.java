package com.obaydullah.ucm.helper;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

    private String content;
    @Builder.Default
    private MessageType type = MessageType.blue;
}
