package multiThread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * �����������ʱ invokeAll(tasks) �����ύ����ʱ����
 * 
 * invokeAll(tasks, timeout, unit) �����ύ��ʱ����
 * 
 * InvokeAll��������һ�������������collection����������һ��Future����������������������ͬ�Ľṹ��
 * invokeAll��Future��ӵ����ص������У���������ʹ�����������ĵ��������Ӷ������߿��Խ������ֵ�Callable��Future ����������
 * �������������ʱ�������̱߳��ж�ʱ���߳���ʱ��ʱ����ʱ�汾��invokeAll���᷵�ؽ���� ����ʱ�޺�������δ��ɵ����񶼻ᱻȡ����
 * 
 * @author hadoop
 *
 */
public class InvokeAllThread {
    // �̶���С���̳߳أ�ͬʱֻ�ܽ���5������
    static ExecutorService mExecutor = Executors.newFixedThreadPool(5);
    
    /**
     * ����۸������
     * @author hadoop
     *
     */
    private class QuoteTask implements Callable<BigDecimal> {
        public final double price;
        public final int num;

        public QuoteTask(double price, int num) {
            this.price = price;
            this.num = num;
        }

        @Override
        public BigDecimal call() throws Exception {
            Random r = new Random();
            long time = (r.nextInt(10) + 1) * 1000;
            Thread.sleep(time);

            BigDecimal d = BigDecimal.valueOf(price * num).setScale(2);
            System.out.println("��ʱ��" + time / 1000 + "s,�����ǣ�" + price + ",�����ǣ�"
                    + num + "���ܶ��ǣ�" + d);
            return d;
        }
    }

    /**
     * ��Ԥ��ʱ�������������α�����Ϣ
     * 
     * @return
     */
    public void getRankedTravelQuotes() throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<QuoteTask>();
        // ģ��10���������α��۵�����
        for (int i = 1; i <= 20; i++) {
            tasks.add(new QuoteTask(200, i) );
        }

        /**
         * ʹ��invokeAll���������ύ��ʱ�������� Ԥ��15s��������ִ����,û��ִ�����������Զ�ȡ��
         * 
         */
        List<Future<BigDecimal>> futures = mExecutor.invokeAll(tasks, 15, TimeUnit.SECONDS);
        // ���ۺϼƼ���
        List<BigDecimal> totalPriceList = new ArrayList<BigDecimal>();

        Iterator<QuoteTask> taskIter = tasks.iterator();

        for (Future<BigDecimal> future : futures) {
             QuoteTask task = taskIter.next();
            try {
                totalPriceList.add(future.get());
            } catch (ExecutionException e) {
                // ���ؼ���ʧ�ܵ�ԭ��
                // totalPriceList.add(task.getFailureQuote(e.getCause()));
                totalPriceList.add(BigDecimal.valueOf(-1));
                 System.out.println("����ִ���쳣,������"+task.price+"�������ǣ�"+task.num);
            } catch (CancellationException e) {
                // totalPriceList.add(task.getTimeoutQuote(e));
                totalPriceList.add(BigDecimal.ZERO);
                 System.out.println("����ʱ��ȡ������,������"+task.price+"�������ǣ�"+task.num);
            }
        }
        for (BigDecimal bigDecimal : totalPriceList) {
            System.out.println(bigDecimal);
        }
        mExecutor.shutdown();
    }


    public static void main(String[] args) {
        try {
            InvokeAllThread it = new InvokeAllThread();
            it.getRankedTravelQuotes();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}