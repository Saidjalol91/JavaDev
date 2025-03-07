package com.msislab.robot_ai.mqtt;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MqttMessagePayload {

        private int[] stt;
    
        @JsonProperty("connector_id")
        private int connectorId;
    
        private String ts;
        private String machine;
        @JsonProperty("model_results")
        private Map<String, Boolean> modelResults;

    }
    
