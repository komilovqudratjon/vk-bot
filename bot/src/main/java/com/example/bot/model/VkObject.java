package com.example.bot.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VkObject {
	private ClientInfo client_info;
	private Message message;
}