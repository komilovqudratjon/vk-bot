package com.example.bot.controller;

import com.example.bot.model.VkUpdate;
import com.example.bot.service.BotService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @date: 27 May 2024 $
 * @time: 8:44 PM 07 $
 * @author: Qudratjon Komilov
 */


@RestController
@RequestMapping("/bot")
@AllArgsConstructor
public class BotController {

    private final BotService botService;

    @PostMapping("/message")
    public String receiveMessage(@RequestBody VkUpdate vkUpdate) {
        return botService.handleMessage(vkUpdate);
    }
}
