package com.example.bot.model;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo{
	private boolean keyboard;
	private boolean inlineKeyboard;
	private List<String> button_actions;
	private String langId;
	private boolean carousel;
}