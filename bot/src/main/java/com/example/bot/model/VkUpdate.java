package com.example.bot.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VkUpdate{
	private String event_id;
	private String group_id;
	private String v;
	private String type;
	private VkObject object;
}