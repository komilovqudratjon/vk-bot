package com.example.bot.model;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message{
	private String date;
	private String from_id;
	private List<VkObject> attachments;
	private boolean is_hidden;
	private String version;
	private String out;
	private String conversation_message_id;
	private String peerId;
	private boolean important;
	private boolean is_mentioned_user;
	private List<VkObject> fwd_messages;
	private String id;
	private String randomId;
	private String text;
}