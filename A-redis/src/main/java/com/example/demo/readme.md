1.启动一个reidis
    redis-server --port 6379
2.链接上后配置策略, 临时过呢更改
    redis-cli -p 6379
    CONFIG GET *
    CONFIG set protected-mode no
