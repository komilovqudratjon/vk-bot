package com.example.bot.service;


import com.example.bot.companents.AppConstance;
import com.example.bot.model.VkObject;
import com.example.bot.model.VkUpdate;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.example.bot.companents.AppConstance.VK_API_URL;
import static com.example.bot.companents.AppConstance.VK_API_VERSION;

/**
 * @description: TODO
 * @date: 27 May 2024 $
 * @time: 8:44 PM 42 $
 * @author: Qudratjon Komilov
 */
@Service
@Slf4j
public class BotService {


    @Value("${vk.api.token}")
    private String vkApiToken;

    @Value("${vk.api.confirmation_token}")
    private String vkConfirmationToken;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Handles incoming VK updates.
     *
     * @param vkUpdate the update received from VK
     * @return response to VK
     */
    public String handleMessage(VkUpdate vkUpdate) {
        log.info("Received vkUpdate: {}", new Gson().toJson(vkUpdate));

        switch (vkUpdate.getType()) {
            case "confirmation":
                return vkConfirmationToken;
            case "message_new":
                VkObject vkObject = vkUpdate.getObject();
                String userId = String.valueOf(vkObject.getMessage().getFrom_id());
                String text = vkObject.getMessage().getText();
                sendMessage(userId, "You said: " + text);
                break;
            default:
                log.warn("Unhandled VK update type: {}", vkUpdate.getType());
        }

        return "ok";
    }

    /**
     * Sends a message to a VK user.
     *
     * @param userId the ID of the VK user
     * @param text   the message text to send
     */
    private void sendMessage(String userId, String text) {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", userId);
        params.put("message", text);
        params.put("access_token", vkApiToken);
        params.put("v", VK_API_VERSION);
        params.put("random_id", String.valueOf(System.currentTimeMillis()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);

        try {
            ResponseEntity<String> exchange = restTemplate.exchange(VK_API_URL, HttpMethod.POST, entity, String.class);
            log.info("Sent message to VK user: {}", exchange);
        } catch (RestClientException e) {
            log.error("Failed to send message to VK user: {}", userId, e);
        }
    }
}
