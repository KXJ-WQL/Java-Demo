package com.reactor.demo.block;

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @projectName: Reactor-Demo
 * @package: com.reactor.demo.block
 * @className: BlockDemo
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2025/4/28 16:13
 * @version: v2.0
 */
public class BlockDemo {

    public static void main(String[] args) {

        // 1.堵塞获取值
        List<String> block = Flux.just(1, 2, 3, 4)
                .map(x -> "ha_" + x)
                .collectList()
                .block(); // block也是实现了subscribe

        System.out.println(block); // 输出：[ha_1, ha_2, ha_3, ha_4]

    }

}
