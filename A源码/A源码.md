## 问题

bucketIndex 的 hashCode 能保证同一个分区的数据写入到同一个下游中。

HoodieTableMetaClient
HoodieFlinkWriteClient
bootstrapBaseFile 是什么文件呢

## 要点

```text
1、当执行 flushRemaining ，把缓冲区的数据写入到 hudi 中之后，下一批数据需要等待 instantToWrite（） ，这个方法会进行阻塞数据的写入，指导 coordinate 生成下一个 instant。

2、writer fun 向 coordinator 发送两次事件：
WriteMetadataEvent.lastBatch 在写入成功之后发送
WriteMetadataEvent.bootstrap 任务恢复的时候发送


```


## schema 的流转信息

RowData(是一个 GenericRowData 本身只携带 data 和 RowKind，需要 RowType 解析获取数据) ->



读取的 读取 parquet 的 schema 
在队列中，数据如何转换
