/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.netty.handler.codec.mqtt;

/**
 * Reserved 0 禁止 保留
	CONNECT 1 客户端到服务端 客户端请求连接服务端
	CONNACK 2 服务端到客户端 连接报文确认
	PUBLISH 3 两个方向都允许 发布消息
	PUBACK 4 两个方向都允许 QoS 1消息发布收到确认
	PUBREC 5 两个方向都允许 发布收到（保证交付第一步）
	PUBREL 6 两个方向都允许 发布释放（保证交付第二步）
	PUBCOMP 7 两个方向都允许 QoS 2消息发布完成（保证交互第三步）
	SUBSCRIBE 8 客户端到服务端 客户端订阅请求
	SUBACK 9 服务端到客户端 订阅请求报文确认
	UNSUBSCRIBE 10 客户端到服务端 客户端取消订阅请求
	UNSUBACK 11 服务端到客户端 取消订阅报文确认
	PINGREQ 12 客户端到服务端 心跳请求
	PINGRESP 13 服务端到客户端 心跳响应
	DISCONNECT 14 客户端到服务端 客户端断开连接
	Reserved 15 禁止 保留
 * MQTT Message Types.
 */
public enum MqttMessageType {
    CONNECT(1),
    CONNACK(2),
    PUBLISH(3),
    PUBACK(4),
    PUBREC(5),
    PUBREL(6),
    PUBCOMP(7),
    SUBSCRIBE(8),
    SUBACK(9),
    UNSUBSCRIBE(10),
    UNSUBACK(11),
    PINGREQ(12),
    PINGRESP(13),
    DISCONNECT(14);

    private final int value;

    MqttMessageType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static MqttMessageType valueOf(int type) {
        for (MqttMessageType t : values()) {
            if (t.value == type) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown message type: " + type);
    }
}

