import io.micrometer.core.instrument.util.NamedThreadFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @projectName: SpringBoot-dome
 * @package: PACKAGE_NAME
 * @className: CompletableFutrueTest
 * @author: WQL-KXJ
 * @description: TODO
 * @date: 2024/5/24 13:40
 * @version: v1.0
 */
public class CompletableFutrueTest {

    //自定义线程池
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            1,
            10,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1024),
            new NamedThreadFactory("CompletableFutrue-test-pool-thread-%d"),
            new ThreadPoolExecutor.AbortPolicy());

    @Test
    public void testRunAsync() throws ExecutionException, TimeoutException, InterruptedException {
        //泛型表示返回值类型
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("我是在线程："+Thread.currentThread().getName()+"里执行的");
        },executorService);//指定自定义线程池

        //判断异步任务执行是否完成1
        System.out.println("异步任务执行是否完成1: " + voidCompletableFuture.isDone());
        //堵塞等待执行完成，并获取异步执行的结果
        System.out.println("join()堵塞并返回结果：" + voidCompletableFuture.join());
        System.out.println("get()堵塞并返回结果：" + voidCompletableFuture.get(200,TimeUnit.MILLISECONDS));

        //判断异步任务执行是否完成2
        System.out.println("异步任务执行是否完成2: " + voidCompletableFuture.isDone());
    }

    @Test
    public void testSupplyAsync() throws ExecutionException, InterruptedException {
        //异步执行任务并带有返回值
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("在线程" + Thread.currentThread().getName() + "里面执行");
            return "supplyAsync带返回值";
        });
        //堵塞等待执行完成，并获取异步执行的结果
        System.out.println("堵塞等待结果："+stringCompletableFuture.get());
    }

    @Test
    public void testThenAccept() throws ExecutionException, InterruptedException {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("在线程" + Thread.currentThread().getName() + "里面执行");
                    return "supplyAsync带返回值";
                }, executorService);

        //1.thenApply使用
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture
                //得到异步处理结果并进行再处理返回
                .thenApply(res -> res + "thenApply再处理");
        //堵塞获取返回值
        System.out.println("thenApply()方法\t" + stringCompletableFuture1.get());

        //2.thenAccept使用
        CompletableFuture<Void> stringCompletableFuture2 = stringCompletableFuture
                //得到异步处理结果并进行再处理返回
                .thenAccept(res -> System.out.println(res));
        //堵塞获取返回值
        System.out.println("thenAccept()的get方法\t" + stringCompletableFuture2.get());
    }

    @Test
    public void testThenCompose() throws ExecutionException, InterruptedException {
        Long itemID=2000L, userid=3L;
        CompletableFuture<String> stringCompletableFuture = getItem(itemID)
                .thenCompose(res -> {
                    return getOrder(res, userid);
                });
        System.out.println("订单信息："+stringCompletableFuture.get());
    }

    @Test
    public void testThenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> weight = getWeight();
        CompletableFuture<Double> height = getHeight();
        //thenCombine合并处理计算bmi
        CompletableFuture<Double> doubleCompletableFuture = weight.thenCombine(height, (w, h) -> {
            double heightInmeter = h / 100;
            return w / (heightInmeter * heightInmeter);
        });
        System.out.println("BMI:" + doubleCompletableFuture.get());
    }

    @Test
    public void testThenExceptionally() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> "1111")
                .thenApply(ret -> {
                    System.out.println("thenApply处理1");
                    return 1;
                })
                .thenApply(ret -> 2 / 0)
                .thenApply(ret -> {
                    System.out.println("thenApply处理3");
                    return 3;
                })
                //exceptionally异常处理：任何一个链式操作出现异常都会进入exceptionally进行异常处理
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return -1;
                });
        System.out.println(exceptionally.get());
    }

    @Test
    public void testHandle() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> "1111")
                .thenApply(ret -> {
                    System.out.println("thenApply处理1");
                    return 1;
                })
                .thenApply(ret -> 2 / 1)
                .thenApply(ret -> {
                    System.out.println("thenApply处理3");
                    return 3;
                })
                //handle异常处理：任何一个链式操作出现异常都会进入exceptionally进行异常处理
                .handle((res, ex) -> {
                    if(ex!=null){
                        ex.printStackTrace();
                        return res - 11;
                    }
                    return res;
                });
        System.out.println(exceptionally.get());
    }

    @Test
    public void testComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> "1111")
                .thenApply(ret -> {
                    System.out.println("thenApply处理1");
                    return 1;
                })
                .thenApply(ret -> 2 / 1)
                .thenApply(ret -> {
                    System.out.println("thenApply处理3");
                    return 3;
                })
                .whenComplete((res, ex) -> {
                    if(ex!=null){
                        ex.printStackTrace();
                    }else {
                        System.out.println("未发生异常！！！");
                    }
                });
        System.out.println(exceptionally.get());
    }

    @Test
    public void testAllOf() {
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> cfList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            String tableName = "table" + i;
            CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
                //模拟耗时操作
                try {
                    Thread.sleep(new Random().nextInt(4) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return tableName + "处理结果";
            });
            cfList.add(stringCompletableFuture);
        }
        //等待cflist中所有的cf执行完成
        CompletableFuture.allOf(cfList.toArray(new CompletableFuture[0])).join();
        System.out.println("异步任务已经全部执行完成！");
        for (CompletableFuture<String> completableFuture : cfList){
            System.out.println(completableFuture.join());
        }
    }

    @Test
    public void testAnyOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            //模拟耗时操作
            try {
                Thread.sleep(new Random().nextInt(4) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "处理结果1";
        });

        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            //模拟耗时操作
            try {
                Thread.sleep(new Random().nextInt(4) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "处理结果2";
        });

        CompletableFuture<String> stringCompletableFuture3 = CompletableFuture.supplyAsync(() -> {
            //模拟耗时操作
            try {
                Thread.sleep(new Random().nextInt(4) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "处理结果3";
        });

        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(stringCompletableFuture1, stringCompletableFuture2, stringCompletableFuture3);
        System.out.println("最先完成的是："+objectCompletableFuture.get());
    }

    //获取商品信息
    public CompletableFuture<String> getItem(Long itemId){
        return CompletableFuture.supplyAsync(()->{
            return itemId+"男爵手办--200RMB";
        });
    }

    //通过商品信息获取订单信息
    public CompletableFuture<String> getOrder(String item,Long userid){
        return CompletableFuture.completedFuture("用户id："+userid+"\n商品信息"+item);
    }

    //获取模拟的体重
    private CompletableFuture<Double> getWeight(){
        return CompletableFuture.supplyAsync(()->70.0d);
    }

    //获取模拟的体重
    private CompletableFuture<Double> getHeight(){
        return CompletableFuture.supplyAsync(()->170.0d);
    }

}
